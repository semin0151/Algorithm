import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val (k, n) = StringTokenizer(br.readLine()).run {
        nextToken().toInt() to nextToken().toInt()
    }

    val list = (1..k).toList().map {
        br.readLine().toInt()
    }

    for(unit in (list.min() downTo 0)) {
        if(n <= list.map { it.div(unit) }.sum()) {
            bw.write("$unit")
            bw.close()
            return
        }
    }
}