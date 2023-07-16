package formatter

import support.ParsedCron

object CronPrinter {
  def print(parsedCrons: List[ParsedCron]): Unit = {
    parsedCrons.foreach(pC => println(s"${pC.timeInterval.toString}: ${pC.possibleVals.mkString(", ")}"))
  }
}
