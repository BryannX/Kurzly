// @GENERATOR:play-routes-compiler
// @SOURCE:/home/bryannx/Documents/MOIA/coding-challenge-brian-n/urlshortenerservice/conf/routes
// @DATE:Tue Oct 15 04:22:46 CEST 2019

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseUrlController UrlController = new controllers.ReverseUrlController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseUrlController UrlController = new controllers.javascript.ReverseUrlController(RoutesPrefix.byNamePrefix());
  }

}
