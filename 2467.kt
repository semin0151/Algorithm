import java.util.*
import kotlin.math.*

fun main() {
    val n = readLine()?.toInt()?:0
    val arr = mutableListOf<Int>().apply {
        val st = StringTokenizer(readLine())
        repeat(n) {
            add(st.nextToken().toInt())
        }

        sort()
    }

    var start = 0
    var end = arr.size.dec()
    var currentStart = 0
    var currentEnd = arr.size.dec()
    var closestDiff = Int.MAX_VALUE

    while(start < end) {
        val value = abs(arr[start] + arr[end])

        if(closestDiff > value) {
            closestDiff = value
            currentStart = start
            currentEnd = end
        }
        
        if(arr[start] + arr[end] < 0) start++
        else end--
    }

    print("${arr[currentStart]} ${arr[currentEnd]}")
}