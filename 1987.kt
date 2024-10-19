import java.util.*

fun main() {
    val dy = listOf(1, -1, 0, 0)
    val dx = listOf(0, 0, -1, 1)
    val (r, c) = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()
    val arr = Array<CharArray>(r) { readLine()?.toCharArray() ?: CharArray(c) }
    val set = hashSetOf<Char>()
    var answer = -1

    fun dfs(currentY: Int, currentX: Int) {
        if(set.size > answer) {
            answer = set.size
        }
        
        for(i in 0 until 4) {
            val nextY = currentY + dy[i]
            val nextX = currentX + dx[i]
            
            if(nextY in 0 until r && nextX in 0 until c && set.contains(arr[nextY][nextX]).not()) {
                set.add(arr[nextY][nextX])
                dfs(nextY, nextX)
                set.remove(arr[nextY][nextX])
            }
        }
    }

    set.add(arr[0][0])
    dfs(0, 0)
    print("${answer}")
}

/**
 * 2 4
 * CAAB
 * ADCB
 */