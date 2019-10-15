// @GENERATOR:play-routes-compiler
// @SOURCE:/home/bryannx/Documents/MOIA/coding-challenge-brian-n/urlshortenerservice/conf/routes
// @DATE:Tue Oct 15 04:22:46 CEST 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseUrlController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def redirect(shortUrl:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "go/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("shortUrl", shortUrl)))
    }
  
    // @LINE:10
    def getOriginalUrl(shortUrl:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "geturl/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("shortUrl", shortUrl)))
    }
  
    // @LINE:8
    def shortenUrl(originalUrl:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "shorten/" + implicitly[play.api.mvc.PathBindable[String]].unbind("originalUrl", originalUrl))
    }
  
    // @LINE:14
    def deleteUrl(shortUrl:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "delete/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("shortUrl", shortUrl)))
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }


}
