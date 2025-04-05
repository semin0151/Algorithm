import java.util.*

fun main() {
    val testcase = readLine()?.toInt() ?: 0
    val sb = StringBuilder()

    repeat(testcase) {
        val text = readLine() ?: ""
        val deque1: Deque<Char> = LinkedList()
        val deque2: Deque<Char> = LinkedList()

        text.forEach { ch -> 
            when(ch) {
                '<' -> {
                    if(deque1.isNotEmpty()) {
                        deque2.offerFirst(deque1.pollLast())
                    }
                }
                '>' -> {
                    if(deque2.isNotEmpty()) {
                        deque1.offerLast(deque2.pollFirst())
                    }
                }
                '-' -> {
                    if(deque1.isNotEmpty()) {
                        deque1.pollLast()
                    }
                }
                else -> {
                    deque1.offerLast(ch)
                }
            }
        }

        val result = "${deque1.joinToString("")}${deque2.joinToString("")}"
        sb.append("${result}\n")
    }

    print(sb)
}