import java.util.*

val monthArr = arrayOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
val dayOfWeekArr = arrayOf("SUN", "MON", "TUE", "WED", "THR", "FRI", "SAT")

fun main() {
    val st = StringTokenizer(readLine())
    val month = st.nextToken().toInt()
    val day = st.nextToken().toInt()
    
    val totalDay = getTotalDay(month, day)

    print("${dayOfWeekArr[totalDay%7]}")
}

fun getTotalDay(month: Int, day: Int): Int {
    var sum = 0 
    for(count in 1..month-1) {
        sum = sum.plus(monthArr[count])
    }
    return sum.plus(day)
}