
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/corbandalas/Java/workspace/msp/conf/routes
// @DATE:Wed Feb 03 12:43:59 MSK 2016

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:8
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:8
  class ReverseSwaggerController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def swagger: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SwaggerController.swagger",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "swagger"})
        }
      """
    )
  
  }

  // @LINE:25
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
        }
      """
    )
  
  }

  // @LINE:16
  class ReversePropertyController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PropertyController.update",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/property/update"})
        }
      """
    )
  
    // @LINE:16
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PropertyController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/property/create"})
        }
      """
    )
  
    // @LINE:22
    def retrieveByID: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PropertyController.retrieveByID",
      """
        function(propertyID) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/property/get/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("propertyID", encodeURIComponent(propertyID))})
        }
      """
    )
  
    // @LINE:20
    def retrieveAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PropertyController.retrieveAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/property/list"})
        }
      """
    )
  
  }

  // @LINE:11
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }


}