val arr = Array<Long>(46) { -1L }

fun main() {
    val num = readLine()?.toInt()?:0
    arr[0] = 0
    arr[1] = 1
    print("${fibo(num)}")
}

fun fibo(num: Int): Long {
    return if(num < 2) arr[num]
    else if(arr[num] == -1L) {
        arr[num] = fibo(num-1) + fibo(num-2)
        arr[num]
    } else {
        arr[num]
    }
}