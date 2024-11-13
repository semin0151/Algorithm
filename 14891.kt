import java.util.*
import kotlin.arrayOf
import kotlin.math.*

fun main() {
    val wheelList = Array<Deque<Int>>(4) { LinkedList() }

    repeat(4) { idx ->
        val arr = readLine()?.toCharArray()?.map { it.digitToInt() } ?: emptyList()
        arr.forEach {
            wheelList[idx].offer(it)
        }
    }

    val k = readLine()?.toInt() ?: 0

    repeat(k) {
        var (a, b) = readLine()?.split(" ") ?. map { it.toInt() } ?: emptyList()
        val rotateList = IntArray(4)
        a--
        rotateList[a] = b

        var direction: Int

        direction = b
        for(i in a.dec() downTo 0) {
            if(wheelList[i].right != wheelList[i.inc()].left) {
                direction *= -1
                rotateList[i] = direction
            } else {
                direction = 0
            }
        }

        direction = b
        for(i in a.inc() until 4) {
            if(wheelList[i].left != wheelList[i.dec()].right) {
                direction *= -1
                rotateList[i] = direction
            } else {
                direction = 0
            }
        }

        rotateList.forEachIndexed { index, rotate ->
            wheelList[index].rotate(rotate)
        }
    }

    val answer = wheelList.mapIndexed { index, wheel ->  
        wheel.top.times(2.pow(index))
    }.sum()

    print("$answer")
}

fun Int.pow(n: Int): Int {
    var tmp = 1
    repeat(n) {
        tmp *= this
    }
    return tmp
}

val Deque<Int>.top: Int get() = (this as LinkedList).get(0)
val Deque<Int>.right: Int get() = (this as LinkedList).get(2)
val Deque<Int>.left: Int get() = (this as LinkedList).get(6)

fun Deque<Int>.rotate(d: Int) {
    if(d == 1) {
        val tmp = this.pollLast()
        this.offerFirst(tmp)
    } else if(d == -1) {
        val tmp = this.pollFirst()
        this.offerLast(tmp)
    }
}