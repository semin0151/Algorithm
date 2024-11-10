import java.util.*

fun main() {
    val dy = listOf(-1, 0, 1, 0)
    val dx = listOf(0, 1, 0, -1)
    val (n, m) = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()
    var (r, c, d) = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()
    val arr = Array<IntArray>(n) { IntArray(m) }
    var answer = 0

    /** 
     * input
     */
    for(i in 0 until n) {
        val st = StringTokenizer(readLine())
        for(j in 0 until m) {
            arr[i][j] = st.nextToken().toInt()
        }
    }

    while(true) {
        if(arr[r][c] == 0) {
            arr[r][c] = 2
            answer++
        }

        val isCleanRequire = (0 until 4).toList().any { arr[r+dy[it]][c+dx[it]] == 0 }
        if(isCleanRequire) {
            d = d.rotate(1)
            val nextR = r + dy[d]
            val nextC = c + dx[d]

            if(arr[nextR][nextC] == 0) {
                r = nextR
                c = nextC
            }
        } else {
            val tmp = d.rotate(2)
            val nextR = r + dy[tmp]
            val nextC = c + dx[tmp]

            if(arr[nextR][nextC] == 1) {
                break
            } else {
                r = nextR
                c = nextC
            }
        }
    }

    print("$answer")
}

fun Int.rotate(angle: Int): Int {
    return if(this.minus(angle) in 0 until 4) return this.minus(angle)
    else this.minus(angle).plus(4)
}