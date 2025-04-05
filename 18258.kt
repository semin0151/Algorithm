import java.util.*

fun main() {
    val N = readLine()?.toInt() ?: 0
    val sb = StringBuilder()
    val queue: Queue<Int> = LinkedList()

    repeat(N) {
        val query = readLine() ?: ""

        when {
            query.contains("push") -> {
                val splitedQuery = query.split(" ")
                val num = splitedQuery[1].toInt()
                queue.offer(num)
            }

            query.contains("pop") -> {
                if (queue.isEmpty()) {
                    sb.append("-1\n")
                } else {
                    sb.append("${queue.poll()}\n")
                }
            }

            query.contains("size") -> {
                sb.append("${queue.size}\n")
            }

            query.contains("empty") -> {
                sb.append("${if(queue.isEmpty()) 1 else 0}\n")
            }

            query.contains("front") -> {
                if (queue.isEmpty()) {
                    sb.append("-1\n")
                } else {
                    sb.append("${queue.first()}\n")
                }
            }

            query.contains("back") -> {
                if (queue.isEmpty()) {
                    sb.append("-1\n")
                } else {
                    sb.append("${queue.last()}\n")
                }
            }
        }
    }

    print(sb)
}

/**
 * push X: 정수 X를 큐에 넣는 연산이다.
 * pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 큐에 들어있는 정수의 개수를 출력한다.
 * empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
 * front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */