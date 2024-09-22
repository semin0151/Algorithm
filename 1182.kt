import java.util.*

fun main() {
    val (n, s) = StringTokenizer(readLine()).run {
        nextToken().toInt() to nextToken().toInt()
    }
    val arr = mutableListOf<Int>().apply {
        val st = StringTokenizer(readLine())
        repeat(n) {
            add(st.nextToken().toInt())
        }
    }

    var check = BooleanArray(n) { false } 
    var answer = if(s==0) -1 else 0

    fun recursion(current: Int) {
        if(current == n) {
            val result = check.mapIndexed { index, isAvailable ->
                if(isAvailable) arr[index]
                else 0
            }.sum()

            if(result == s) answer++
        } else {
            check[current] = true
            recursion(current.inc())
            check[current] = false
            recursion(current.inc())
        }
    }

    recursion(0)
    print("$answer")
}