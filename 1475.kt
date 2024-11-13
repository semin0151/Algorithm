import java.util.*

fun main() {
    var num = readLine()?.toInt() ?: 0
    val arr = IntArray(10)

    while(num > 0) {
        arr[num.rem(10)]++
        num /= 10
    }

    arr[9] = if((arr[6] + arr[9]).rem(2) == 0) (arr[6] + arr[9]).div(2) else (arr[6] + arr[9]).div(2).inc()
    arr[6] = arr[9].dec()

    print("${arr.max()}")
}