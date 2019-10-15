// @GENERATOR:play-routes-compiler
// @SOURCE:/home/bryannx/Documents/MOIA/coding-challenge-brian-n/urlshortenerservice/conf/routes
// @DATE:Tue Oct 15 04:22:46 CEST 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
