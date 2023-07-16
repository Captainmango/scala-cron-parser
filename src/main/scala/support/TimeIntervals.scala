package support

enum TimeIntervals(val upperBound: Int) {
  case Minute extends TimeIntervals(59)
  case Hour extends TimeIntervals(23)
  case DayOfMonth extends TimeIntervals(31)
  case Month extends TimeIntervals(12)
  case DayOfWeek extends TimeIntervals(7)
}
