import kotlin.math.*

fun main() {
    val n = readLine()?.toInt() ?: 0
    val sqrtN = sqrt(n.toDouble()).toInt()
    val dp = IntArray(n.inc()) { Int.MAX_VALUE }


    dp[0] = 0
    for(i in 1..sqrtN) {
        for(j in i*i..n) {
            dp[j] = min(dp[j.minus(i*i)].inc(), dp[j])
        }
    }   

    print("${dp[n]}")
}