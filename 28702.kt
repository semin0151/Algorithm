
fun main() {
    val t1 = readLine() ?: ""
    val t2 = readLine() ?: ""
    val t3 = readLine() ?: ""

    val answer = if(t1.all { it.isDigit() }) t1.toInt().plus(3)
    else if(t2.all { it.isDigit() }) t2.toInt().plus(2)
    else if(t3.all { it.isDigit() }) t3.toInt().plus(1)
    else 0

    if(answer.rem(3) == 0 && answer.rem(5) == 0) print("FizzBuzz")
    else if(answer.rem(3) == 0) print("Fizz")
    else if(answer.rem(5) == 0) print("Buzz")
    else print("$answer")
}