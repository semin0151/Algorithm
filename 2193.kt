fun main() {
    val n = readLine()?.toInt() ?: 0
    val arr = LongArray(n.inc())

    for(i in 1..n) {
        if(i <= 2) arr[i] = 1L
        else arr[i] = arr[i-1] + arr[i-2]
    }

    print("${arr[n]}")
}