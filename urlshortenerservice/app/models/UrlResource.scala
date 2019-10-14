package models

import play.api.libs.json._

/**
 * Defines URL Resource class
 * */

case class UrlResource(id: Int, originalUrl: String, shortUrl: String){

  def patch(originalUrl: String, shortUrl:String): UrlResource =
    this.copy(originalUrl = this.originalUrl, shortUrl = this.shortUrl)
}

object UrlResource {
  implicit val urlFormat = Json.format[UrlResource]
}
