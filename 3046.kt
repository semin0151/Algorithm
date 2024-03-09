import java.util.*

fun main() {
    val st = StringTokenizer(readLine())
    val r1 = st.nextToken().toInt()
    val s = st.nextToken().toInt()
    print("${s*2-r1}")
}