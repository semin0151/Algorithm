fun main() {
    val sb = StringBuilder()
    while(true) {
        val text = readLine()
        if(text == null) break
        else sb.append("${text}\n")
    }
    print(sb)
}