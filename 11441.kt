import java.util.*

fun main() {
    val n = readLine()?.toInt() ?: 0
    val arr = Array<Int>(n.inc()) { 0 }
    val st = StringTokenizer(readLine())
    val sb = StringBuilder()

    for(i in 0..n) {
        if(i == 0) arr[i] = 0 
        else if(i == 1) arr[i] = st.nextToken().toInt()
        else arr[i] = arr[i-1] + st.nextToken().toInt()
    }

    val m = readLine()?.toInt() ?: 0
    repeat(m) {
        val (start, end) = StringTokenizer(readLine()).run {
            nextToken().toInt() to nextToken().toInt()
        }

        sb.append("${arr[end] - arr[start.dec()]}\n")
    }

    print(sb.toString())
}