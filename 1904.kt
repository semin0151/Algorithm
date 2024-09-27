fun main() {
    val n = readLine()?.toInt()?:0
    val dp = IntArray(n.inc()) { 0 }

    if(n>=1) dp[1] = 1
    if(n>=2) dp[2] = 2
    for(i in 3..n) {
        dp[i] = (dp[i-2] + dp[i-1]).rem(15746)
    }

    print("${dp.last()}")
}


/**
 * 1
 * 
 * 00 11
 * 
 * 100 111 001
 * 
 * 1001 1111 0011 0000 1100
 */