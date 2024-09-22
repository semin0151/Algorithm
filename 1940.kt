import java.util.*

fun main() {
    val n = readLine()?.toInt()?:0
    val m = readLine()?.toInt()?:0
    val arr = mutableListOf<Int>().apply {
        val st = StringTokenizer(readLine())
        repeat(n) {
            add(st.nextToken().toInt())
        }

        sort()
    }

    print("${arr.binarySearch(m)}")
}

fun MutableList<Int>.binarySearch(target: Int): Int {
    var start = 0
    var end = size.dec()
    var answer = 0

    while(start < end) {
        if(get(start) + get(end) == target) {
            answer++
            start++
            end--
            continue
        } else if(get(start) + get(end) < target) {
            start++
        } else {
            end--
        }
    }

    return answer
}