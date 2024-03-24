fun main() {
    val text = readLine()?:""
    val sb = StringBuilder()
    text.map { char ->
        if(char.code >= 'a'.code && char.code <= 'z'.code) {
            sb.append(char.uppercase())
        } else {
            sb.append(char.lowercase())
        }
    }
    
    print(sb)
}