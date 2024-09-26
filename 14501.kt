import java.util.*
import kotlin.math.*

fun main() {
    val n = readLine()?.toInt() ?: 0
    val arr = Array<Pair<Int, Int>>(n) { 0 to 0 }
    val dp = Array<Int> (n.inc()) { 0 }

    for(i in 0 until n) {
        arr[i] = StringTokenizer(readLine()).run {
            nextToken().toInt() to nextToken().toInt()
        }
    }
    
    for(i in n.dec() downTo 0) {
        if(arr[i].first + i > n) dp[i] = dp[i.inc()]
        else dp[i] = max(dp[arr[i].first + i] + arr[i].second, dp[i.inc()])
        print("${dp.joinToString(" ")}\n")
    }

    print("${dp.max()}")
}