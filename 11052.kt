import kotlin.math.*

fun main() {
    val n = readLine()?.toInt()?:0
    val arr = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()
    val dp = IntArray(n.inc())

    for(i in 0 until n) {
        val index = i.inc()
        for(j in index..n) {
            dp[j] = max(dp[j-index] + arr[i], dp[j])
        }
    }

    print("${dp.max()}")
}