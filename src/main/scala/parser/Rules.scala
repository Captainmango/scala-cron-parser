package parser

import support.TimeIntervals

sealed trait Rules {
  def wildcard(timeInt: TimeIntervals): List[Int] = {
    timeInt match {
      case TimeIntervals.Hour | TimeIntervals.Minute => (0 to timeInt.upperBound).toList
      case _ => (1 to timeInt.upperBound).toList
    }
  }

  def single(timeInt: TimeIntervals, numbers: List[Int]): List[Int] = numbers
  def range(timeInt: TimeIntervals, numbers: List[Int]): List[Int] = (numbers.head to numbers.tail.last).toList
  def divisor(timeInt: TimeIntervals, numbers: List[Int]): List[Int] = timeInt match {
    case TimeIntervals.Hour | TimeIntervals.Minute => (for num <- 0 to timeInt.upperBound if num % numbers.head == 0 yield num).toList
    case _ => (for num <- 1 to timeInt.upperBound if num % numbers.head == 0 yield num).toList
  }
}

object RulesEngine extends Rules
