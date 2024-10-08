import java.util.*

fun main() {
    val (k, n) = StringTokenizer(readLine()).run {
        nextToken().toInt() to nextToken().toInt()
    }
    val arr = mutableListOf<Long>().apply {
        repeat(k) {
            add(readLine()?.toLong() ?: 0)
        }
    }

    var start = 0L
    var end = arr.max()
    var answer = 0L
    while(start <= end) {
        val mid = (start + end).div(2)
        
        if(getCount(arr, mid) >= n) {
            answer = mid
            start = mid.inc()
        } else end = mid.dec()
    }

    print("$answer")
}

fun getCount(arr: List<Long>, target: Long): Long {
    return if(target > 0)arr.sumOf { it.div(target) }
    else Long.MAX_VALUE
}