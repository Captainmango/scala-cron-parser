package formatter

import core.ParsedCron

import java.io.{File, PrintWriter}

object CronPrinter {
  def print(parsedCrons: List[ParsedCron]): Unit = {
    parsedCrons.foreach(pC => println(pC.print))
  }

  def print(parsedCrons: List[ParsedCron], outFile: File): Unit = {
    val printerWriter = new PrintWriter(outFile)
    parsedCrons.foreach(pC => printerWriter.println(pC.print))
    printerWriter.close()
  }
}
