import java.util.* 
import kotlin.math.*

fun main() {
    val (n, r, c) = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()
    var size = pow(2, n)

    print("${check(r, c, size).dec()}")
}

fun check(y: Int, x: Int, size: Int): Int {
    val nextSize = size.div(2)
    
    if(size == 1) return 1
    else return if(y >= nextSize && x >= nextSize) {
        nextSize.times(nextSize).times(3) + check(y - nextSize, x - nextSize, nextSize)
    } else if(y >= nextSize && x < nextSize) {
        nextSize.times(nextSize).times(2) + check(y - nextSize, x, nextSize)
    } else if(y < nextSize && x >= nextSize) {
        nextSize.times(nextSize).times(1) + check(y, x - nextSize, nextSize)
    } else {
        check(y, x, nextSize)
    }
}

fun pow(num: Int, n: Int): Int {
    var result = 1 
    var current = 0
    while(current != n) {
        result *= num
        current++
    }
    return result
}