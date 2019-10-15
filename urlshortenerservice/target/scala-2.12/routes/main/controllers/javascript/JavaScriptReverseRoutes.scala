// @GENERATOR:play-routes-compiler
// @SOURCE:/home/bryannx/Documents/MOIA/coding-challenge-brian-n/urlshortenerservice/conf/routes
// @DATE:Tue Oct 15 04:22:46 CEST 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {

  // @LINE:6
  class ReverseUrlController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def redirect: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UrlController.redirect",
      """
        function(shortUrl0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "go/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("shortUrl", shortUrl0))})
        }
      """
    )
  
    // @LINE:10
    def getOriginalUrl: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UrlController.getOriginalUrl",
      """
        function(shortUrl0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "geturl/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("shortUrl", shortUrl0))})
        }
      """
    )
  
    // @LINE:8
    def shortenUrl: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UrlController.shortenUrl",
      """
        function(originalUrl0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "shorten/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("originalUrl", originalUrl0)})
        }
      """
    )
  
    // @LINE:14
    def deleteUrl: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UrlController.deleteUrl",
      """
        function(shortUrl0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "delete/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("shortUrl", shortUrl0))})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UrlController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }


}
