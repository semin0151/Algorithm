import java.util.*
import kotlin.math.*

fun main() {
    val n = readLine()?.toInt()?:0
    val dp = Array<RGB> (n) { RGB(0,0,0) }

    for(i in 0 until n) {
        val st = StringTokenizer(readLine())
        val r = st.nextToken().toInt()
        val g = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        if(i == 0) dp[i] = RGB(r, g, b) 
        else {
            val past = dp[i.dec()]
            dp[i] = RGB(
                r + min(past.g, past.b),
                g + min(past.r, past.b),
                b + min(past.r, past.g)
            )
        }
    }

    print("${dp[n-1].min}")
}

data class RGB(
    val r: Int,
    val g: Int,
    val b: Int
) {
    val min: Int get() = min(min(r,g), b)
}