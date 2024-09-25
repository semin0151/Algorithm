import java.util.*

fun main() {
    val num = readLine()?.toInt() ?: 0
    val arr = Array<CharArray>(num) { CharArray(num) { ' ' } }
    val arr2 = Array<CharArray>(num) { CharArray(num) { ' ' } }
    val dy: List<Int> = listOf(1, -1, 0, 0)
    val dx: List<Int> = listOf(0, 0, -1, 1)
    var answer =0
    var answer2 = 0

    for(i in 0 until num) {
        val text = readLine() ?: ""
        text.forEachIndexed { index, ch ->
            arr[i][index] = ch
            arr2[i][index] = if(ch == 'G') 'R' else ch
        }
    }

    fun dfs(currentY: Int, currentX: Int, target: Char) {
        for(i in 0 until 4) {
            val nextY = currentY + dy[i]
            val nextX = currentX + dx[i]

            if(nextY in 0 until num && nextX in 0 until num && arr[nextY][nextX] == target) {
                arr[nextY][nextX] = ' '
                dfs(nextY, nextX, target)
            }
        }
    }

    fun dfs2(currentY: Int, currentX: Int, target: Char) {
        for(i in 0 until 4) {
            val nextY = currentY + dy[i]
            val nextX = currentX + dx[i]

            if(nextY in 0 until num && nextX in 0 until num && arr2[nextY][nextX] == target) {
                arr2[nextY][nextX] = ' '
                dfs2(nextY, nextX, target)
            }
        }
    }

    for(i in 0 until num) {
        for(j in 0 until num){
            if(arr[i][j] != ' ') {
                dfs(i, j, arr[i][j])
                arr[i][j] = ' '
                answer++
            }

            if(arr2[i][j] != ' ') {
                dfs2(i, j, arr2[i][j])
                arr2[i][j] = ' '
                answer2++
            }
        }   
    }

    print("$answer $answer2")
}