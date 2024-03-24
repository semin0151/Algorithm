fun main() {
    val testcase = readLine()?.toInt()?:0
    val sb = StringBuilder()

    for(time in 1..testcase) {
        val splitText = readLine()?.split(" ")?:listOf()
        splitText.map { text ->
            sb.append("${text.reversed()} ")
        }
        sb.append("\n")
    }

    print(sb)
}