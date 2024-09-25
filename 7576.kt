import java.util.*
import kotlin.math.*

fun main() {
    val dy = listOf(1,-1,0,0)
    val dx = listOf(0,0,-1,1)
    val (m, n) = StringTokenizer(readLine()).run {
        nextToken().toInt() to nextToken().toInt()
    }

    val arr = Array<IntArray>(n) { IntArray(m) }
    val check = Array<BooleanArray>(n) { BooleanArray(m){true} }
    val tomato: Queue<Pair<Int, Int>> = LinkedList()

    for(i in 0 until n) {
        val intArr = readLine()?.split(" ")?.map{ it.toInt() } ?: emptyList()
        for(j in 0 until m) {
            arr[i][j] = intArr[j]
            if(intArr[j] == 1) {
                tomato.offer(i to j)
                check[i][j] = false
            }

            if(intArr[j] == -1) {
                check[i][j] = false
            }
        }
    }


    fun bfs() {

        while(tomato.isNotEmpty()) {
            val current = tomato.poll()
            val currentY = current.first
            val currentX = current.second

            for(i in 0 until 4) {
                val nextY = currentY + dy[i]
                val nextX = currentX + dx[i]

                if(nextY in 0 until n && nextX in 0 until m && check[nextY][nextX]) {
                    check[nextY][nextX] = false
                    arr[nextY][nextX] = arr[currentY][currentX] + 1
                    tomato.offer(nextY to nextX)
                }
            }
        }
    }

    bfs()

    print("${getAnswer(arr)}")
}

fun getAnswer(arr: Array<IntArray>): Int {
    return if(arr.any { arr2 -> arr2.any{ it == 0 } }) -1
    else arr.map {it.max()}.max().dec()
}