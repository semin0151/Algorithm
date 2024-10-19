import java.util.*
import kotlin.math.*

fun main() {
    val sb = StringBuilder()
    val n = readLine()?.toInt() ?: 0
    val pq = PriorityQueue<Int> { o1 ,o2 ->
        if(abs(o1) == abs(o2)) o1.compareTo(o2)
        else abs(o1).compareTo(abs(o2))
    }

    repeat(n) {
        val num = readLine()?.toInt() ?: 0

        if(num == 0) {
            if(pq.isEmpty()) sb.append("0\n")
            else sb.append("${pq.poll()}\n")
        } else {
            pq.offer(num)
        }
    }

    print(sb.toString())
}