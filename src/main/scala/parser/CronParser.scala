package parser

import support.{Cron, TimeIntervals}

object CronParser {
  private val cronOrder: List[TimeIntervals] = List(
    TimeIntervals.Minute,
    TimeIntervals.Hour,
    TimeIntervals.DayOfMonth,
    TimeIntervals.Month,
    TimeIntervals.DayOfWeek
  )

  def execute(cronExpr: Cron): List[List[Int]] = {
    // Zip list of cron pieces with cronOrder list
    // Map over the list of tuples to get our list of lists (does map return a list or an array)
    List(List(1,2,3))
  }
}


