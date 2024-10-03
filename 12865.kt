import java.util.*
import kotlin.math.*

fun main() {
    val (n, k) = readLine()?.split(" ")?.map{ it.toInt() }?: emptyList()
    val arr = IntArray(k.inc())

    repeat(n) {
        val (w, v) = readLine()?.split(" ")?.map{ it.toInt() }?: emptyList()

        for(i in k downTo w) {
            arr[i] = max(arr[i], arr[i-w] + v)
        }
    }

    print("${arr.max()}")
}