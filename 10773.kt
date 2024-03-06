import java.util.*

fun main () {
    val time = readLine()?.toInt()?:0
    val stack = Stack<Int>()

    for (testcase in 1..time) {
        val num = readLine()?.toInt()?:0

        if(num == 0) {
            stack.pop()
        } else {
            stack.add(num)
        }
    }

    print("${stack.sum()}")
}