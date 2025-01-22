import java.util.*

fun main() {
    val n = readLine()?.toInt() ?: 0
    val stack = Stack<Int>()
    val sb = StringBuilder()

    repeat(n) {
        val text = readLine() ?: ""
        val order = text[0].digitToInt()

        when(order) {
            1 -> {
                val num = text.split(" ").map {it.toInt()}.last()
                stack.add(num)
            }
            
            2 -> {
                if (stack.isEmpty()) {
                    sb.append("-1\n")
                } else {
                    sb.append("${stack.pop()}\n")
                }
            }

            3 -> {
                sb.append("${stack.size}\n")
            } 

            4 -> {
                if (stack.isEmpty()) {
                    sb.append("1\n")
                } else {
                    sb.append("0\n")
                }
            }

            else -> {
                if (stack.isEmpty()) {
                    sb.append("-1\n")
                } else {
                    sb.append("${stack.peek()}\n")
                }
            }
        }
    }

    print(sb)
}