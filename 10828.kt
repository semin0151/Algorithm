import java.util.*

fun main() {
    val stack = Stack<Int>()
    val time = readLine()?.toInt()?:0
    val sb = StringBuilder()

    for (testcase in 1..time) {
        val splitText = readLine()?.split(" ")?:emptyList()
        val order = splitText[0]

        when (order) {
            "push" -> {
                val num = splitText[1].toInt()
                stack.push(num)
            }
            "pop" -> {
                if(stack.isEmpty()) {
                    sb.append("-1\n")
                } else {
                    sb.append("${stack.pop()}\n")
                }
            }
            "size" -> {
                sb.append("${stack.size}\n")
            }
            "empty" -> {
                if(stack.isEmpty()) {
                    sb.append("1\n")
                } else {
                    sb.append("0\n")
                }
            }
            "top" -> {
                if(stack.isEmpty()) {
                    sb.append("-1\n")
                } else {
                    sb.append("${stack.peek()}\n")
                }
            }
        }
    }
    print(sb)
}