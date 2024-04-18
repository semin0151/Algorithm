import java.util.*
import kotlin.math.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val (n, m) = StringTokenizer(br.readLine()).run {
        nextToken().toInt() to nextToken().toInt()
    }
    
    val arr = (1..n).toList().map {
        br.readLine().map {
            it
        }
    }
    var result = 64

    for(y in 0..n.minus(8)) {
        for(x in 0..m.minus(8)) {
            var cntB = 64
            var cntW = 64
            for(i in 0 until 8) {
                for(j in 0 until 8) {
                    if(arr[y.plus(i)][x.plus(j)] == 'B') {
                        if((y.plus(i) + x.plus(j)) % 2 == 1) cntB--
                        else cntW--
                    } else {
                        if((y.plus(i) + x.plus(j)) % 2 == 0) cntB--
                        else cntW--
                    }
                }
            }
            result = min(result, min(cntB, cntW))
        }
    }

    bw.write("$result")
    bw.close()
}