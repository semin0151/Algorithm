import java.util.*

fun main() {
    val (n, m) = StringTokenizer(readLine()).run {
        nextToken().toInt() to nextToken().toInt()
    }
    val arr = mutableListOf<Int>().apply {
        val st = StringTokenizer(readLine())
        repeat(n) {
            add(st.nextToken().toInt())
        }
        sort()
    }
    val intArr = IntArray(m)
    val checkArr = BooleanArray(n) { true }
    val sb = StringBuilder()

    fun recursion(current: Int) {
        if(current >= m) {
            sb.append("${intArr.map{arr[it]}.joinToString(" ")}\n")
        } else {
            var before = 0
            for(i in 0 until arr.size) {
                if(checkArr[i] && before != arr[i]) {
                    intArr[current] = i
                    before = arr[i]
                    checkArr[i] = false
                    recursion(current.inc())
                    checkArr[i] = true
                }
            }
        }
    }

    recursion(0)
    print(sb.toString())
}