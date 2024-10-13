import java.util.*

fun main() {
    val (n, m) = StringTokenizer(readLine()).run {
        nextToken().toInt() to nextToken().toInt()
    }
    val arr = mutableListOf<Int>().apply {
        val st = StringTokenizer(readLine())
        repeat(n) {
            add(st.nextToken().toInt())
        }
        sort()
    }
    val intArr = IntArray(m)
    val sb = StringBuilder()

    fun recursion(current: Int) {
        if(current >= m) {
            sb.append("${intArr.map { arr[it] }.joinToString(" ")}\n")
        } else {
            for(i in 0 until n) {
                intArr[current] = i
                recursion(current.inc())
            }
        }
    }

    recursion(0)
    print(sb.toString())
}