package parser

import support.{Cron, ParsedCron, TimeIntervals}
import parser.ExpressionEvaluator

object CronParser {
  private val cronOrder: List[TimeIntervals] = List(
    TimeIntervals.Minute,
    TimeIntervals.Hour,
    TimeIntervals.DayOfMonth,
    TimeIntervals.Month,
    TimeIntervals.DayOfWeek
  )

  def execute(cronExpr: Cron): List[ParsedCron] =
    cronOrder.zip(cronExpr.toList).map((tI, cE) => ExpressionEvaluator.evaluate(cE, tI))
}


