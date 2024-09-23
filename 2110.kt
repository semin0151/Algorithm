import java.util.*

fun main() {
    val (n, c) = StringTokenizer(readLine()).run {
        nextToken().toInt() to nextToken().toInt()
    }
    val arr = mutableListOf<Int>().apply {
        repeat(n) {
            add(readLine()?.toInt() ?: 0)
        }
    }.sorted()

    var start = 0
    var end = arr.last().minus(arr.first())
    var answer = 0

    while(start <= end) {
        val mid = (start + end).div(2)

        if(getCount(arr, mid) >= c) {
            answer = mid
            start = mid.inc()
        } else end = mid.dec()
    }

    print("$answer")
}

fun getCount(arr: List<Int>, target: Int): Int {
    var cnt = 0
    var current = 0
    for(i in arr.indices) {
        if(current == 0 || arr[i] - current >= target) {
            current = arr[i]
            cnt++
        } 
    }
    return cnt
}