import java.util.*

fun main() {
    val st = StringTokenizer(readLine())
    val sb = StringBuilder()
    arrayListOf<Int>().apply {
        for (index in 1..3) {
            add(st.nextToken().toInt())
        }
        sort()
    }.also {
        it.map { num ->
            sb.append("$num ")
        }
        print(sb)
    }

}