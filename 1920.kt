import java.util.*

fun main() {
    val n = readLine()?.toInt()?:0
    val set = HashSet<Long>()
    val arr = arrayListOf<Long>()
    val sb = StringBuilder()
    var st = StringTokenizer(readLine())

    for(cnt in 1..n) {
        set.add(st.nextToken().toLong())
    }

    val m = readLine()?.toInt()?:0
    st = StringTokenizer(readLine())
    for(cnt in 1..m) {
        arr.add(st.nextToken().toLong())
    }

    arr.map { num ->
        if(set.contains(num)) sb.append("1\n")
        else sb.append("0\n")
    }

    print(sb)
}