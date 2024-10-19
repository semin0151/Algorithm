import java.util.*

fun main() {
    val (n, m, b) = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()
    val arr = Array<IntArray>(n) { IntArray(m) }
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE
    for(i in 0 until n) {
        val st = StringTokenizer(readLine())

        for(j in 0 until m) {
            arr[i][j] = st.nextToken().toInt()

            if(min > arr[i][j]) min = arr[i][j]
            if(max < arr[i][j]) max = arr[i][j]
        }
    }

    var answerTime = Int.MAX_VALUE
    var answer = Int.MAX_VALUE
    for(current in max downTo min) {
        var bag = b
        var plus = 0
        var minus = 0
        for(i in 0 until n) {
            for(j in 0 until m) {
                if(arr[i][j] > current) plus += arr[i][j] - current
                else minus += current - arr[i][j]
            }
        }
        var time = 0

        if(plus > 0) {
            bag += plus
            time += plus.times(2)
        }

        if(minus > 0) {
            if(bag >= minus) time += minus
            else time = answerTime
        }
        
        if(time < answerTime) {
            answerTime = time
            answer = current
        }
    }

    print("$answerTime $answer")
}