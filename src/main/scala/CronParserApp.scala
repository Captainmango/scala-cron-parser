import cats.data.NonEmptyList
import com.monovore.decline.*
import cats.implicits.*
import core.*
import formatter.*
import parser.*

import java.io.File
import scala.util.{Failure, Success, Try}

object CronParserApp extends CommandApp(
  name = "cron-parser",
  header = "parses cron expressions",
  main = {
    val cronArg = Opts.arguments[String](metavar = "cron expression")
    val outputFilePath = Opts.option[String]("output-file", help = "Path to write cron expression").withDefault("")

    (cronArg, outputFilePath).mapN {(cron: NonEmptyList[String], outPath: String) =>
      val c = cron.take(5)
      val cObj = Cron.fromList(c)
      val parsedCrons = CronParser.execute(cObj)

      if outPath.isEmpty then CronPrinter.print(parsedCrons)
      else Try(new File(outPath)) match {
        case Success(v) =>
          Try(CronPrinter.print(parsedCrons, v)) match {
            case Success(_) => println(s"Wrote output to file: ${v.getCanonicalPath}")
            case Failure(e) => println(s"Error occurred while writing file. Got error: $e")
          }
        case Failure(e) => println(s"Invalid path given. Got error: $e")
      }
    }
  }
)
