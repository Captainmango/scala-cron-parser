package formatter

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import support.{ParsedCron, TimeIntervals}

import java.io.ByteArrayOutputStream

class PrinterTest extends AnyFlatSpec with Matchers {
  val parsedCronsUnderTest: List[ParsedCron] = List(
    ParsedCron(TimeIntervals.Minute, List(1)),
    ParsedCron(TimeIntervals.Hour, List(1)),
    ParsedCron(TimeIntervals.DayOfMonth, List(1)),
    ParsedCron(TimeIntervals.Month, List(1)),
    ParsedCron(TimeIntervals.DayOfWeek, List(1))
  )

  val stdOutMock = new ByteArrayOutputStream()

  "cron printer" should "be able to print a list of parsed cron expressions" in {
    Console.withOut(stdOutMock) {
      CronPrinter.print(parsedCronsUnderTest)
    }

    stdOutMock.toString should include("Minute: 1")
    stdOutMock.toString should include("Hour: 1")
    stdOutMock.toString should include("DayOfMonth: 1")
    stdOutMock.toString should include("Month: 1")
    stdOutMock.toString should include("DayOfWeek: 1")
  }
}
