import java.util.*

fun main() {
    val num = readLine()?.toInt()?:0
    val answer = mutableListOf<Int>().apply {
        val st = StringTokenizer(readLine())
        repeat(num) {
            add(st.nextToken().toInt())
        }
    }.distinct().sorted().joinToString(" ")

    print(answer)
}