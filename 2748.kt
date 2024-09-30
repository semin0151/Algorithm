fun main() {
    val num = readLine()?.toInt() ?: 0
    val arr = Array<Long>(num.inc()) { -1 }
    arr[0] = 0
    arr[1] = 1
    fun fibo(n: Long): Long {
        return if(n < 2) arr[n.toInt()]
        else if(arr[n.toInt()] != -1L) arr[n.toInt()]
        else {
            arr[n.toInt()] = fibo(n-1) + fibo(n-2)
            arr[n.toInt()]
        }
    }

    print("${fibo(num.toLong())}")
}