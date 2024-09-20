import java.util.*

fun main() {
    val num = readLine()?.toInt() ?: 0
    val st = StringTokenizer(readLine())
    val sb = StringBuilder()
    val arr = (1..num).toList().map { st.nextToken().toInt() }
    val sorted = arr.distinct().sorted()
    val map = hashMapOf<Int, Int>()
    var idx = 0
    sorted.forEach {  
        map[it] = idx++
    }
    arr.forEach { 
        sb.append("${map.get(it)} ")
    }

    print(sb.toString())
}