import java.util.*

fun main() {
    val (n, m) = StringTokenizer(readLine()).run {
        nextToken().toInt() to nextToken().toInt()
    }
    val dp = Array<IntArray>(n.inc()) { IntArray(m.inc()) }
    val sb = StringBuilder()

    for(i in 1..n) {
        val st = StringTokenizer(readLine())
        for(j in 1..m) {
            dp[i][j] = st.nextToken().toInt() + dp[i.dec()][j] + dp[i][j.dec()] - dp[i.dec()][j.dec()]
        }
    }

    val t = readLine()?.toInt() ?: 0
    repeat(t) {
        val st = StringTokenizer(readLine())
        val x1 = st.nextToken().toInt()
        val y1 = st.nextToken().toInt()
        val x2 = st.nextToken().toInt()
        val y2 = st.nextToken().toInt()

        val sum = dp[x2][y2] - dp[x1.dec()][y2] - dp[x2][y1.dec()] + dp[x1.dec()][y1.dec()]
        sb.append("${sum}\n")
    }

    print(sb.toString())
}