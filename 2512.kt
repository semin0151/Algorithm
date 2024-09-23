import java.util.*

fun main() {
    val n = readLine()?.toInt()?:0
    val arr = mutableListOf<Int>().apply {
        val st = StringTokenizer(readLine())
        repeat(n) {
            add(st.nextToken().toInt())
        }
    }
    val m = readLine()?.toInt()?:0

    var start = 0
    var end = arr.max()
    var answer = 0

    while(start <= end) {
        val mid = (start + end).div(2)
        if(getTotal(arr, mid) <= m) {
            answer = mid
            start = mid.inc()
        } else end = mid.dec()
    }

    print("$answer")
}

fun getTotal(arr: List<Int>, target: Int): Int {
    return arr.map {
        if(it >= target) target
        else it
    }.sum()
}