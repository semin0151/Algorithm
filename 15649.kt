import java.util.*

fun main() {
    val (n, m) = StringTokenizer(readLine()).run {
        nextToken().toInt() to nextToken().toInt()
    }
    val arr = IntArray(m)
    val check = BooleanArray(n.inc()) { true }
    val sb = StringBuilder()

    fun recursion(current: Int) {
        if(current >= m) {
            sb.append("${arr.joinToString(" ")}\n")
        } else {
            for(i in 1..n) {
                if(current == 0 || check[i]) {
                    check[i] = false
                    arr[current] = i
                    recursion(current.inc())
                    check[i] = true
                }
            }
        }
    }

    recursion(0)

    print(sb.toString())
}