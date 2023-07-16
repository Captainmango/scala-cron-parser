import core.{Cron, TimeIntervals}
import formatter.CronPrinter
import parser.CronParser

object Main {
  def main(args: Array[String]): Unit = {
    val cron = Cron(args(0), args(1), args(2), args(3), args(4))
    val parsedCron = CronParser.execute(cron)
    CronPrinter.print(parsedCron)
  }
}
