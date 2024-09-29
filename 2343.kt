import java.util.*
import kotlin.intArrayOf

fun main() {
    val (n, m) = StringTokenizer(readLine()).run {
        nextToken().toInt() to nextToken().toInt()
    }

    val arr = mutableListOf<Int>().apply {
        val st = StringTokenizer(readLine())
        repeat(n) { 
            add(st.nextToken().toInt())
        }
    }

    var start = arr.maxOrNull() ?: 0
    var end = arr.sum()
    var answer = 0

    while(start <= end) {
        val mid = (start + end).div(2)

        if(check(arr, mid) <= m) {
            answer = mid
            end = mid.dec()
        } else start = mid.inc()
    }

    print("$answer")
}

fun check(arr: List<Int>, num: Int): Int {
    var sum = 0
    var result = 0

    for(i in 0..arr.size.dec()) {
        sum += arr[i]

        if(sum == num) {
            result++
            sum = 0
        } else if(sum > num) {
            result++
            sum = arr[i]
        } 
    }

    return if(sum != 0) result.inc()
    else result
}