import java.util.*

fun main() {
    val n = readLine()?.toInt() ?: 0
    val arr = Array<ArrayList<Int>>(n.inc()) { arrayListOf() }
    val checkArr = BooleanArray(n.inc()) { true }
    val answer = IntArray(n.inc())

    repeat(n-1) {
        val (i, j) = StringTokenizer(readLine()).run {
            nextToken().toInt() to nextToken().toInt()
        }

        arr[i].add(j)
        arr[j].add(i)
    }

    val queue: Queue<Int> = LinkedList()
    queue.offer(1)
    checkArr[1] = false

    while(queue.isNotEmpty()) {
        val current = queue.poll()

        for(num in arr[current]) {
            if(checkArr[num]) {
                answer[num] = current
                checkArr[num] = false
                queue.offer(num)
            }
        }
    }

    print("${answer.filterIndexed{ index, _ -> index > 1 }.joinToString("\n")}")
}