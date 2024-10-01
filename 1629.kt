import java.util.*

fun main() {
    val st = StringTokenizer(readLine())
    val a = st.nextToken().toLong()
    val b = st.nextToken().toLong()
    val c = st.nextToken().toLong()

    print("${recursion(a, b, c).rem(c)}")
}

fun recursion(a: Long, b: Long, c:Long): Long {
    return if(b == 0L) 1L
    else if(b == 1L) a.rem(c)
    else {
        val div = recursion(a, b.div(2), c)
        
        if(b.rem(2) == 0L) (div * div).rem(c)
        else ((div * div).rem(c) * a).rem(c)
    }
}