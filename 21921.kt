import java.util.*

fun main() {
    val (n, x) = StringTokenizer(readLine()).run {
        nextToken().toInt() to nextToken().toInt()
    }
    val dp = IntArray(n.inc())
    val st = StringTokenizer(readLine())
    for(i in 1..n) {
        dp[i] = dp[i-1] + st.nextToken().toInt()
    }
    var max = 0
    var cnt = 0
    for(i in x..n) {
        val sum = dp[i] - dp[i-x]
        if(sum > max) {
            max = sum
            cnt = 1
        } else if(max == sum) {
            cnt++
        }
    }

    if(max != 0)print("$max\n$cnt")
    else print("SAD")
}