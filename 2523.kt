fun main() {
    val num = readLine()?.toInt()?:0
    val sb = StringBuilder()

    for(count in 1..num) {
        for(count2 in 1..count) {
            sb.append("*")
        }
        sb.append("\n")
    }

    for(count in num-1 downTo 1) {
        for(count2 in 1..count) {
            sb.append("*")
        }
        sb.append("\n")
    }
    
    print(sb)
}