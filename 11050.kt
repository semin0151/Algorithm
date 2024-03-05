import java.util.*

fun main() {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    print("${getFactorial(n)/(getFactorial(n-k) * getFactorial(k))}")
}

fun getFactorial(num: Int): Int {
    return if(num > 1) num * getFactorial(num.minus(1))
    else 1
}