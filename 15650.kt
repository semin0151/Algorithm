import java.util.*

fun main() {
    val (n, m) = StringTokenizer(readLine()).run {
        nextToken().toInt() to nextToken().toInt()
    }
    val arr = IntArray(m) 
    val sb = StringBuilder()

    fun recursion(current: Int) {
        if(current >= m) {
            sb.append("${arr.joinToString(" ")}\n")
        } else {
            for(i in 1..n) {
                if(current == 0 || arr[current.dec()] < i) {
                    arr[current] = i
                    recursion(current.inc())
                }
            }
        }
    }

    recursion(0)
    print(sb.toString())
}