val arr = Array(100) { 0L }
fun main() {
    arr[0] = 1L
    arr[1] = 1L
    arr[2] = 1L
    arr[3] = 2L
    arr[4] = 2L
    arr[5] = 3L
    val testcase = readLine()?.toInt()?:0
    val sb = StringBuilder()

    for (time in 1..testcase) {
        val num = readLine()?.toInt()?:0
        sb.append("${getPado(num-1)}\n")
    }
    
    print(sb)
}

fun getPado(num: Int): Long {
    return if(arr[num] != 0L) {
        arr[num]
    } else {
        arr[num] = getPado(num-1) + getPado(num-5)
        arr[num]
    }
}