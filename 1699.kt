import java.util.*
import kotlin.math.*

fun main() {
    val n = readLine()?.toInt() ?: 0
    val dp = IntArray(n.inc()) { Int.MAX_VALUE }
    dp[0] = 0
    for(i in 1..sqrt(n.toDouble()).toInt()) {
        for(j in (i*i)..n) {
            dp[j] = min(dp[j-(i*i)].inc(), dp[j])
        }
    }

    print("${dp[n]}")
}