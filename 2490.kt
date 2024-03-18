import java.util.*

fun main() {
    val sb = StringBuilder()
    for(count in 1..3) {
        val st = StringTokenizer(readLine())
        val answer = arrayListOf<Int>().apply {
            for(count2 in 1..4) {
                add(st.nextToken().toInt())
            }
        }.filter {
            it == 0
        }.size

        when (answer) {
            1 -> {
                sb.append("A\n")
            }
            2 -> {
                sb.append("B\n")
            }
            3 -> {
                sb.append("C\n")
            }
            4 -> {
                sb.append("D\n")
            }
            else -> {
                sb.append("E\n")
            }
        }
    }
    print(sb)
}