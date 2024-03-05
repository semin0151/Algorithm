import java.util.*

fun main() {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt() - 1
    val sb = StringBuilder()
    var arr = List<Int>(n) { it + 1 }
    val answer = arrayListOf<Int>()
    var index = 0
    while(arr.size != 0) {
        if(index.plus(k) < arr.size) {
            index += k
        } else {
            index = index.plus(k) % arr.size
        }
        answer.add(arr[index])
        arr = arr.filter { num ->
            num != arr[index]
        }
    }

    answer.mapIndexed { answerIndex, num ->
        if(answerIndex == 0) {
            sb.append("<")
        } 

        sb.append("$num")

        if(answerIndex == answer.size - 1) {
            sb.append(">")
        } else {
            sb.append(", ")
        }
    }
    print(sb)
}