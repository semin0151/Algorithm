import java.util.*

fun main() {
    val sb = StringBuilder()

    while(true) {
        val st = StringTokenizer(readLine())
        val num1 = st.nextToken().toInt()
        val num2 = st.nextToken().toInt()

        if(num1 == 0 && num2 == 0) break

        if(num1 > num2) {
            sb.append("Yes\n")
        } else {
            sb.append("No\n")
        }
    }

    print(sb)
}