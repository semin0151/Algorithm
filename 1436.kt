fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val num = br.readLine().toInt()

    var n = 665
    var cnt = 0
    while (cnt != num) {
        var tmp = ++n
        var sixCnt = 0
        while(tmp > 0) {
            if(tmp.rem(10) == 6) sixCnt++
            else sixCnt = 0

            tmp = tmp.div(10)

            if(sixCnt >= 3) break
        }
        if(sixCnt >= 3) cnt++
    }
    bw.write("$n")
    bw.close()
}

/**
 * 1 : 666
 * 2 : 1666
 * 3 : 2666
 * 4 : 3666
 * 5 : 4666
 * 6 : 5666
 * 7 : 6666
 * 8 : 7666
 * 9 : 8666
 * 10 : 9666
 * 11 : 10666
 * 12 : 11666
 * 13 : 12666
 * 14 : 13666
 * 15 : 14666
 * 16 : 15666
 * 17 : 16660
 * 18 : 16661
 * ...
 * 26 : 16669
 * 27 : 20666
 * ...
 * 60 : 59666
 * 61 : 66600
 * 62 : 66601
 * ...
 * 160 : 66699
 * 161 : 70666
 * 162 : 71666
 * ...
 * 190 : 96669
 * 191 : 100666
 */