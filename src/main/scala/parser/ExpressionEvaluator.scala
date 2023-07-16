package parser

import support.{ParsedCron, TimeIntervals}
import parser.RulesEngine

object ExpressionEvaluator {
  def evaluate(expr: String, timeInterval: TimeIntervals): ParsedCron = {
    val rule = computeOperands(expr)
    
    val possibleValues = rule.operand match {
      case RuleType.Wildcard => RulesEngine.wildcard(timeInterval)
      case _ => RulesEngine.single(timeInterval, rule.numbers)
    }

    ParsedCron(timeInterval, possibleValues)
  }

  private case class ParsedRule(operand: RuleType, numbers: Option[List[Int]])
  private enum RuleType {
    case Wildcard, Divisor, Range, List, Single
  }

  private def computeOperands(expr: String): ParsedRule = {
    val exprAsList= expr.split("""\D+""").toList
    val numbers: Option[List[Int]] = Option(exprAsList.takeWhile(_.matches("""\d+""")).map(_.toInt))
    val operand: String = exprAsList.takeWhile(_.matches("""\D+""")).mkString

    val rule: RuleType = operand match {
      case operand if operand.contains("-") => RuleType.Range
      case operand if operand.contains(",") => RuleType.List
      case operand if operand.contains("/") => RuleType.Divisor
      case operand if operand.contains("*") => RuleType.Wildcard
      case _ => RuleType.Single
    }

    ParsedRule(rule, numbers)
  }
}
