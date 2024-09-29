import java.util.*

fun main() {
    val (x, y) = StringTokenizer(readLine()).run {
        nextToken().toLong() to nextToken().toLong()
    }
    val z = y.times(100L).div(x)

    var start = 1L
    var end = Int.MAX_VALUE.toLong()
    var answer = -1L

    while(start <= end) {
        val mid = (start + end).div(2)

        if(y.plus(mid).times(100L).div(x.plus(mid)) > z) {
            end = mid.dec()
            answer = mid
        } else start = mid.inc()
    }

    print("$answer")
}