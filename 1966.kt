import java.util.*

fun main() {
    val testcase = readLine()?.toInt() ?: 0
    val sb = StringBuilder()

    repeat(testcase) {
        val (n, m) = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()
        val queue :Deque<Print> = LinkedList()
        val st = StringTokenizer(readLine())
        for(i in 0 until n) {
            queue.offer(Print(i, st.nextToken().toInt()))
        }
        var cnt = 0

        while(true) {
            if(queue.peek().priority == queue.maxOf { it.priority }) {
                cnt++
                val current = queue.poll()
                if(current.index == m) break
            } else {
                val current = queue.poll()
                queue.offerLast(current)
            }
        }

        sb.append("$cnt\n")
    }
    print(sb.toString())
}

data class Print(
    val index: Int, 
    val priority: Int
)