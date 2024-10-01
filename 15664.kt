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
    val sb = StringBuilder()

    fun recursion(current: Int) {
        if(current >= m) {
            sb.append("${intArr.map{ arr[it] }.joinToString(" ")}\n")
        } else {
            var before = -1
            for(i in 0 until n) {
                if((current == 0 || intArr[current.dec()] < i) && before != arr[i]) {
                    before = arr[i]
                    intArr[current] = i
                    recursion(current.inc())
                }
            }
        }
    }
    
    recursion(0)
    print(sb.toString())
}