import java.util.*

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

    val dp = IntArray(arr.size.inc())
    var answer = 0

    dp[0] = 0
    for(index in arr.indices) {
        dp[index.inc()] = dp[index] + arr[index]
    }

    for(i in 0..n) {
        for(j in i.inc()..n) {
            if(dp[j] - dp[i] == m) answer++
        }
    }

    print("$answer")
}