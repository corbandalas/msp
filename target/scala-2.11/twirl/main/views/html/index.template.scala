
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.19*/("""

"""),_display_(/*3.2*/main("Welcome to Play 2.1")/*3.29*/ {_display_(Seq[Any](format.raw/*3.31*/("""
    
    """),_display_(/*5.6*/play20/*5.12*/.welcome(message)),format.raw/*5.29*/("""
    
""")))}),format.raw/*7.2*/("""
"""))
      }
    }
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Tue Feb 02 20:28:19 MSK 2016
                  SOURCE: /Users/corbandalas/Java/workspace/msp/app/views/index.scala.html
                  HASH: 13acb574f11b989a8199bc21358712f8b091551c
                  MATRIX: 527->1|639->18|667->21|702->48|741->50|777->61|791->67|828->84|864->91
                  LINES: 20->1|25->1|27->3|27->3|27->3|29->5|29->5|29->5|31->7
                  -- GENERATED --
              */
          