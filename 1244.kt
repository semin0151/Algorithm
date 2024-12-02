import java.util.*

fun main() {
    val size = readLine()?.toInt() ?: 0
    val arr = IntArray(size.inc())
    val st = StringTokenizer(readLine())
    repeat(size) {
        arr[it.inc()] = st.nextToken().toInt()
    }
    val tt = readLine()?.toInt() ?: 0

    repeat(tt) {
        var (a, b) = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()

        if (a == 1) {
            var tmp = b
            while(tmp <= size) {
                if(arr[tmp] == 1) arr[tmp] = 0
                else arr[tmp] = 1
                tmp += b
            }
        } else {
            var start = b.dec()
            var end = b.inc()
            if (arr[b] == 1) arr[b] = 0
            else arr[b] = 1
            while(start in 1..size && end in 1..size) {
                if(arr[start] == arr[end]) {
                    if (arr[start] == 1) arr[start] = 0
                    else arr[start] = 1

                    if (arr[end] == 1) arr[end] = 0
                    else arr[end] = 1
                    start--
                    end++
                } else break
            }
        }
    }

    print(arr.mapIndexed { index, num -> 
        if(index == 0) {
            ""
        }else if (index.rem(20) == 0) {
            "$num\n"
        } else {
            "$num "
        }
    }.joinToString(""))
}