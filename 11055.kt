import java.util.*
import kotlin.math.*

fun main() {
    val n = readLine()?.toInt() ?: 0

    val arr = arrayListOf<Int>().apply {
        val st = StringTokenizer(readLine())
        repeat(n) { 
            add(st.nextToken().toInt())    
        }
    }
    val check = IntArray(n) { 1 }

    check[0] = arr[0]
    for(i in 1 until n) {
        var max = 0
        for(j in i.dec() downTo 0) {
            if(arr[i] > arr[j]) {
                max = max(max, check[j])
            }
        }
        check[i] = max + arr[i]
    }

    print("${check.max()}")
}