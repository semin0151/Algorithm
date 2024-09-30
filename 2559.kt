import java.util.*

fun main() {
    val (n, k) = StringTokenizer(readLine()).run {
        nextToken().toInt() to nextToken().toInt()
    }

    val arr = mutableListOf<Int>().apply {
        val st = StringTokenizer(readLine())

        repeat(n) {
            add(st.nextToken().toInt())
        }
    }
    val dp = Array<Int>(n) { 0 }

    for(i in 0 until n) {
        if(i == 0) dp[i] = arr[i]
        else if(i < k) dp[i] = arr[i] + dp[i-1]
        else dp[i] = arr[i] + dp[i-1] - arr[i-k]
    }

    print("${dp.filterIndexed { index, _ -> index >= k.dec()}.max() }")
}