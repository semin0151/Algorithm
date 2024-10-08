import java.util.*
import kotlin.math.*

fun main() {
    val (n, e) = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()
    val graph = Array<ArrayList<Edge>>(n.inc()) { arrayListOf() }

    repeat(e) {
        val (a, b, c) = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()
        graph[a].add(Edge(b, c))
        graph[b].add(Edge(a, c))
    }

    val (v1, v2) = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()

    fun dijkstra(start: Int, end: Int): Int {
        val d = IntArray(n.inc()) { Int.MAX_VALUE }
        val queue = PriorityQueue<Edge>()

        d[start] = 0
        queue.offer(Edge(start, 0))

        while(queue.isNotEmpty()) {
            val edge = queue.poll()
            val now = edge.vex
            val nowCost = edge.cost

            if(d[now] < nowCost) continue

            for(ob in graph[now]) {
                if(d[ob.vex] > nowCost + ob.cost) {
                    d[ob.vex] = nowCost + ob.cost
                    queue.offer(Edge(ob.vex, nowCost + ob.cost))
                }
            }
        }

        return d[end]
    }
    
    val d1 = dijkstra(1, v1)
    val d2 = dijkstra(v1, v2)
    val d3 = dijkstra(v2, n)
    val d4 = dijkstra(1, v2)
    val d5 = dijkstra(v2, v1)
    val d6 = dijkstra(v1, n)

    var answer = if(d1 == Int.MAX_VALUE || d2 == Int.MAX_VALUE || d3 == Int.MAX_VALUE) -1
    else min(d1 + d2 + d3, d4 + d5 + d6)
    print("${answer}")
}

data class Edge(
    val vex: Int,
    val cost: Int
): Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return this.vex.compareTo(other.vex)
    }
}