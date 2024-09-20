import java.util.*

fun main() {
    var st = StringTokenizer(readLine())
    val sizeA = st.nextToken()?.toInt() ?: 0
    val sizeB = st.nextToken()?.toInt() ?: 0
    val total = hashSetOf<Int>()
    st = StringTokenizer(readLine())
    val A = hashSetOf<Int>().apply {
        repeat(sizeA) {
            val num = st.nextToken().toInt()
            add(num)
            total.add(num)
        }
    }
    st = StringTokenizer(readLine())
    val B = hashSetOf<Int>().apply {
        repeat(sizeB) {
            val num = st.nextToken().toInt()
            add(num)
            total.add(num)
        }
    }
    var answer = A.size + B.size
    total.forEach {
        if(A.contains(it) && B.contains(it)) {
            answer = answer.minus(2)
        }
    }

    print("${answer}")
}