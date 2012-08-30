package no.officenet.example.lift.comet

import net.liftweb.http.{SHtml, CometActor}
import net.liftweb.http.js.JE.{Str, Call}
import java.util.Date
import xml.Text

class CometTest extends CometActor {

	def render = {
		".cometContent" #> (
			"div" #> SHtml.a(() => {Call("console.log", Str("Called at " + new Date())).cmd}, Text("Click me"))
			)
	}
}
