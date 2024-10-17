import java.util.*

fun main() {
    val (n, k) = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()
    val arr = IntArray(k.inc())

    arr[0] = 1
    repeat(n) {
        val coin = readLine()?.toInt() ?: 0
        for(i in coin..k) {
            arr[i] += arr[i-coin]
        }
    }
    print("${arr[k]}")   
}