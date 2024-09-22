import java.util.*
import kotlin.math.*

fun main() {
    val num = readLine()?.toInt() ?: 0
    val arr = mutableListOf<Int>().apply {
        val st = StringTokenizer(readLine())
        repeat(num) {
            add(st.nextToken().toInt())
        }
        add(Int.MAX_VALUE)
    }
    val dp = IntArray(arr.size)

    for (i in num.dec() downTo 0) {
        for(j in i.inc()..dp.size.dec()) {
            if(arr[j] > arr[i]) {
                dp[i] = max(dp[j].inc(), dp[i])
            }
        }
    }

    print("${dp.joinToString(" ")}\n")

    print("${dp.max()}")
}