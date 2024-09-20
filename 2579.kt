import kotlin.math.*

fun main() {
    val num = readLine()?.toInt()?:0
    val arr = mutableListOf<Int>().apply {
        repeat(num) {
            add(readLine()?.toInt()?:0)
        }
    }
    val dp = mutableListOf<Int>().apply {
        repeat(num) {
            add(0)
        }
    }
    
    dp[0] = arr[0]
    if(num > 1) dp[1] = arr[1] + arr[0]
    if(num > 2) dp[2] = arr[2] + max(arr[1], arr[0])
    for ( index in 3..num.dec()) {
        dp[index] = arr[index] + max(arr[index-1] + dp[index-3], dp[index-2])
    }
    print("${dp[num.dec()]}")
}