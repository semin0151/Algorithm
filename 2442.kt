fun main() {
    val num = 2
    // val num = readLine()?.toInt()?:0
    val sb = StringBuilder()

    for(index in 1..num) {

        for(index2 in 1..num-index) {
            sb.append(" ")
        }
        for(index2 in num-index+2..num) {
            sb.append("*")
        }
        sb.append("*")
        for(index2 in num downTo num-index+2) {
            sb.append("*")
        }
        sb.append("\n")
    }
    print(sb)
}