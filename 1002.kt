import java.util.*
import kotlin.math.*

fun main() {
    val time = readLine()?.toInt()?:0
    val sb = StringBuilder()

    for (testcase in 1..time) {
        val st = StringTokenizer(readLine())
        val x1 = st.nextToken().toInt()
        val y1 = st.nextToken().toInt()
        val r1 = st.nextToken().toInt().toDouble()
        val x2 = st.nextToken().toInt()
        val y2 = st.nextToken().toInt()
        val r2 = st.nextToken().toInt().toDouble()

        val distance = getDistance(x1, y1, x2, y2)

        if(distance == 0.0 && r1 == r2) {
            sb.append("-1\n")
        } else if (distance == r1 + r2 || distance == abs(r1-r2)) {
            sb.append("1\n")
        } else if (abs(r1-r2) < distance && distance < r1 + r2) {
            sb.append("2\n")
        } else {
            sb.append("0\n")
        }
    }

    print(sb)
}

fun getDistance(x1: Int, y1: Int, x2: Int, y2:Int): Double {
    return sqrt(((x1-x2) * (x1-x2)) + ((y1-y2) * (y1-y2)).toDouble())
}

fun abs(num: Double): Double {
    return if(num > 0) num
    else num*-1
}