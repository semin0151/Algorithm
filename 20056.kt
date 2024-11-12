import java.util.*

data class Fireball(
    val r: Int = -1, 
    val c: Int = -1,
    val mass: Int,
    val speed: Int,
    val direction: Int,
)

fun main() {
    val dy = listOf(-1,-1,0,1,1,1,0,-1)
    val dx = listOf(0,1,1,1,0,-1,-1,-1)
    val (n, m, k) = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()
    val arr = Array<Array<Queue<Fireball>>>(n) { Array<Queue<Fireball>>(n) { LinkedList() } }
    val fireballList = arrayListOf<Fireball>()

    repeat(m) {
        val (r, c, mass, speed, direction) = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()
        arr[r.dec()][c.dec()].offer(Fireball(mass = mass, speed = speed, direction = direction))
    }

    repeat(k) {
        // move
        for(i in 0 until n) {
            for(j in 0 until n) {
                val queue = arr[i][j]
                while(queue.isNotEmpty()) {
                    val fireball = queue.poll()
                    val newR = (i + dy[fireball.direction].times(fireball.speed).rem(n) + n).rem(n)
                    val newC = (j + dx[fireball.direction].times(fireball.speed).rem(n) + n).rem(n)

                    fireballList.add(Fireball(newR, newC, fireball.mass, fireball.speed, fireball.direction))
                }
            }
        }

        fireballList.forEach {
            arr[it.r][it.c].offer(Fireball(mass = it.mass, speed = it.speed, direction = it.direction))
        }
        fireballList.clear()

        // merge
        for(i in 0 until n) {
            for(j in 0 until n) {
                val queue = arr[i][j]
                val size = queue.size
                var newMass = 0
                var newSpeed = 0
                val isEven = queue.all { it.direction.rem(2) == 0 } || queue.all { it.direction.rem(2) == 1 }

                if(size < 2) continue

                while(queue.isNotEmpty()) {
                    val fireball = queue.poll()
                    newMass += fireball.mass
                    newSpeed += fireball.speed
                }
                newMass /= 5
                newSpeed /= size

                if(newMass > 0) {
                    if (isEven) {
                        arr[i][j].offer(Fireball(i, j, newMass, newSpeed, 0))
                        arr[i][j].offer(Fireball(i, j, newMass, newSpeed, 2))
                        arr[i][j].offer(Fireball(i, j, newMass, newSpeed, 4))
                        arr[i][j].offer(Fireball(i, j, newMass, newSpeed, 6))
                    } else {
                        arr[i][j].offer(Fireball(i, j, newMass, newSpeed, 1))
                        arr[i][j].offer(Fireball(i, j, newMass, newSpeed, 3))
                        arr[i][j].offer(Fireball(i, j, newMass, newSpeed, 5))
                        arr[i][j].offer(Fireball(i, j, newMass, newSpeed, 7))
                    }
                }
            }
        }

        fireballList.forEach {
            arr[it.r][it.c].offer(Fireball(mass = it.mass, speed = it.speed, direction = it.direction))
        }
        fireballList.clear()
    }

    val answer = arr.sumOf { arr2 -> arr2.sumOf { q -> q.map { it.mass }.sum() } }
    print("$answer")
}