import kotlin.math.*

fun main() {
    val num = readLine()?.toInt() ?:0
    val arr = IntArray(num.inc()) { Int.MAX_VALUE }
    arr[1] = 0

    for(index in 1..num) {
        if(index + 1 <= num) arr[index+1] = min(arr[index+1], arr[index].inc())
        if(index * 2 <= num) arr[index*2] = min(arr[index*2], arr[index].inc())
        if(index * 3 <= num) arr[index*3] = min(arr[index*3], arr[index].inc())
    }

    print("${arr[num]}")
}