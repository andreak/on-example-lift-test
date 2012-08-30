package bootstrap.liftweb

import net.liftweb.http._
import net.liftweb.util._
import net.liftweb.util.Helpers._
import net.liftweb.http.js.JE.JsRaw
import js.jquery.{JQueryArtifacts, JQuery14Artifacts}

import net.liftweb.sitemap.SiteMap
import xml.Text
import java.util.concurrent.ExecutorService
import net.liftweb.actor.{ILAExecute, LAScheduler}
import net.liftweb.common.{Full, Logger}
import javax.annotation.Resource
import com.sun.org.apache.xml.internal.security.utils.I18n

class Boot {

	@Resource(name = "liftSchedulerExecutor")
	val liftSchedulerExecutor: ExecutorService = null

	def boot() {
		// Do nothing. We don't want Lift to try to mess up our logging. Having log4j.xml in classpath is sufficient
		Logger.setup = Full(() => ())

		LiftRules.htmlProperties.default.set((r: Req) => new XHtmlInHtml5OutProperties(r.userAgent))

		LiftRules.templateSuffixes = "lift" :: LiftRules.templateSuffixes

		LiftRules.addToPackages("no.officenet.example.lift")

		LiftRules.jsArtifacts = JQueryArtifacts

	}

}