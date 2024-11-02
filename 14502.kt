import java.util.*
import kotlin.math.*

fun main() {
    val dy = listOf(-1,1,0,0)
    val dx = listOf(0,0,-1,1)
    val (n, m) = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()
    val origin = Array<IntArray>(n) { IntArray(m) }
    var tmp = Array<IntArray>(n) { IntArray(m) }
    val emptyList = mutableListOf<Pair<Int, Int>>()
    val wallIndexList = IntArray(3)
    var answer = 0

    for(i in 0 until n) {
        val st = StringTokenizer(readLine())
        for(j in 0 until m) {
            origin[i][j] = st.nextToken().toInt()
            if (origin[i][j] == 0) emptyList.add(i to j)
        }
    }

    fun bfs(startY: Int, startX: Int) {
        val queue: Queue<Pair<Int,Int>> = LinkedList()
        queue.offer(startY to startX)

        while(queue.isNotEmpty()) {
            val current = queue.poll()
            val currentY = current.first
            val currentX = current.second

            for(i in 0 until 4) {
                val nextY = currentY + dy[i]
                val nextX = currentX + dx[i]

                if(nextY in 0 until n && nextX in 0 until m && tmp[nextY][nextX] == 0) {
                    tmp[nextY][nextX] = 2
                    queue.offer(nextY to nextX)
                }
            }
        }
    }

    fun copy() {
        for(i in 0 until n) {
            for(j in 0 until m) {
                tmp[i][j] = origin[i][j]
            }
        }
    }

    fun recursion(current: Int) {
        if(current == 3) {
            copy()

            wallIndexList.forEach { index ->
                val pair = emptyList[index]
                val y = pair.first
                val x = pair.second
                tmp[y][x] = 1
            }

            for(i in 0 until n) {
                for(j in 0 until m) {
                    if(tmp[i][j] == 2) bfs(i, j)
                }
            }

            val result = tmp.sumOf { intArr -> intArr.count { it == 0 } }
            answer = max(answer, result)
        } else {
            for(i in 0 until emptyList.size) {
                if(current == 0 || wallIndexList[current.dec()] < i) {
                    wallIndexList[current] = i
                    recursion(current.inc())
                }
            }
        }
    }

    recursion(0)
    print("$answer")
}