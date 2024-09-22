import java.util.*

fun main() {
    val testcase = readLine()?.toInt() ?: 0
    val sb = StringBuilder()

    repeat(testcase) {
        val n = readLine()?.toInt() ?: 0
        val arr = mutableListOf<Pair<Int, Int>>().apply {
            repeat(n) {
                add(StringTokenizer(readLine()).run {
                    nextToken().toInt() to nextToken().toInt()
                })
            }
        }.sortedWith { o1, o2 ->
            o1.first.compareTo(o2.first)
        }
        var secondPoint = Int.MAX_VALUE
        var answer = 0

        arr.forEach {
            if(secondPoint > it.second) {
                secondPoint = it.second
                answer++
            }
        }

        sb.append("${answer}\n")
    }

    print(sb.toString())
}