import java.util.*

fun main() {
    val n = readLine()?.toInt() ?: 0
    val arr = Array<IntArray>(n) { IntArray(n) }
    var blue = 0
    var white = 0

    for(i in 0 until n) {
        val st = StringTokenizer(readLine())
        for(j in 0 until n) {
            arr[i][j] = st.nextToken().toInt()
        }
    }

    fun check(startY: Int, startX: Int, d: Int): Boolean {
        for (i in startY until startY + d) {
            for(j in startX until startX + d) {
                if(arr[startY][startX] != arr[i][j]) return false
            }
        }
        return true
    }

    fun dfs(startY: Int, startX: Int, d: Int) {
        if(check(startY, startX, d)){
            if(arr[startY][startX] == 0) white++
            else blue++
            return
        } 
        else {
            val nextD = d.div(2)
            dfs(startY, startX, nextD)
            dfs(startY + nextD, startX, nextD)
            dfs(startY, startX + nextD, nextD)
            dfs(startY + nextD, startX + nextD, nextD)
        }
    }

    dfs(0, 0, n)
    print("$white\n$blue")
}