import kotlin.math.*

fun main() {
    val n = readLine()?.toInt() ?: 0
    val arr = mutableListOf<Int>().apply {
        repeat(n) {
            add(readLine()?.toInt() ?: 0)
        }
    }
    val dp = Array<Int>(n.inc()) { 0 }

    dp[0] = 0
    arr.forEachIndexed { index, num ->
        if(index == 0) dp[index.inc()] = num
        else if(index == 1) dp[index.inc()] = num + arr[index-1]
        else dp[index.inc()] = max(num + max(dp[index-1], dp[index-2] + arr[index-1]), dp[index])
    }

    print("${dp.max()}")

}