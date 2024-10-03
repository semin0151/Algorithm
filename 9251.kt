import java.util.*
import kotlin.math.*

fun main() {
    val text1 = readLine()?:""
    val text2 = readLine()?:""

    val dp = Array<IntArray>(text1.length.inc()) { IntArray(text2.length.inc()) }

    for(i in 1 until dp.size) {
        for(j in 1 until dp[0].size) {
            if(text1[i.dec()] == text2[j.dec()]) {
                dp[i][j] = dp[i.dec()][j.dec()] + 1
            } else {
                dp[i][j] = max(dp[i][j.dec()], dp[i.dec()][j])
            }
        }
    }

    print("${dp.map {it.max()}.max()}")
}