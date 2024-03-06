fun main() {
    val count = readLine()?.toInt()?:0
    val sb = StringBuilder()

    for (num in count downTo 1) {
        for(num2 in 1..num) {
            sb.append("*")
        }
        sb.append("\n")
    }

    print(sb)
}