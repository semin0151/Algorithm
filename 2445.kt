fun main() {
    val num = readLine()?.toInt()?:0
    val sb = StringBuilder()

    for(index1 in 1..num) {
        for(index2 in 1..index1) {
            sb.append("*")
        }
        for(index2 in index1 until num) {
            sb.append(" ")
        }

        for(index2 in num downTo index1+1) {
            sb.append(" ")
        }
        for(index2 in index1 downTo 1) {
            sb.append("*")
        }
        sb.append("\n")
    }
    for(index1 in num-1 downTo 1) {
        for(index2 in 1..index1) {
            sb.append("*")
        }
        for(index2 in index1 until num) {
            sb.append(" ")
        }

        for(index2 in num downTo index1+1) {
            sb.append(" ")
        }
        for(index2 in index1 downTo 1) {
            sb.append("*")
        }
        sb.append("\n")
    }
    
    print(sb)
}