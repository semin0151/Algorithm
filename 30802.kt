import java.util.*

fun main() {
    val num = readLine()?.toInt()?:0
    var st = StringTokenizer(readLine())
    val arr = mutableListOf<Int>().apply {
        repeat(6) {
            add(st.nextToken().toInt())
        }
    }
    val (T, P) = StringTokenizer(readLine()).run {
        nextToken().toInt() to nextToken().toInt()
    }
    val sb = StringBuilder()

    sb.append("${arr.map { 
        if(it.rem(T) == 0) it.div(T)
        else it.div(T).inc()
    }.sum()}\n")
    sb.append("${num.div(P)} ${num.rem(P)}")

    print(sb.toString())
}