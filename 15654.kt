import java.util.*

fun main() {
    val (n, m) = StringTokenizer(readLine()).run {
        nextToken().toInt() to nextToken().toInt()
    }
    val sb = StringBuilder()
    val arr = mutableListOf<Int>().apply {
        val st = StringTokenizer(readLine())
        repeat(n) {
            add(st.nextToken().toInt())
        }

        sort()
    }
    val intArr = IntArray(m)
    val checkArr = BooleanArray(n) { true }

    fun recursion(current: Int) {
        if(current >= m) {
            sb.append("${intArr.map { arr[it] }.joinToString(" ")}\n")
        } else {
            for(i in 0 until n) {
                if(current == 0 || checkArr[i]) {
                    intArr[current] = i
                    checkArr[i] = false
                    recursion(current.inc())
                    checkArr[i] = true
                }
            }
        }
    }

    recursion(0)
    print(sb.toString())
}