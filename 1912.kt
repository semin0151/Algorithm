import java.util.*
import kotlin.math.*

fun main() {
    val num = readLine()?.toInt()?:0
    val st = StringTokenizer(readLine())
    val dp = IntArray(num.inc())
    var min = 0
    var answer = Int.MIN_VALUE

    for(i in 0 until num) {
        if(i == 0) dp[i.inc()] = st.nextToken().toInt()
        else dp[i.inc()] = dp[i] + st.nextToken().toInt()
        
        answer = max(answer, dp[i.inc()]-min)
        min = min(min, dp[i.inc()])
    }

    print("$answer")
}