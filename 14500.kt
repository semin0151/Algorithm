import java.util.*
import kotlin.math.*

fun main() {
    val (n, m) = readLine()?.split(" ")?.map {it.toInt()} ?: emptyList()
    val arr = Array<IntArray>(n) { IntArray(m) }
    val visited = Array<BooleanArray>(n) { BooleanArray(m) { false } }
    val dy = listOf(-1, 1, 0, 0)
    val dx = listOf(0, 0, -1, 1)

    val ddy = listOf(
        listOf(0,0,0,1),
        listOf(0,-1,-2,-1),
        listOf(0,0,0,-1),
        listOf(0,1,2,1)
    )

    val ddx = listOf(
        listOf(0,1,2,1),
        listOf(0,0,0,1),
        listOf(0,-1,-2,-1),
        listOf(0,0,0,-1),
    )
    var answer = 0

    repeat(n) { i ->
        val st = StringTokenizer(readLine())
        repeat(m) { j ->
            arr[i][j] = st.nextToken().toInt()
        }
    }

    fun check(y: Int, x: Int, cnt: Int, sum: Int) {
        if (cnt == 3) {
            answer = max(sum, answer)
        } else {
            for(i in 0 until 4) {
                val nextY = y + dy[i]
                val nextX = x + dx[i]
    
                if(nextY in 0 until n && nextX in 0 until m && visited[nextY][nextX].not()) {
                    visited[nextY][nextX] = true
                    check(nextY, nextX, cnt.inc(), sum.plus(arr[nextY][nextX]))
                    visited[nextY][nextX] = false
                }
            }
        }
    }

    fun checkElse(y: Int, x: Int) {
        for(i in 0 until ddy.size) {
            var sum = 0

            loop@for(j in 0 until 4) {
                val nextY = y + ddy[i][j]
                val nextX = x + ddx[i][j]

                if (nextY in 0 until n && nextX in 0 until m) {
                    sum += arr[nextY][nextX]
                } else {
                    sum = -1
                    break@loop
                }
            }

            if(sum > 0) answer = max(answer, sum)
        }
    }

    repeat(n) { i ->
        repeat(m) { j ->
            visited[i][j] = true
            check(i, j, 0, arr[i][j])
            visited[i][j] = false
            checkElse(i, j)
        }
    }

    print("$answer")
}