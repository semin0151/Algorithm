import java.util.*
import kotlin.math.*

fun main() {
    val n = readLine()?.toInt()?:0
    val st = StringTokenizer(readLine())
    val arr = mutableListOf<Int>().apply {
        repeat(n) {
            add(st.nextToken().toInt())
        }
    }.sorted()

    print("${binarySearch(arr).joinToString(" ")}")
}

fun binarySearch(arr: List<Int>): List<Int> {
    var start = 0
    var end = arr.size.dec()
    var closestDiff = Int.MAX_VALUE
    var ansL = Int.MAX_VALUE
    var ansR = Int.MAX_VALUE

    while (start < end) {
        val diff = abs(arr[start] + arr[end])
        if (closestDiff > diff) {
            closestDiff = diff
            ansL = arr[start]
            ansR = arr[end]
        }

        if(0 > arr[start] + arr[end]) {
            start++
        } else {
            end--
        }
    }

    return listOf(ansL, ansR)
}