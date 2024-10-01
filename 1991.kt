import java.util.*

fun main() {
    val n = readLine()?.toInt() ?: 0
    val arr = Array<Pair<Int, Int>>(n) { -1 to -1}
    val postfix = StringBuilder()
    val infix = StringBuilder()
    val prefix = StringBuilder()

    repeat(n) {
        val st = StringTokenizer(readLine())
        val root = st.nextToken().toCharInt()
        val left = st.nextToken().toCharInt()
        val right = st.nextToken().toCharInt()

        arr[root] = left to right
    }

    fun recursion(current: Int) {
        postfix.append("${current.toCharString()}")
    
        if(arr[current].first != -1) {
            recursion(arr[current].first)
        }

        infix.append("${current.toCharString()}")

        if(arr[current].second != -1) {
            recursion(arr[current].second)
        }

        prefix.append("${current.toCharString()}")
    }

    recursion(0)
    postfix.append("\n")
    infix.append("\n")
    prefix.append("\n")

    print(postfix.toString())
    print(infix.toString())
    print(prefix.toString())
}

fun String.toCharInt(): Int {
    return if(this[0] == '.') -1
    else this[0] - 'A'
}

fun Int.toCharString(): String {
    return ('A' + this).toString()
}