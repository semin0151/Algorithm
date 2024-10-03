import java.util.*
import kotlin.math.*

val dy = listOf(1,-1,0,0)
val dx = listOf(0,0,-1,1)

fun main() {
    val n = readLine()?.toInt() ?: 0
    val arr = Array<IntArray>(n) { IntArray(n) }
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE
    var answer = 1

    for(i in 0 until n) {
        val st = StringTokenizer(readLine())
        for(j in 0 until n) {
            arr[i][j] = st.nextToken().toInt()
            max = max(max, arr[i][j])
            min = min(min, arr[i][j])
        }
    }

    for(i in min..max) {
        answer = max(answer, getRegionCount(arr, i))
    }

    print(answer)
}

fun getRegionCount(arr: Array<IntArray>, target: Int): Int {
    var result = 0
    val check = arr.map {
        it.map { h ->
            h > target
        }.toBooleanArray()
    }

    fun dfs(currentY: Int, currentX: Int) {
        check[currentY][currentX] = false

        for(i in 0 until 4) {
            val nextY = currentY + dy[i]
            val nextX = currentX + dx[i]

            if(nextY in 0 until arr.size && nextX in 0 until arr.size && check[nextY][nextX]) dfs(nextY, nextX)
        }
    }

    for(i in 0 until arr.size) {
        for(j in 0 until arr[0].size) {
            if(check[i][j]) {
                result++
                dfs(i, j)
            }
        }
    }

    return result
}