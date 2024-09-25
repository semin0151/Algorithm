import java.util.*
import kotlin.math.*

fun main() {
    val n = readLine()?.toInt() ?: 0
    val arr = Array<IntArray>(n) {IntArray(n)}

    for(i in 0 until n) {
        val st = StringTokenizer(readLine())
        for(j in 0..i) {
            if(i == 0) arr[i][j] = st.nextToken().toInt()
            else {
                if(j == 0) arr[i][j] = arr[i-1][j] + st.nextToken().toInt()
                else if(j == i) arr[i][j] = arr[i-1][j-1] + st.nextToken().toInt()
                else arr[i][j] = max(arr[i-1][j], arr[i-1][j-1]) + st.nextToken().toInt()
            }
        }
    }

    val answer = arr[n.dec()].max()
    print("$answer")
}