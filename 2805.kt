import java.util.*

fun main() {
    val (n, m) = StringTokenizer(readLine()).run {
        nextToken().toInt() to nextToken().toInt()
    }
    val arr = mutableListOf<Long>().apply {
        val st = StringTokenizer(readLine())
        repeat(n) {
            add(st.nextToken().toLong())
        }
    }

    var start = 0L
    var end = arr.max()
    var answer = 0L

    while(start <= end) {
        val mid = (start + end).div(2)

        if(getHeight(arr, mid) >= m) {
            answer = mid
            start = mid.inc()
        } else end = mid.dec()
    }

    print("$answer")
}

fun getHeight(arr: List<Long>, target: Long): Long {
    return arr.map {
        if(it.minus(target) < 0) 0
        else it.minus(target)
    }.sum()
}