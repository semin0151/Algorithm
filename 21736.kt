import java.util.*

fun main() {
    val dy = listOf(1,-1,0,0)
    val dx = listOf(0,0,-1,1)
    val (n, m) = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()
    val arr = Array<CharArray>(n) { CharArray(m) }
    var currentY = 0
    var currentX = 0
    var answer = 0

    for(i in 0 until n) {
        val st = readLine() ?: ""
        for(j in 0 until m) {
            arr[i][j] = st[j]
            if(arr[i][j] == 'I') {
                currentY = i
                currentX = j
            }
        }
    }

    fun bfs() {
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.offer(currentY to currentX)

        while(queue.isNotEmpty()) {
            val current = queue.poll()

            for(i in 0 until 4) {
                val nextY = current.first + dy[i]
                val nextX = current.second + dx[i]

                if(nextY in 0 until n && nextX in 0 until m && (arr[nextY][nextX] == 'O' || arr[nextY][nextX] == 'P')) {
                    if(arr[nextY][nextX] == 'P') answer++
                    arr[nextY][nextX] = 'X'
                    queue.offer(nextY to nextX)
                }
            }
        }
    }
    
    bfs()
    
    if(answer > 0) print("$answer")
    else print("TT")
}