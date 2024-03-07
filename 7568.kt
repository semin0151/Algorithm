import java.util.*

fun main() {
    val n = readLine()?.toInt()?:0
    val sb = StringBuilder()
    val arr = arrayListOf<Pair<Int, Int>>()
    val answer = arrayListOf<Int>()

    for(time in 1..n) {
        val st = StringTokenizer(readLine())
        val weight = st.nextToken().toInt()
        val height = st.nextToken().toInt()

        arr.add(weight to height)
    }

    arr.mapIndexed { index, pair ->
        var cnt = 1
        arr.mapIndexed { index2, pair2 ->
            if(index != index2) {
                if(pair.first < pair2.first && pair.second < pair2.second) {
                    cnt++
                }
            }
        }
        answer.add(cnt)
    }

    answer.mapIndexed { index, num ->
        if(index != answer.size-1) {
            sb.append("$num ")
        } else {
            sb.append("$num")
        }
    }
    print(sb)
}