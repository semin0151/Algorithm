import java.util.*

fun main() {
    val st = StringTokenizer(readLine())
    val a = st.nextToken().toBigInteger()
    val b = st.nextToken().toBigInteger()
    val c = st.nextToken().toBigInteger()
    var answer = "1".toBigInteger()
    
    repeat(b.toInt()) {
        answer = answer * a
    }

    print("${answer % c}")
}