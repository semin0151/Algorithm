import java.util.*

fun main() {
    val sb = StringBuilder()
    while(true) {
        val st = StringTokenizer(readLine())
        val n = st.nextToken().toInt()

        if(n == 0) break

        val arr = mutableListOf<Int>().apply {
            repeat(n) {
                add(st.nextToken().toInt())
            }
            sort()
        }
        val intArr = IntArray(6)

        fun recursion(current: Int) {
            if(current >= 6) {
                sb.append("${intArr.map { arr[it] }.joinToString(" ")}\n")
            } else {
                for(i in 0 until n) {
                    if(current == 0 || intArr[current.dec()] < i) {
                        intArr[current] = i
                        recursion(current.inc())
                    }
                }
            }
        }

        recursion(0)
        sb.append("\n")
    }

    print(sb.toString())
}