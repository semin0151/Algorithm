import java.util.*

fun main() {
    val st = StringTokenizer(readLine())
    val num1 = st.nextToken() + st.nextToken()
    val num2 = st.nextToken() + st.nextToken()
    print("${num1.toLong() + num2.toLong()}")
}