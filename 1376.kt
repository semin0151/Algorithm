import java.util.*

fun main() {
    val st = StringTokenizer(readLine())
    val e = st.nextToken().toInt()
    val s = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    var ee = 0
    var ss = 0
    var mm = 0
    var answer = 0

    while(ee != e || ss != s || mm != m) {
        answer ++
        if(ee.inc() <= 15) ee++
        else ee = 1

        if(ss.inc() <= 28) ss++
        else ss = 1

        if(mm.inc() <= 19) mm++
        else mm = 1
    }

    print("$answer")
}