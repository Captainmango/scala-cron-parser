package parser

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.prop.{TableDrivenPropertyChecks, TableFor4}
import support.TimeIntervals
import parser.CronParser

import scala.language.postfixOps

class RulesTest extends AnyFunSuite with TableDrivenPropertyChecks {
  val testCases: TableFor4[String, String, TimeIntervals, List[Int]] = Table(
    ("test case", "expression", "time", "expected output"),
    ("wild card", "*", TimeIntervals.DayOfWeek, List(1,2,3,4,5,6,7)),
    ("range", "2-5", TimeIntervals.DayOfWeek, List(2,3,4,5)),
    ("list", "1,3,5", TimeIntervals.DayOfWeek, List(1,3,5)),
    ("divisor", "*/2", TimeIntervals.DayOfWeek, List(2,4,6)),
    ("single value", "1", TimeIntervals.DayOfWeek, List(1))
  )

  forAll(testCases) {(kase, expr, timeInt, expected) =>
    test(kase) {
      assert(RulesEngine.wildcard(expr, timeInt) == expected)
    }
  }
}
