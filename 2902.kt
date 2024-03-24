fun main() {
    val text = readLine()?:""
    val splitText = text.split("-")
    val sb = StringBuilder()

    splitText.map { name ->
        sb.append("${name[0]}")
    }
    print(sb)
}