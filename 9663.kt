import java.util.*
import kotlin.math.*

fun main() {
    val n = readLine()?.toInt() ?: 0
    var answer = 0
    val checkArr = BooleanArray(n) { true }
    val crossPlus = BooleanArray(n * 2) { true }
    val crossMinus = BooleanArray(n * 2) { true }

    fun recursion(current: Int) {
        if(current >= n) {
            answer++
        } else {
            for(i in 0 until n) {
                if(checkArr[i] && crossPlus[current + i] && crossMinus[n + current - i]) {
                    checkArr[i] = false
                    crossPlus[current + i] = false
                    crossMinus[n + current - i] = false
                    recursion(current.inc())
                    checkArr[i] = true
                    crossPlus[current + i] = true
                    crossMinus[n + current - i] = true
                }
            }
        }
    }

    recursion(0)
    print("$answer")
}