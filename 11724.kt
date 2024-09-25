import java.util.*

fun main() {
    val (n, m) = StringTokenizer(readLine()).run {
        nextToken().toInt() to nextToken().toInt()
    }
    val arr = Array<IntArray>(n.inc()) { IntArray(n.inc()) }
    var check = BooleanArray(n.inc()) { true }
    var answer = 0
    check[0] = false
    repeat(m) {
        val (u, v) = StringTokenizer(readLine()).run {
            nextToken().toInt() to nextToken().toInt()
        }

        arr[u][v] = 1
        arr[v][u] = 1
    }

    fun dfs(current: Int) {
        check[current] = false

        for(i in 1..n) {
            if (arr[current][i] != 0) {
                arr[current][i] = 0
                dfs(i)
            }
        }
    }

    for(i in 1..n) {
        if (check[i]) {
            dfs(i)
            answer++
        }
    }

    print("$answer")
}