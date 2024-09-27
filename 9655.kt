fun main() {
    val n = readLine()?.toInt() ?: 0

    val answer = if(n.rem(2) == 0) "CY"
    else "SK"

    print("$answer")
}