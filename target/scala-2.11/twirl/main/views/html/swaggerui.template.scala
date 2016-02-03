
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object swaggerui_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class swaggerui extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html>
    <head>
        <title>Swagger UI</title>
        <link href="/assets/javascripts/swagger/css/reset.css" media='screen' rel='stylesheet' type='text/css'/>
        <link href="/assets/javascripts/swagger/css/reset.css" media='print' rel='stylesheet' type='text/css'/>
        <link href="/assets/javascripts/swagger/css/screen.css" media='screen' rel='stylesheet' type='text/css'/>
        <link href="/assets/javascripts/swagger/css/screen.css" media='print' rel='stylesheet' type='text/css'/>
        <script type="text/javascript" src="/assets/javascripts/swagger/lib/shred.bundle.js"></script>
        <script type="text/javascript" src="/assets/javascripts/swagger/lib/jquery-1.8.0.min.js"></script>
        <script type="text/javascript" src="/assets/javascripts/swagger/lib/jquery.slideto.min.js"></script>
        <script type="text/javascript" src="/assets/javascripts/swagger/lib/jquery.wiggle.min.js"></script>
        <script type="text/javascript" src="/assets/javascripts/swagger/lib/jquery.ba-bbq.min.js"></script>
        <script type="text/javascript" src="/assets/javascripts/swagger/lib/handlebars-2.0.0.js"></script>
        <script type="text/javascript" src="/assets/javascripts/swagger/lib/underscore-min.js"></script>
        <script type="text/javascript" src="/assets/javascripts/swagger/lib/backbone-min.js"></script>
        <script type="text/javascript" src="/assets/javascripts/swagger/lib/swagger-client.js"></script>
        <script type="text/javascript" src="/assets/javascripts/swagger/swagger-ui.js"></script>
        <script type="text/javascript" src="/assets/javascripts/swagger/lib/highlight.7.3.pack.js"></script>
        <script type="text/javascript" src="/assets/javascripts/swagger/lib/marked.js"></script>
        <script type="text/javascript" src="/assets/javascripts/swagger/lib/swagger-oauth.js"></script>

        <script type="text/javascript">
         $(function () """),format.raw/*24.24*/("""{"""),format.raw/*24.25*/("""
             """),format.raw/*25.14*/("""var url = window.location.search.match(/url=([^&]+)/);
             if (url && url.length > 1) """),format.raw/*26.41*/("""{"""),format.raw/*26.42*/("""
                 """),format.raw/*27.18*/("""url = decodeURIComponent(url[1]);
             """),format.raw/*28.14*/("""}"""),format.raw/*28.15*/(""" """),format.raw/*28.16*/("""else """),format.raw/*28.21*/("""{"""),format.raw/*28.22*/("""
                 """),format.raw/*29.18*/("""url="/api-docs";
             """),format.raw/*30.14*/("""}"""),format.raw/*30.15*/("""
             """),format.raw/*31.14*/("""window.swaggerUi = new SwaggerUi("""),format.raw/*31.47*/("""{"""),format.raw/*31.48*/("""
                 """),format.raw/*32.18*/("""url: url,
                 dom_id: "swagger-ui-container",
                 supportedSubmitMethods: ['get', 'post', 'put', 'delete', 'patch'],
                 onComplete: function(swaggerApi, swaggerUi)"""),format.raw/*35.61*/("""{"""),format.raw/*35.62*/("""
                     """),format.raw/*36.22*/("""$('pre code').each(function(i, e) """),format.raw/*36.56*/("""{"""),format.raw/*36.57*/("""
                         """),format.raw/*37.26*/("""hljs.highlightBlock(e)
                     """),format.raw/*38.22*/("""}"""),format.raw/*38.23*/(""");
                 """),format.raw/*39.18*/("""}"""),format.raw/*39.19*/(""",
                 onFailure: function(data) """),format.raw/*40.44*/("""{"""),format.raw/*40.45*/("""
                     """),format.raw/*41.22*/("""log("Unable to Load SwaggerUI");
                 """),format.raw/*42.18*/("""}"""),format.raw/*42.19*/(""",
                 docExpansion: "none",
                 sorter : "alpha"
             """),format.raw/*45.14*/("""}"""),format.raw/*45.15*/(""");

             window.swaggerUi.load();
         """),format.raw/*48.10*/("""}"""),format.raw/*48.11*/(""");
      </script>

        <style>
        #api_selector, .footer """),format.raw/*52.32*/("""{"""),format.raw/*52.33*/("""
        """),format.raw/*53.9*/("""display: none !important;
        """),format.raw/*54.9*/("""}"""),format.raw/*54.10*/("""
        """),format.raw/*55.9*/("""</style>
    </head>
    <body class="swagger-section">
        <div id='header'>
            <div class="swagger-ui-wrap">
                <a id="logo" href="http://swagger.io">swagger</a>
                <form id='api_selector'>
                    <div class='input'><input placeholder="http://example.com/api" id="input_baseUrl" name="baseUrl" type="text"/></div>
                    <div class='input'><input placeholder="api_key" id="input_apiKey" name="apiKey" type="text"/></div>
                    <div class='input'><a id="explore" href="#">Explore</a></div>
                </form>
            </div>
        </div>
        <div id="message-bar" class="swagger-ui-wrap">&nbsp;</div>
        <div id="swagger-ui-container" class="swagger-ui-wrap"></div>
    </body>
</html>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object swaggerui extends swaggerui_Scope0.swaggerui
              /*
                  -- GENERATED --
                  DATE: Tue Feb 02 20:16:36 MSK 2016
                  SOURCE: /Users/corbandalas/Java/workspace/msp/app/views/swaggerui.scala.html
                  HASH: 0b5d01bbf0aa795dbc3a7ec79f07745172ab2ab5
                  MATRIX: 617->0|2591->1946|2620->1947|2662->1961|2785->2056|2814->2057|2860->2075|2935->2122|2964->2123|2993->2124|3026->2129|3055->2130|3101->2148|3159->2178|3188->2179|3230->2193|3291->2226|3320->2227|3366->2245|3597->2448|3626->2449|3676->2471|3738->2505|3767->2506|3821->2532|3893->2576|3922->2577|3970->2597|3999->2598|4072->2643|4101->2644|4151->2666|4229->2716|4258->2717|4374->2805|4403->2806|4482->2857|4511->2858|4606->2925|4635->2926|4671->2935|4732->2969|4761->2970|4797->2979
                  LINES: 25->1|48->24|48->24|49->25|50->26|50->26|51->27|52->28|52->28|52->28|52->28|52->28|53->29|54->30|54->30|55->31|55->31|55->31|56->32|59->35|59->35|60->36|60->36|60->36|61->37|62->38|62->38|63->39|63->39|64->40|64->40|65->41|66->42|66->42|69->45|69->45|72->48|72->48|76->52|76->52|77->53|78->54|78->54|79->55
                  -- GENERATED --
              */
          