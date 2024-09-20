import java.util.*

fun main() {
    val testcase = readLine()?.toInt()?:0
    val sb = StringBuilder()
    repeat(testcase) {
        val num = readLine()?.toInt()?:0
        val map = hashMapOf<String, Int>()
        repeat(num) {
            val fashion = readLine()?.split(" ")?.get(1) ?: ""
            map.set(fashion, map.getOrDefault(fashion, 0).inc())
        }
        var answer = 1
        map.entries.map {
            it.value.inc()   
        }.forEach {
            answer = answer.times(it)
        }

        sb.append("${answer.dec()}\n")
    }
    print(sb.toString())
}