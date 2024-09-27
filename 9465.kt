import java.util.*
import kotlin.math.*

fun main() {
    val t = readLine()?.toInt() ?: 0

    repeat(t) {
        val n = readLine()?.toInt() ?: 0
        val arr = Array<IntArray>(2) { IntArray(n.inc()) }
        val dp = Array<IntArray>(2) { IntArray(n.inc()) }
        var answer = Int.MIN_VALUE

        for(i in 0 until 2) {
            val st = StringTokenizer(readLine())

            for(j in 1..n) {
                arr[i][j] = st.nextToken().toInt()
            }
        }

        for(j in 1..n) {
            for(i in 0 until 2) {
                if(j == 1) {
                    dp[i][j] = arr[i][j]
                    answer = max(answer, arr[i][j])
                } else {
                    dp[i][j] = max(max(dp[0][j-2], dp[1][j-2]), dp[i.toggle()][j-1]) + arr[i][j]
                    answer = max(answer, dp[i][j])
                }
            }
        }
        
        print("${answer}\n")
    }
}

fun Int.toggle(): Int {
    return if(this == 0) 1
    else 0
}