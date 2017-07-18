package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        return when {
            year != other.year -> year - other.year
            month != other.month -> month - other.month
            else -> dayOfMonth - other.dayOfMonth
        }
    }
}
operator fun MyDate.plus(timeInterval: TimeInterval) = addTimeIntervals(timeInterval, 1)
operator fun MyDate.plus(timeIntervals: RepeatedTimeInterval) = addTimeIntervals(timeIntervals.timeInterval, timeIntervals.number)
operator fun TimeInterval.times(number: Int) = RepeatedTimeInterval(this, number)
operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this,other)

class RepeatedTimeInterval(val timeInterval: TimeInterval, val number: Int)


enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate) :Iterable<MyDate>{
    override fun iterator(): Iterator<MyDate> =DateIterator(this)
    operator fun contains(item: MyDate): Boolean = start <= item && item <= endInclusive
}
class DateIterator(val dateRange: DateRange):Iterator<MyDate>{
    var current=dateRange.start
    override fun hasNext(): Boolean {
        return current<=dateRange.endInclusive
    }

    override fun next(): MyDate {
        val result=current
        current=current.nextDay()
        return result
    }

}
