fun main() {
    val text = readLine()?:""
    val sb = StringBuilder()

    text.map { char ->
        if(char.code >= 'a'.code && char.code <= 'z'.code) {
            val changeCode = char.code + 13
            if(changeCode >= 'a'.code && changeCode <= 'z'.code) {
                sb.append("${changeCode.toChar()}")
            } else {
                sb.append("${(changeCode-26).toChar()}")
            }
        } else if(char.code >= 'A'.code && char.code <= 'Z'.code) {
            val changeCode = char.code + 13
            if(changeCode >= 'A'.code && changeCode <= 'Z'.code) {
                sb.append("${changeCode.toChar()}")
            } else {
                sb.append("${(changeCode-26).toChar()}")
            }
        } else {
            sb.append("${char}")
        }
    }

    print(sb)
}