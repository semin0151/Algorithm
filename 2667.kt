import java.util.*
import kotlin.emptyArray
import kotlin.charArrayOf

val dy: List<Int> = listOf(1, -1, 0, 0)
val dx: List<Int> = listOf(0, 0, -1, 1)

fun main() {
    val num = readLine()?.toInt()?:0
    val arr = mutableListOf<CharArray>()
    repeat(num) {
        arr.add(readLine()?.toCharArray() ?: charArrayOf())
    }

    var answer = mutableListOf<Int>()
    var cnt = 0

    fun dfs(currentX: Int, currentY: Int) {
        arr[currentX][currentY] = '0'
        cnt++

        for(i in 0 until 4) {
            val nextX = currentX.plus(dx[i])
            val nextY = currentY.plus(dy[i])
            if(nextX in 0..num.dec() && nextY in 0..num.dec() && arr[nextX][nextY] != '0') {
                dfs(nextX, nextY)
            }
        }
    }

    for(i in 0 until num) {
        for(j in 0 until num) {
            if(arr[j][i] != '0') {
                dfs(j, i)
                answer.add(cnt)
                cnt = 0
            }
        }
    }

    print("${answer.size}\n")
    print("${answer.sorted().joinToString("\n")}")
}