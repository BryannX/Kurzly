package models

import javax.inject.{ Inject, Singleton }
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile
import utils.UrlShortener

import scala.concurrent.{ Future, ExecutionContext }


/**
 * A Repository for Urls and the relevant DB operations.
 */


@Singleton
class UrlRepository @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  private val urls = TableQuery[UrlTable]

  /**
   * Url table defines the schema used in the database to persist urls and their shortened forms.
   */

  private class UrlTable(tag: Tag) extends Table[UrlResource](tag, "urls") {

    def id = column[Int]("id", O.PrimaryKey, O.AutoInc)

    def originalUrl = column[String]("originalUrl")

    def shortUrl = column[String]("shortUrl")

    def * = (id, originalUrl, shortUrl) <> ((UrlResource.apply _).tupled, UrlResource.unapply)
  }


  def create(originalUrl: String): Future[Int] = db.run {
    (urls returning urls.map(_.id)) += UrlResource(0, originalUrl, originalUrl)
  }


  def updateWithShortUrl(id: Int, originalUrl: String): Future[Int] = db.run {
    urls.insertOrUpdate(UrlResource(id, originalUrl,
      UrlShortener.idbase62toUrl(UrlShortener.idToBase62(id))))
  }


  def getShortUrl(id: Int): Future[String] = db.run{
    urls.filter(_.id === id).map(_.shortUrl).result.head
  }


  def getOriginalUrl(shortUrl: String): Future[String] = db.run{
    urls.filter(_.shortUrl === shortUrl).map(_.originalUrl).result.head
  }


  def delete(shortUrl: String): Future[Int] = db.run{
    urls.filter(_.shortUrl === shortUrl).delete
  }
}
