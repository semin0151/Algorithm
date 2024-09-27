import java.util.*

fun main() {
    val (n, m) = StringTokenizer(readLine()).run {
        nextToken().toInt() to nextToken().toInt()
    }
    val sb = StringBuilder()
    val dp = Array<IntArray>(n.inc()) { IntArray(n.inc()) }

    for(i in 1..n) {
        val st = StringTokenizer(readLine())
        for(j in 1..n) {
            dp[i][j] = st.nextToken().toInt() + dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1]
        }
    }

    repeat(m) {
        val st = StringTokenizer(readLine())
        val y1 = st.nextToken().toInt()
        val x1 = st.nextToken().toInt()
        val y2 = st.nextToken().toInt()
        val x2 = st.nextToken().toInt()

        sb.append("${dp[y2][x2] - dp[y1-1][x2] - dp[y2][x1-1] + dp[y1-1][x1-1]}\n")
    }

    print(sb.toString())
}