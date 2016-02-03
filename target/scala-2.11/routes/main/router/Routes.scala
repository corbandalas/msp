
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/corbandalas/Java/workspace/msp/conf/routes
// @DATE:Wed Feb 03 12:43:59 MSK 2016

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

object Routes extends Routes

class Routes extends GeneratedRouter {

  import ReverseRouteContext.empty

  override val errorHandler: play.api.http.HttpErrorHandler = play.api.http.LazyHttpErrorHandler

  private var _prefix = "/"

  def withPrefix(prefix: String): Routes = {
    _prefix = prefix
    router.RoutesPrefix.setPrefix(prefix)
    
    this
  }

  def prefix: String = _prefix

  lazy val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation: Seq[(String, String, String)] = List(
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api-docs""", """@pl.matisoft.swagger.ApiHelpController@.getResources"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """swagger""", """@controllers.SwaggerController@.swagger()"""),
    ("""GET""", prefix, """@controllers.Application@.index"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api-docs/api/property""", """@pl.matisoft.swagger.ApiHelpController@.getResource(path:String = "/api/property")"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/property/create""", """@controllers.PropertyController@.create()"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/property/update""", """@controllers.PropertyController@.update()"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/property/list""", """@controllers.PropertyController@.retrieveAll()"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/property/get/$propertyID<[^/]+>""", """@controllers.PropertyController@.retrieveByID(propertyID:String)"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val pl_matisoft_swagger_ApiHelpController_getResources0_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api-docs")))
  )
  private[this] lazy val pl_matisoft_swagger_ApiHelpController_getResources0_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[pl.matisoft.swagger.ApiHelpController]).getResources,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "pl.matisoft.swagger.ApiHelpController",
      "getResources",
      Nil,
      "GET",
      """""",
      this.prefix + """api-docs"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_SwaggerController_swagger1_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("swagger")))
  )
  private[this] lazy val controllers_SwaggerController_swagger1_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.SwaggerController]).swagger(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SwaggerController",
      "swagger",
      Nil,
      "GET",
      """""",
      this.prefix + """swagger"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_Application_index2_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_index2_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """ Index""",
      this.prefix + """"""
    )
  )

  // @LINE:14
  private[this] lazy val pl_matisoft_swagger_ApiHelpController_getResource3_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api-docs/api/property")))
  )
  private[this] lazy val pl_matisoft_swagger_ApiHelpController_getResource3_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[pl.matisoft.swagger.ApiHelpController]).getResource(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "pl.matisoft.swagger.ApiHelpController",
      "getResource",
      Seq(classOf[String]),
      "GET",
      """ Property API""",
      this.prefix + """api-docs/api/property"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_PropertyController_create4_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/property/create")))
  )
  private[this] lazy val controllers_PropertyController_create4_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.PropertyController]).create(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PropertyController",
      "create",
      Nil,
      "POST",
      """""",
      this.prefix + """api/property/create"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_PropertyController_update5_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/property/update")))
  )
  private[this] lazy val controllers_PropertyController_update5_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.PropertyController]).update(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PropertyController",
      "update",
      Nil,
      "POST",
      """""",
      this.prefix + """api/property/update"""
    )
  )

  // @LINE:20
  private[this] lazy val controllers_PropertyController_retrieveAll6_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/property/list")))
  )
  private[this] lazy val controllers_PropertyController_retrieveAll6_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.PropertyController]).retrieveAll(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PropertyController",
      "retrieveAll",
      Nil,
      "GET",
      """""",
      this.prefix + """api/property/list"""
    )
  )

  // @LINE:22
  private[this] lazy val controllers_PropertyController_retrieveByID7_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/property/get/"), DynamicPart("propertyID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PropertyController_retrieveByID7_invoker = createInvoker(
    play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.PropertyController]).retrieveByID(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PropertyController",
      "retrieveByID",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """api/property/get/$propertyID<[^/]+>"""
    )
  )

  // @LINE:25
  private[this] lazy val controllers_Assets_at8_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at8_invoker = createInvoker(
    controllers.Assets.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/$file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case pl_matisoft_swagger_ApiHelpController_getResources0_route(params) =>
      call { 
        pl_matisoft_swagger_ApiHelpController_getResources0_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[pl.matisoft.swagger.ApiHelpController]).getResources)
      }
  
    // @LINE:8
    case controllers_SwaggerController_swagger1_route(params) =>
      call { 
        controllers_SwaggerController_swagger1_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.SwaggerController]).swagger())
      }
  
    // @LINE:11
    case controllers_Application_index2_route(params) =>
      call { 
        controllers_Application_index2_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.Application]).index)
      }
  
    // @LINE:14
    case pl_matisoft_swagger_ApiHelpController_getResource3_route(params) =>
      call(Param[String]("path", Right("/api/property"))) { (path) =>
        pl_matisoft_swagger_ApiHelpController_getResource3_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[pl.matisoft.swagger.ApiHelpController]).getResource(path))
      }
  
    // @LINE:16
    case controllers_PropertyController_create4_route(params) =>
      call { 
        controllers_PropertyController_create4_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.PropertyController]).create())
      }
  
    // @LINE:18
    case controllers_PropertyController_update5_route(params) =>
      call { 
        controllers_PropertyController_update5_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.PropertyController]).update())
      }
  
    // @LINE:20
    case controllers_PropertyController_retrieveAll6_route(params) =>
      call { 
        controllers_PropertyController_retrieveAll6_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.PropertyController]).retrieveAll())
      }
  
    // @LINE:22
    case controllers_PropertyController_retrieveByID7_route(params) =>
      call(params.fromPath[String]("propertyID", None)) { (propertyID) =>
        controllers_PropertyController_retrieveByID7_invoker.call(play.api.Play.maybeApplication.map(_.injector).getOrElse(play.api.inject.NewInstanceInjector).instanceOf(classOf[controllers.PropertyController]).retrieveByID(propertyID))
      }
  
    // @LINE:25
    case controllers_Assets_at8_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at8_invoker.call(controllers.Assets.at(path, file))
      }
  }
}