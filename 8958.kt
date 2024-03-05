fun main() {
    val time = readLine()?.toInt()?:0
    val sb = StringBuilder()
    for(testcase in 1..time) {
        val ox = readLine()?:""
        sb.append("${getPoint(ox)}\n")
    }
    print(sb)
}

fun getPoint(ox: String): Int {
    var total = 0
    var current = 0
    ox.map { char ->
        if(char == 'O') {
            current++
            total += current
        } else {
            current = 0
        }
    }
    return total
}