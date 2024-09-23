import java.util.*

fun main() {
    val n = readLine()?.toInt() ?: 0
    val arr = mutableListOf<Int>().apply {
        val st = StringTokenizer(readLine())
        repeat(n) {
            add(st.nextToken().toInt())
        }

        sort()
    }

    print("${arr.filterIndexed { index, num -> checkGood(arr.filterIndexed {index2, _ -> index != index2}, num)}.count()}")
}

fun checkGood(arr: List<Int>, target: Int): Boolean {
    var start = 0
    var end = arr.size.dec()
    
    while(start < end) {
        val sum = arr[start] + arr[end]
        if(sum == target) return true
        else if(sum < target) start++
        else end--
    }
    return false
}