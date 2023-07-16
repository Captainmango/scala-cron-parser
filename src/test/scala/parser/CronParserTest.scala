package parser

import parser.CronParser
import support.{Cron, ParsedCron, TimeIntervals}
import org.scalatest.flatspec.AnyFlatSpec

class CronParserTest extends AnyFlatSpec {
  it should "be able to pass a cron" in {
    val cron: Cron = Cron("1", "1", "1", "1", "1")
    assert(CronParser.execute(cron) == List(
      ParsedCron(TimeIntervals.Minute, List(1)),
      ParsedCron(TimeIntervals.Hour, List(1)),
      ParsedCron(TimeIntervals.DayOfMonth, List(1)),
      ParsedCron(TimeIntervals.Month, List(1)),
      ParsedCron(TimeIntervals.DayOfWeek, List(1)),
    ))
  }

  it should "respect that some intervals include 0" in {
    val cron: Cron = Cron("0", "0", "0", "0", "0")
    assertThrows[RuntimeException] {
      CronParser.execute(cron)
    }
  }
}
