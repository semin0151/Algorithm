import java.util.*
import kotlin.math.*

fun main() {
    val num = readLine()?.toInt() ?: 0
    val arr = Array<IntArray>(num) { IntArray(num) }
    
    for(i in 0 until num) {
        val st = StringTokenizer(readLine())
        for(j in 0 until num) {
            arr[i][j] = st.nextToken().toInt()
        }
    }
    val checkArr = BooleanArray(num) { true }
    val intArr = IntArray(num)
    var answer = Int.MAX_VALUE

    fun recursion(current: Int) {
        if(current >= num/2) {
            var team1 = 0
            var team2 = 0

            for(i in 0 until arr.size) {
                for(j in 0 until arr[0].size) {
                    if(checkArr[i] && checkArr[j]) team1 += arr[i][j]
                    else if(checkArr[i].not() && checkArr[j].not()) team2 += arr[i][j]
                }
            }
            
            answer = min(answer, abs(team1 - team2))
        } else {
            for(i in 0 until num) {
                if(current == 0 || intArr[current.dec()] < i &&(checkArr[i]))  {
                    checkArr[i] = false
                    intArr[current] = i
                    recursion(current.inc())
                    checkArr[i] = true
                }
            }
        }
    }

    recursion(0)
    print(answer)
}