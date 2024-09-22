import java.util.*

fun main() {
    val (n, m) = StringTokenizer(readLine()).run {
        nextToken().toInt() to nextToken().toInt()
    }
    val arr = mutableListOf<Int>()
    var st = StringTokenizer(readLine())
    repeat(n) {
        arr.add(st.nextToken().toInt())
    }
    st = StringTokenizer(readLine())
    repeat(m) {
        arr.add(st.nextToken().toInt())
    }
    
    print("${arr.sorted().joinToString(" ")}")
}