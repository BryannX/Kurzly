package utils

import scala.util.matching.Regex

object UrlShortener {

  /**
   *Url Shortener Algorithm
   *
   * Upon receipt of a url from the api endpoint, the url is persisted in a postgres SQL database which returns an autoincremented id.
   * The url shortener algorithm takes the id and converts it to a 'base 62' code by taking it remainder value from modulo 62 and mapping it
   * to one of 62 ascii characters. The resulting url is then persisted to the database.
   *
   */

  def idToBase62(id: Int): List[Int] = if(id <= 0) Nil else id%62 :: idToBase62(id/62)


  def idbase62toUrl(ls: List[Int]): String = ls.map(n => "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".charAt(n)).reverse.mkString("")



  val urlRegex: Regex = "(http://|https://|www.)".r


  def urlParse(url: String, urlRegex: Regex): String = urlRegex replaceAllIn(url, "")


}
