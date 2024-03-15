import java.util.*
import kotlin.math.*

fun main() {
    val st = StringTokenizer(readLine())
    val num1 = st.nextToken().toLong()
    val num2 = st.nextToken().toLong()
    
    print("${abs(max(num1, num2) - min(num1,num2))}")
}

fun abs(num: Long): Long {
    return if(num < 0) num*(-1)
    else num
}