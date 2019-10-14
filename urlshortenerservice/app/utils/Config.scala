package utils

import com.typesafe.config.ConfigFactory

object Config {

  private val conf: com.typesafe.config.Config = ConfigFactory.load

  val SHORT_URL_DOMAIN: String = conf.getString("shortener.short-url-domain")

  val HTTP_URL_PREFIX: String = "http://"

  val WELCOME_MESSAGE: String = "Welcome to the URL Shortener Service!"

}
