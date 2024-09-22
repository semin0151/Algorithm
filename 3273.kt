import java.util.*

fun main() {
    val num = readLine()?.toInt() ?: 0
    val st = StringTokenizer(readLine())
    val arr = mutableListOf<Int>().apply {
        repeat(num) {
            add(st.nextToken().toInt())
        }
    }.sorted()

    val x = readLine()?.toInt() ?: 0
    var answer = 0
    val half = if(num.rem(2) == 0) {
        num.div(2)
    } else {
        num.div(2).inc()
    }

    for (i in arr.indices) {
        if(arr.binarySearch(x.minus(arr[i])) >= 0) answer++
    }

    print("${answer.div(2)}")
}