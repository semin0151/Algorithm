import java.util.*

fun main() {
    val (n, m) = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()
    val arr = Array<ArrayList<Int>>(n.inc()) { arrayListOf() }
    repeat(m) {
        val st = StringTokenizer(readLine())
        val first = st.nextToken().toInt()
        val second = st.nextToken().toInt()

        arr[first].add(second)
        arr[second].add(first)
    }

    var answerPoint = Int.MAX_VALUE
    var answerIndex = Int.MAX_VALUE

    for(i in 1..n) {
        val intArr = IntArray(n.inc()) { Int.MAX_VALUE }
        val queue: Queue<Node> = LinkedList()
        queue.offer(Node(i, 0))

        while(queue.isNotEmpty()) {
            val next = queue.poll()
            val nextArr = arr[next.vex]
            val nextCost = next.cost.inc()

            nextArr.forEach { nextVex ->
                if(intArr[nextVex] > nextCost) {
                    intArr[nextVex] = nextCost
                    queue.offer(Node(nextVex, nextCost))
                }
            }
        }

        val currentPoint = intArr.filterIndexed { index, _ -> index > 0}.sum()

        if(currentPoint < answerPoint) {
            answerPoint = currentPoint
            answerIndex = i
        }
    }

    print("$answerIndex")
}

data class Node(
    val vex: Int,
    val cost: Int
)
/**
 * 5 5
 * 1 3
 * 1 4
 * 4 5
 * 4 3
 * 3 2
 */