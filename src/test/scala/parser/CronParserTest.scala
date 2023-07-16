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

  it should "be able to pass a cron that is realistic" in {
    val cron: Cron = Cron("1-15", "*/5", "1,15", "7", "*")
    assert(CronParser.execute(cron) == List(
      ParsedCron(TimeIntervals.Minute, (1 to 15).toList),
      ParsedCron(TimeIntervals.Hour, List(0, 5, 10, 15, 20)),
      ParsedCron(TimeIntervals.DayOfMonth, List(1, 15)),
      ParsedCron(TimeIntervals.Month, List(7)),
      ParsedCron(TimeIntervals.DayOfWeek, (1 to 7).toList),
    ))
  }
}
