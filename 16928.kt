import java.util.*

fun main() {
    val (n, m) = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()
    val warp = IntArray(101) { it }
    val visited = BooleanArray(101) { false }
    var answer = -1
    repeat(n + m) {
        val (u, v) = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()
        warp[u] = v
    }

    fun bfs(start: Int, cnt: Int) {
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.offer(start to cnt)

        while(queue.isNotEmpty()) {
            val current = queue.poll()
            if(current.first == 100) {
                answer = current.second
                break
            }
            for(i in 1..6) {
                val next = current.first.plus(i)
                if (next in 1..100 && visited[next].not()) {
                    visited[next] = true
                    queue.offer(warp[next] to current.second.inc())
                }
            }
        }
    }

    bfs(1, 0)
    print("$answer")
}