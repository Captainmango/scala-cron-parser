package support

import org.scalatest.flatspec.AnyFlatSpec

import support.Cron

class CronTest extends AnyFlatSpec {
  val cronUnderTest: Cron = Cron("1", "2", "3", "4", "5")

  "A Cron" should "have a minute value" in {
    assert(cronUnderTest.min == "1")
  }

  "A Cron" should "have a hour value" in {
    assert(cronUnderTest.hour == "2")
  }

  "A Cron" should "have a dayOfMonth value" in {
    assert(cronUnderTest.dayOfMonth == "3")
  }

  "A Cron" should "have a month value" in {
    assert(cronUnderTest.month == "4")
  }

  "A Cron" should "have a dayOfWeek value" in {
    assert(cronUnderTest.dayOfWeek == "5")
  }
}
