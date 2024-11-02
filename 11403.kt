import java.util.*

fun main() {
    val n = readLine()?.toInt() ?: 0
    val arr = Array<IntArray>(n) { IntArray(n) }
    val check = Array<IntArray>(n) { IntArray(n) }
    for(i in 0 until n) {
        val st = StringTokenizer(readLine())

        for(j in 0 until n) {
            arr[i][j] = st.nextToken().toInt()
        }
    }

    fun dijkstra(start: Int) {
        val queue: Queue<Int> = LinkedList()
        queue.offer(start)

        while(queue.isNotEmpty()) {
            val current = queue.poll()

            for(i in 0 until n) {
                val next = arr[current][i]

                if(next == 1 && check[start][i] == 0) {
                    check[start][i] = 1
                    queue.offer(i)
                }
            }
        }
    }

    for(i in 0 until n) {
        dijkstra(i)
    }

    print("${check.map { it.joinToString(" ")}.joinToString("\n")}")
}