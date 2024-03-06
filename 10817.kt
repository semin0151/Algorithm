import java.util.*

fun main() {
    val st = StringTokenizer(readLine())
    val arr = arrayListOf<Int>()

    for(i in 1..3) {
        arr.add(st.nextToken().toInt())
    }

    arr.sort()
    arr.mapIndexed { index, num ->
        if(index == 1) print("$num")
    }
}