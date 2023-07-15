package parser

import support.TimeIntervals

sealed trait Rules {
  def wildcard(expr: String, timeint: TimeIntervals): List[Int] = {
    List(1,2,3)
  }
}

object RulesEngine extends Rules
