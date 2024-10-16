import java.util.*

fun main() {
    val n = readLine()?.toInt()?: 0
    val pq: PriorityQueue<Int> = PriorityQueue<Int>() { o1, o2 -> o1.compareTo(o2).times(-1) }

    repeat(n) {
        val st = StringTokenizer(readLine())
        repeat(n) { 
            pq.add(st.nextToken().toInt())    
        }
    }

    repeat(n.dec()) {
        pq.poll()
    }

    print("${pq.peek()}")
}