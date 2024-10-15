import java.util.*
import kotlin.math.*

fun main() {
    val n = readLine()?.toInt() ?: 0
    val arr = arrayListOf<Int>().apply {
        val st = StringTokenizer(readLine())
        repeat(n) { 
            add(st.nextToken().toInt())
        }
    }
    val dp = IntArray(n)
    dp[n.dec()] = 1
    for(i in n.dec() downTo 0) {
        var max = 1
        for(j in i.inc() until n) {
            if(arr[i] > arr[j]) {
                max = max(dp[j].inc(), max)
            }
        }
        dp[i] = max
    }

    print("${dp.max()}")
}