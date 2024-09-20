import java.util.*

fun main() {
    val st = StringTokenizer(readLine())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    val d = st.nextToken().toInt()
    val e = st.nextToken().toInt()
    val f = st.nextToken().toInt()

    print("${(((c*e) - (b*f)) / ((a*e) - (b*d)))} ${(((c*d) - (a*f)) / ((b*d) - (a*e)))}")
}