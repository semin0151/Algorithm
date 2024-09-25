import java.util.*

fun main() {
    val testcase = readLine()?.toInt() ?: 0
    val dy: List<Int> = listOf(1, -1, 0, 0)
    val dx: List<Int> = listOf(0, 0, -1, 1)

    repeat(testcase) {
        val st = StringTokenizer(readLine())
        val m = st.nextToken().toInt()
        val n = st.nextToken().toInt()
        val k = st.nextToken().toInt()
        val arr = Array<IntArray>(n) { IntArray(m) }
        var cnt = 0

        repeat(k) {
            val (x, y) = StringTokenizer(readLine()).run {
                nextToken().toInt() to nextToken().toInt()
            }

            arr[y][x] = 1
        }

        fun dfs(currentY: Int, currentX: Int) {
            for(i in 0 until 4) {
                val nextY = currentY.plus(dy[i])
                val nextX = currentX.plus(dx[i])

                if(nextY in 0 until n && nextX in 0 until m && arr[nextY][nextX] != 0) {
                    arr[nextY][nextX] = 0
                    dfs(nextY,nextX)
                }
            }
        }

        
        for(i in 0 until n) {
            for(j in 0 until m) {
                if(arr[i][j] == 1) {
                    cnt++
                    dfs(i, j)
                    arr[i][j] = 0
                }
            }
        }

        print("$cnt\n")
    }
}