import java.util.*

fun main() {
    val st = StringTokenizer(readLine())
    val sb = StringBuilder()
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val v = st.nextToken().toInt()
    val arr1 = Array<IntArray>(n.inc()) { IntArray(n.inc()){ 0 } }
    val arr2 = Array<IntArray>(n.inc()) { IntArray(n.inc()){ 0 } }
    var check = BooleanArray(n.inc()) { true }
    repeat(m) {
        val (start, end) = StringTokenizer(readLine()).run {
            nextToken().toInt() to nextToken().toInt()
        }
        arr1[start][end] = 1
        arr1[end][start] = 1
        arr2[start][end] = 1
        arr2[end][start] = 1
    }

    fun dfs(current: Int) {
        check[current] = false

        if(check.any { it }) sb.append("$current ")

        for(i in 1..n) {
            if(check[i] && arr1[current][i] != 0) {
                arr1[current][i] = 0
                dfs(i)
                arr1[current][i] = 1
            }
        }
    }

    check = BooleanArray(n.inc()) { true }
    dfs(v)
    sb.append("\n")

    fun bfs(start: Int) {
        val queue: Queue<Int> = LinkedList()
        queue.add(start)

        while(queue.isNotEmpty() && check.any { it }) {
            val current = queue.poll()
            if(check[current].not()) continue
            sb.append("$current ")
            check[current] = false

            for(i in 1..n) {
                if(check[i] && arr2[current][i] != 0) {
                    arr2[current][i] = 0
                    queue.add(i)
                }
            }
        }

        sb.append("\n")
    }

    check = BooleanArray(n.inc()) { true }
    bfs(v)

    print(sb.toString())
}

