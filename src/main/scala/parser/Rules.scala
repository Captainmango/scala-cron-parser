package parser

import support.TimeIntervals

sealed trait Rules {
  def wildcard(timeInt: TimeIntervals): List[Int] = {
    timeInt match {
      case TimeIntervals.Hour | TimeIntervals.Minute => (0 to timeInt.upperBound).toList
      case _ => (1 to timeInt.upperBound).toList
    }
  }
  
  def single(timeInt: TimeIntervals, numbers: Option[List[Int]]): List[Int] = {
    numbers.getOrElse(List(timeInt.upperBound))
  }
}

object RulesEngine extends Rules
