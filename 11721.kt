fun main() {
    val text = readLine()?:""
    val sb = StringBuilder()
    text.mapIndexed { index, char ->
        if(index%10 == 9) {
            sb.append("$char\n")
        } else {
            sb.append("$char")
        }
    }
    print(sb)
}