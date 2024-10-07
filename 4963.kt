import java.util.*

fun main() {
    val dy = listOf(1,1,1,0,-1,-1,-1,0)
    val dx = listOf(-1,0,1,1,1,0,-1,-1)
    val sb = StringBuilder()

    while(true) {
        val (w, h) = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()
        var answer = 0

        if(w == 0 && h == 0) break

        val arr = Array<IntArray>(h) { IntArray(w) }

        for(i in 0 until h) {
            val st = StringTokenizer(readLine())
            for(j in 0 until w) {
                arr[i][j] = st.nextToken().toInt()
            }
        }

        fun bfs(currentY: Int, currentX: Int) {
            for(i in 0 until 8) {
                val nextY = currentY + dy[i]
                val nextX = currentX + dx[i]

                if(nextY in 0 until h && nextX in 0 until w && arr[nextY][nextX] != 0) {
                    arr[nextY][nextX] = 0
                    bfs(nextY, nextX)
                }
            }
        }

        for(i in 0 until h) {
            for(j in 0 until w) {
                if(arr[i][j] != 0) {
                    arr[i][j] = 0
                    answer++
                    bfs(i, j)
                }
            }
        }

        sb.append("$answer\n")
    }  
    
    print(sb.toString())
}