package core

case class ParsedCron(timeInterval: TimeIntervals, possibleVals: List[Int]) {
  def print: String = s"${this.timeInterval.toString}: ${this.possibleVals.mkString(", ")}"
}
