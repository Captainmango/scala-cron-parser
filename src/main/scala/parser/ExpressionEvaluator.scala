package parser

import support.{ParsedCron, TimeIntervals}
import parser.RulesEngine

object ExpressionEvaluator {
  def evaluate(expr: String, timeInterval: TimeIntervals): ParsedCron = {
    val rule = computeOperands(expr)

    val possibleValues = rule.operand match {
      case RuleType.Wildcard => RulesEngine.wildcard(timeInterval)
      case RuleType.Range => RulesEngine.range(timeInterval, rule.numbers)
      case RuleType.Divisor => RulesEngine.divisor(timeInterval, rule.numbers)
      case _ => RulesEngine.single(timeInterval, rule.numbers)
    }

    ParsedCron(timeInterval, possibleValues)
  }

  private case class ParsedRule(operand: RuleType, numbers: List[Int])
  private enum RuleType {
    case Wildcard, Divisor, Range, List, Single
  }

  private def computeOperands(expr: String): ParsedRule = {
    val exprAsList = expr.split("""\D+""").toList
    val numbers: List[Int] = exprAsList.filter(_.matches("""\d+""")).map(_.toInt)

    val rule: RuleType = expr match {
      case expr if expr.contains("-") => RuleType.Range
      case expr if expr.contains(",") => RuleType.List
      case expr if expr.contains("/") => RuleType.Divisor
      case expr if expr.contains("*") => RuleType.Wildcard
      case _ => RuleType.Single
    }

    ParsedRule(rule, numbers)
  }
}
