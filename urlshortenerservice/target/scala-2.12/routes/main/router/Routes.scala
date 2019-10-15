// @GENERATOR:play-routes-compiler
// @SOURCE:/home/bryannx/Documents/MOIA/coding-challenge-brian-n/urlshortenerservice/conf/routes
// @DATE:Tue Oct 15 04:22:46 CEST 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  UrlController_0: controllers.UrlController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    UrlController_0: controllers.UrlController
  ) = this(errorHandler, UrlController_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, UrlController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.UrlController.index"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """shorten/""" + "$" + """originalUrl<.+>""", """controllers.UrlController.shortenUrl(originalUrl:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """geturl/""" + "$" + """shortUrl<[^/]+>""", """controllers.UrlController.getOriginalUrl(shortUrl:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """go/""" + "$" + """shortUrl<[^/]+>""", """controllers.UrlController.redirect(shortUrl:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """delete/""" + "$" + """shortUrl<[^/]+>""", """controllers.UrlController.deleteUrl(shortUrl:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_UrlController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_UrlController_index0_invoker = createInvoker(
    UrlController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UrlController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_UrlController_shortenUrl1_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("shorten/"), DynamicPart("originalUrl", """.+""",false)))
  )
  private[this] lazy val controllers_UrlController_shortenUrl1_invoker = createInvoker(
    UrlController_0.shortenUrl(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UrlController",
      "shortenUrl",
      Seq(classOf[String]),
      "PUT",
      this.prefix + """shorten/""" + "$" + """originalUrl<.+>""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_UrlController_getOriginalUrl2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("geturl/"), DynamicPart("shortUrl", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UrlController_getOriginalUrl2_invoker = createInvoker(
    UrlController_0.getOriginalUrl(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UrlController",
      "getOriginalUrl",
      Seq(classOf[String]),
      "GET",
      this.prefix + """geturl/""" + "$" + """shortUrl<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_UrlController_redirect3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("go/"), DynamicPart("shortUrl", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UrlController_redirect3_invoker = createInvoker(
    UrlController_0.redirect(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UrlController",
      "redirect",
      Seq(classOf[String]),
      "GET",
      this.prefix + """go/""" + "$" + """shortUrl<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_UrlController_deleteUrl4_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("delete/"), DynamicPart("shortUrl", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UrlController_deleteUrl4_invoker = createInvoker(
    UrlController_0.deleteUrl(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UrlController",
      "deleteUrl",
      Seq(classOf[String]),
      "DELETE",
      this.prefix + """delete/""" + "$" + """shortUrl<[^/]+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_UrlController_index0_route(params@_) =>
      call { 
        controllers_UrlController_index0_invoker.call(UrlController_0.index)
      }
  
    // @LINE:8
    case controllers_UrlController_shortenUrl1_route(params@_) =>
      call(params.fromPath[String]("originalUrl", None)) { (originalUrl) =>
        controllers_UrlController_shortenUrl1_invoker.call(UrlController_0.shortenUrl(originalUrl))
      }
  
    // @LINE:10
    case controllers_UrlController_getOriginalUrl2_route(params@_) =>
      call(params.fromPath[String]("shortUrl", None)) { (shortUrl) =>
        controllers_UrlController_getOriginalUrl2_invoker.call(UrlController_0.getOriginalUrl(shortUrl))
      }
  
    // @LINE:12
    case controllers_UrlController_redirect3_route(params@_) =>
      call(params.fromPath[String]("shortUrl", None)) { (shortUrl) =>
        controllers_UrlController_redirect3_invoker.call(UrlController_0.redirect(shortUrl))
      }
  
    // @LINE:14
    case controllers_UrlController_deleteUrl4_route(params@_) =>
      call(params.fromPath[String]("shortUrl", None)) { (shortUrl) =>
        controllers_UrlController_deleteUrl4_invoker.call(UrlController_0.deleteUrl(shortUrl))
      }
  }
}
