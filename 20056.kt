import java.util.*

fun main() {
    // todo check direction
    val dy = listOf(1, 1, 0,-1,-1,-1, 0, 1).map { it.times(-1) }
    val dx = listOf(0, 1, 1, 1, 0,-1,-1,-1)
    val (n, m, k) = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()
    val queue: Queue<FireBall> = LinkedList()

    repeat(m) {
        val (r, c, mm, s, d) = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()
        queue.offer(FireBall(r, c, mm, s, d))
    }

    repeat(k) {
        val size = queue.size

        printMap("init", queue, n)

        for(i in 0 until size) {
            val current = queue.poll()
            print("current::${current}\n")
            val nextR = (current.r + dy[current.d].times(current.s)).checkIntRange(n)
            val nextC = (current.c + dx[current.d].times(current.s)).checkIntRange(n)
            queue.offer(FireBall(nextR, nextC, current.m, current.s, current.d))
            print("dy::${dy[current.d]} /// dx::${dx[current.d]} /// currentD::${current.d}\n")
        }

        printMap("move", queue, n)

        for(i in 0 until n) {
            for(j in 0 until n) {
                val count = queue.count { it.r == i && it.c == j}
                if (count >= 2) {
                    var mSum = 0
                    var sSum = 0
                    queue.filter {
                        it.r == i && it.c == j
                    }.also { filteredQ ->
                        val dFlag = filteredQ.all { it.d.rem(2) == 0 } || filteredQ.all { it.d.rem(2) == 1 }
                        filteredQ.map {
                            mSum += it.m
                            sSum += it.s
                        }

                        val newM = mSum.div(5)
                        val newS = sSum.div(count)
                        print("COUNT!!:${count} // newM::${newM} /// newS::${newS}\n")

                        if (newM > 0) {
                            if (dFlag) {
                                queue.offer(FireBall(i, j, newM, newS, 0))
                                queue.offer(FireBall(i, j, newM, newS, 2))
                                queue.offer(FireBall(i, j, newM, newS, 4))
                                queue.offer(FireBall(i, j, newM, newS, 6))
                            } else {
                                queue.offer(FireBall(i, j, newM, newS, 1))
                                queue.offer(FireBall(i, j, newM, newS, 3))
                                queue.offer(FireBall(i, j, newM, newS, 5))
                                queue.offer(FireBall(i, j, newM, newS, 7))
                            }
                        }
                        queue.removeAll(filteredQ)
                    }
                }
            }
        }
        
        printMap("assemble", queue, n)
    }

    val answer = queue.map { it.m }.sum()
    print("$answer")
}

fun printMap(text: String, queue: Queue<FireBall>, n: Int) {
    val arr = Array<IntArray>(n.inc()) { IntArray(n.inc()) }
    queue.forEach {
        arr[it.r][it.c] += it.m
    }

    print("\n===$text===\n${arr.filterIndexed { index, _ -> index > 0 }.map { it.filterIndexed { index, _ -> index > 0 }.joinToString(" ") }.joinToString("\n")}\n==========\n")
}

fun Int.checkIntRange(n: Int): Int {
    return if(this in 1..n) this
    else if(this <= 0) {
        var tmp = this
        while((tmp in 1..n).not()) {
            tmp += n
        }
        tmp
    }
    else {
        var tmp = this
        while((tmp in 1..n).not()) {
            tmp -= n
        }
        tmp
    }
}

data class FireBall(
    val r: Int,
    val c: Int,
    val m: Int,
    val s: Int,
    val d: Int
)