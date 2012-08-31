package no.officenet.example.lift.comet

import net.liftweb.http.{SHtml, CometActor}
import net.liftweb.http.js.JE.{Str, Call}
import java.util.Date
import xml.Text
import net.liftweb.http.js.JsCmds.SetHtml

class CometTest extends CometActor {

	case class Msg(msg: String)

	override def lowPriority = {
		case Msg(s) => partialUpdate(SetHtml("cometResponse", Text(s)))
	}

	def render = {
		".cometContent" #> (
			"@a" #> SHtml.a(() => {Call("console.log", Str("Called at " + new Date())).cmd}, Text("Click me")) &
			"@b" #> SHtml.a(() => {this ! Msg("Updated at " + new Date())}, Text("Click me for updating time"))
			)
	}
}
