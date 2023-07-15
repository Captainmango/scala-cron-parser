package support

case class Cron(min: String, hour: String, dayOfMonth: String, month: String, dayOfWeek: String) {
  def toList: List[String] = {
    this.productIterator.toList.map(_.asInstanceOf[String])
  }
}
