import java.util.*
import kotlin.math.*

fun main() {
    val testcase = readLine()?.toInt() ?: 0
    val sb = StringBuilder()

    for (time in 1..testcase) {
        val st = StringTokenizer(readLine())
        val left = st.nextToken().toInt()
        val right = st.nextToken().toInt()

        sb.append("${getAnswer(left, right)}\n")
    }
    
    print(sb)
}

fun getAnswer(a: Int, b: Int): Long {
    if(a == b) return 1
    val first = getSet((b-a).toLong(), b.toLong())
    val second = getSet(1, a.toLong())
    var answer = 1L

    first.map {
        if(!second.contains(it)) {
            answer *= it
        }
    }
    second.map {
        if(!first.contains(it)) {
            answer /= it
        }
    }
    return answer
}

fun getSet(from: Long, to: Long): HashSet<Long> {
    val set = HashSet<Long>()

    for(num in to downTo from+1) {
        set.add(num)
    }

    return set
}