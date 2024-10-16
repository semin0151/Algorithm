fun main() {
    val num = readLine()?: "0"
    val answer = num.toString().toList().sortedByDescending { it }.joinToString("")
    print("$answer")
}