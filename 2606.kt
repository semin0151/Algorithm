import java.util.*

fun main() {
    val n = readLine()?.toInt() ?: 0
    val t = readLine()?.toInt() ?: 0

    val arr = Array<IntArray>(n.inc()) { IntArray(n.inc()) }

    repeat(t) { 
        val (start, end) = StringTokenizer(readLine()).run {
            nextToken().toInt() to nextToken().toInt()
        }

        arr[start][end] = 1
        arr[end][start] = 1
    }

    val check = BooleanArray(n.inc()) { true }

    fun dfs(current: Int) {
        for(i in 1..n) {
            if(check[i] && arr[current][i] != 0) {
                check[i] = false
                arr[current][i] = 0
                dfs(i)
            }
        }
    }

    check[1] = false
    dfs(1)
    print("${check.count{ it.not() }.dec()}")
}