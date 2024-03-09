fun main() {
    val arr = Array<Int>(26) { 0 }
    val sb = StringBuilder()
    val text = readLine()?:""
    text.map { char ->
        arr[char.code - 'a'.code]++
    }

    arr.map { num ->
        sb.append("$num ")
    }
    print(sb)
}