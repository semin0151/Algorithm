fun main() {
    val testcase = readLine()?.toInt()?:0
    val sb = StringBuilder()

    for (time in 1..testcase) {
        val numbers = readLine()?.split(",")?:listOf()
        sb.append("${numbers.get(0).toInt() + numbers.get(1).toInt()}\n")
    }
    print(sb)
}