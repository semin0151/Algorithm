import java.util.*

fun main() {
    val dy = listOf(1,-1,0,0)
    val dx = listOf(0,0,-1,1)
    val (n, m) = readLine()?.split(" ")?.map { it.toInt()} ?: emptyList()
    val arr = Array<IntArray> (n) { IntArray(m) }
    val answer = Array<IntArray> (n) { IntArray(m) { -1 } }
    var startY = 0
    var startX = 0

    for(i in 0 until n) {
        val st = StringTokenizer(readLine())

        for(j in 0 until m) {
            arr[i][j] = st.nextToken().toInt()
            if(arr[i][j] == 2) {
                startY = i
                startX = j
                answer[i][j] = 0
            }
            else if(arr[i][j] == 0) {
                answer[i][j] = 0
            }
        }
    }

    fun bfs() {
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.offer(startY to startX)
        arr[startY][startX] = 0

        while(queue.isNotEmpty()) {
            val current = queue.poll()
            val currentY = current.first
            val currentX = current.second

            for(i in 0 until 4) {
                val nextY = currentY + dy[i]
                val nextX = currentX + dx[i]

                if(nextY in 0 until n && nextX in 0 until m && arr[nextY][nextX] != 0) {
                    arr[nextY][nextX] = 0
                    answer[nextY][nextX] = answer[currentY][currentX].inc()
                    queue.offer(nextY to nextX)
                }
            }
        }
    }

    bfs()

    print("${answer.map { it.joinToString(" ")}.joinToString("\n")}")
}