import java.util.*

fun main() {
    val dy = listOf(1,-1,0,0)
    val dx = listOf(0,0,-1,1)
    val (n, m) = StringTokenizer(readLine()).run {
        nextToken().toInt() to nextToken().toInt()
    }

    val arr = Array<IntArray>(n) { IntArray(m) }
    val check = Array<BooleanArray>(n) { BooleanArray(m) { true } }

    for (i in 0 until n) {
        val tmp = readLine()?.map { it.digitToInt() } ?: emptyList()
        for(j in 0 until m) {
            check[i][j] = tmp[j].toBoolean()
        }
    }

    fun bfs(currentY: Int, currentX: Int) {
        val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int,Int>>()
        queue.offer(currentY to currentX)

        while(queue.isNotEmpty()) {
            val current = queue.poll()

            for(i in 0 until 4) {
                val nextY = current.first + dy[i]
                val nextX = current.second + dx[i]

                if(nextY in 0 until n && nextX in 0 until m && check[nextY][nextX]) {
                    check[nextY][nextX] = false
                    arr[nextY][nextX] = arr[current.first][current.second] + 1
                    queue.offer(nextY to nextX)
                }
            }
        }
    }

    for(i in 0 until n) {
        for(j in 0 until m) {
            if(check[i][j]) {
                check[i][j] = false
                arr[i][j] = 1
                bfs(i, j)
            }
        }
    }

    print("${arr[n.dec()][m.dec()]}")
}

fun Int.toBoolean(): Boolean {
    return if(this == 1) true
    else false
}