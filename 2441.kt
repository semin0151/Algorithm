fun main() {
    val count = readLine()?.toInt()?:0
    val sb = StringBuilder()

    for (num in count downTo 1) {
        for(num2 in count downTo num + 1) {
            sb.append(" ")
        }
        for(num2 in num downTo 1) {
            sb.append("*")
        }
        sb.append("\n")
    }

    print(sb)
}