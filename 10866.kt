import java.util.*

fun main() {
    val time = readLine()?.toInt()?:0
    val deque = ArrayDeque<Int>()
    val sb = StringBuilder()

    for (testcase in 1..time) {
        val text = readLine()?:""
        val splitText = text.split(" ")
        val order = splitText[0]

        when(order) {
            "push_back" -> {
                val num = splitText[1].toInt()
                deque.addLast(num)
            }
            "push_front" -> {
                val num = splitText[1].toInt()
                deque.addFirst(num)
            }
            "pop_back" -> {
                if(deque.isEmpty()) {
                    sb.append("-1\n")
                } else {
                    sb.append("${deque.pollLast()}\n")
                }
            }
            "pop_front" -> {
                if(deque.isEmpty()) {
                    sb.append("-1\n")
                } else {
                    sb.append("${deque.pollFirst()}\n")
                }
            }
            "size" -> {
                sb.append("${deque.size}\n")
            }
            "empty" -> {
                if(deque.isEmpty()) {
                    sb.append("1\n")
                } else {
                    sb.append("0\n")
                }
            }
            "front" -> {
                if(deque.isEmpty()) {
                    sb.append("-1\n")
                } else {
                    sb.append("${deque.peekFirst()}\n")
                }
            }
            "back" -> {
                if(deque.isEmpty()) {
                    sb.append("-1\n")
                } else {
                    sb.append("${deque.peekLast()}\n")
                }
            }
        }
    }

    print(sb)
}