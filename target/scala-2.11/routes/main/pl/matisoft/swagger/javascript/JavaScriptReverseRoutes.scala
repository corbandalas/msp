
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/corbandalas/Java/workspace/msp/conf/routes
// @DATE:Wed Feb 03 12:43:59 MSK 2016

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:7
package pl.matisoft.swagger.javascript {
  import ReverseRouteContext.empty

  // @LINE:7
  class ReverseApiHelpController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def getResources: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "pl.matisoft.swagger.ApiHelpController.getResources",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api-docs"})
        }
      """
    )
  
    // @LINE:14
    def getResource: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "pl.matisoft.swagger.ApiHelpController.getResource",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api-docs/api/property"})
        }
      """
    )
  
  }


}