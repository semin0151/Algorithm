import java.util.*
import kotlin.math.*

fun main() {
    val n = readLine()?.toInt() ?: 0
    val m = readLine()?.toInt() ?: 0
    val graph = Array<ArrayList<Edge>>(n.inc()) { arrayListOf() } 
    val pq = PriorityQueue<Edge>()
    val distance = IntArray(n.inc()) { Int.MAX_VALUE }
    
    repeat(m) {
        val (start, end, price) = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()
        graph[start].add(Edge(end, price))
    }
    val (start, end) = readLine()?.split(" ")?.map {it.toInt()} ?: emptyList()

    pq.offer(Edge(start, 0))
    distance[start] = 0

    while(pq.isNotEmpty()) {
        val edge = pq.poll()
        
        if(edge.cost > distance[edge.vex]) continue

        for(ob in graph[edge.vex]) {
            if(distance[ob.vex] > ob.cost + edge.cost) {
                distance[ob.vex] = min(distance[ob.vex], ob.cost + edge.cost)
                pq.offer(Edge(ob.vex, ob.cost + edge.cost))
            }
        }
    }

    print("${distance[end]}")
}

data class Edge(
    val vex: Int, 
    val cost: Int
): Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        return if(this.vex == other.vex) this.cost.compareTo(other.cost)
        else this.vex.compareTo(other.vex)
    }
}