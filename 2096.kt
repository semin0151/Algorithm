import java.util.*
import kotlin.math.*

fun main() {
    val n = readLine()?.toInt() ?: 0

    val dpMax = Array<IntArray>(n) { IntArray(3) }
    val dpMin = Array<IntArray>(n) { IntArray(3) }


    for(i in 0 until n) {
        val (n0, n1, n2) = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()
        if(i == 0) {
            dpMax[i][0] = n0
            dpMax[i][1] = n1
            dpMax[i][2] = n2

            dpMin[i][0] = n0
            dpMin[i][1] = n1
            dpMin[i][2] = n2
        } else {
            dpMax[i][0] = n0 + max(dpMax[i.dec()][0], dpMax[i.dec()][1])
            dpMax[i][1] = n1 + max(max(dpMax[i.dec()][0], dpMax[i.dec()][1]), dpMax[i.dec()][2])
            dpMax[i][2] = n2 + max(dpMax[i.dec()][1], dpMax[i.dec()][2])

            dpMin[i][0] = n0 + min(dpMin[i.dec()][0], dpMin[i.dec()][1])
            dpMin[i][1] = n1 + min(min(dpMin[i.dec()][0], dpMin[i.dec()][1]), dpMin[i.dec()][2])
            dpMin[i][2] = n2 + min(dpMin[i.dec()][1], dpMin[i.dec()][2])
        }
    }

    print("${dpMax[n.dec()].max()} ${dpMin[n.dec()].min()}")
}