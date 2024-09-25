import java.util.*

fun main() { 
    val (n, k) = StringTokenizer(readLine()).run {
        nextToken().toInt() to nextToken().toInt()
    }
    var answer = 0
    val check = BooleanArray(100_001) { true }

    fun bfs(num: Int, current: Int) {
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        var nextNum: Int
        check[num] = false
        queue.offer(num to current)

        while(queue.isNotEmpty()) {
            val currentPair = queue.poll()
            val currentNum = currentPair.first
            val currentIndex = currentPair.second

            if(currentNum == k) {
                answer = currentIndex
                break
            } else {
                nextNum = currentNum.times(2)
                if(nextNum in 0..100_000 && check[nextNum]) {
                    check[nextNum] = false
                    queue.offer(nextNum to currentIndex.inc())
                }
                nextNum = currentNum.inc()
                if(nextNum in 0..100_000 && check[nextNum]) {
                    check[nextNum] = false
                    queue.offer(nextNum to currentIndex.inc())
                }
                nextNum = currentNum.dec()
                if(nextNum in 0..100_000 && check[nextNum]) {
                    check[nextNum] = false
                    queue.offer(nextNum to currentIndex.inc())
                }
            }
        }
    }

    bfs(n, 0)

    print("$answer")
}