import java.util.*

fun main() {
    val tt = readLine()?.toInt() ?: 0
    val sb = StringBuilder()

    repeat(tt) {
        val (a, b) = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()
        var tmp = a.rem(10)

        repeat(b.dec()) {
            tmp = tmp.times(a).rem(10)
        }

        if(tmp == 0) sb.append("10\n")
        else sb.append("$tmp\n")
    }

    print(sb)
}