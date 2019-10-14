package controllers

import javax.inject._
import models._
import utils._
import play.api.libs.json.Json
import play.api.mvc._
import utils.UrlShortener

import scala.concurrent.{ExecutionContext}


/**
 *
 * Url Controller handles the various routes of the api service.
 *
 * */


class UrlController @Inject()(repo: UrlRepository, cc: ControllerComponents)
                             (implicit ec: ExecutionContext)
  extends AbstractController(cc) {


  val SHORT_URL_DOMAIN: String = Config.SHORT_URL_DOMAIN
  val HTTP_PREFIX: String = Config.HTTP_URL_PREFIX
  val WELCOME: String = Config.WELCOME_MESSAGE



  def index() = Action { implicit request =>
    Ok(Json.obj("Message" -> WELCOME))
  }


  def shortenUrl(originalUrl: String) = Action.async { implicit  request =>
    for {
      id <- repo.create(originalUrl)
      upd <- repo.updateWithShortUrl(id, UrlShortener.urlParse(originalUrl, UrlShortener.urlRegex))
      shortUrl <- repo.getShortUrl(id).map(url => Ok(Json.obj("shortUrl" -> s"$SHORT_URL_DOMAIN$url")))
    } yield shortUrl
  }


  def getOriginalUrl(shortUrl: String) = Action.async {implicit request =>
    repo.getOriginalUrl(shortUrl).map(url => Ok(Json.obj("originalUrl" -> url)))
  }



  def redirect(shortUrl: String) = Action.async { implicit request =>
    repo.getOriginalUrl(shortUrl).map(url => Redirect(s"$HTTP_PREFIX$url"))
  }


  def deleteUrl(shortUrl: String) = Action.async { implicit request =>
    repo.delete(shortUrl).map(rowsAffected => Ok(Json.obj("RowsAffected" -> rowsAffected)))
  }


}

