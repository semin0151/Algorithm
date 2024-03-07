import java.util.*

fun main() {
    val st = StringTokenizer(readLine())
    val arr = arrayListOf<Int>()

    for(index in 1..8) {
        arr.add(st.nextToken().toInt())
    }

    arr.mapIndexed { index, num ->
        if(index != arr.size - 1) {
            num - arr[index+1]
        } else {
            0
        }
    }.filter { num ->
        num != 0
    }.run {
        if(max() == 1 && min() == 1) {
            print("descending")
        } else if (max() == -1 && min() == -1) {
            print("ascending")
        } else {
            print("mixed")
        }
    }
}