import java.util.*

fun main() {
    val (n, s) = StringTokenizer(readLine()).run {
        nextToken().toInt() to nextToken().toInt()
    }
    val dp = IntArray(n.inc())
    val st = StringTokenizer(readLine())

    for(i in 1..n) {
        dp[i] = st.nextToken().toInt() + dp[i.dec()]
    }

    var start = 0
    var end = n
    var answer = 0

    while(start <= end) {
        val mid = (start + end).div(2)

        if(check(dp, mid, s)) {
            answer = mid
            end = mid.dec()
        } else start = mid.inc()
    }

    print(answer)
}

fun check(intArr: IntArray, num: Int, target: Int): Boolean {
    for(i in num until intArr.size) {
        if(intArr[i] - intArr[i-num] >= target) return true
    }
    return false
}