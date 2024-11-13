import java.util.*
import kotlin.math.*

fun main() {
    val(n, m) = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()
    val arr = Array<IntArray>(n) { IntArray(n) }
    val chickenList = arrayListOf<Pair<Int, Int>>()
    val homeList = arrayListOf<Pair<Int, Int>>()
    val chickenIndexList = IntArray(m)
    var answer = Int.MAX_VALUE

    for(i in 0 until n) {
        val st = StringTokenizer(readLine())
        for(j in 0 until n) {
            arr[i][j] = st.nextToken().toInt()

            if(arr[i][j] == 1) {
                homeList.add(i to j)
            } else if(arr[i][j] == 2) {
                chickenList.add(i to j)
            }
        }
    }

    fun recursion(current: Int) {
        if(current == m) {
            val cityChickenDistance = homeList.sumOf { home ->
                chickenIndexList.minOf { chickenIndex ->
                    val chicken = chickenList[chickenIndex]
                    getChickenDistance(chicken.first, chicken.second, home.first, home.second)
                }
            }

            answer = min(answer, cityChickenDistance)
        } else {
            for(i in 0 until chickenList.size) {
                if(current == 0 || chickenIndexList[current.dec()] < i) {
                    chickenIndexList[current] = i
                    recursion(current.inc())
                }
            }    
        }
    }

    recursion(0)
    print("$answer")
}

fun getChickenDistance(y1: Int, x1: Int, y2: Int, x2: Int): Int {
    return abs(y1-y2) + abs(x1-x2)
}