package core

case class Cron(min: String, hour: String, dayOfMonth: String, month: String, dayOfWeek: String) {
  def toList: List[String] = {
    this.productIterator.toList.map(_.asInstanceOf[String])
  }
}

object Cron {
  def fromList(args: List[String]): Cron = Cron(args.head, args(1), args(2), args(3), args(4))
}
