fun main() {
    val n = readLine()?.toInt() ?: 0
    val arr = Array<LongArray>(n.inc()) { LongArray(10) }

    for(i in 1..n) {
        for(j in 0..9) {
            if(j == 0) arr[i][j] = 1
            else arr[i][j] = (arr[i.dec()][j] + arr[i][j.dec()]).rem(10007)
        }
    }

    print("${arr[n].sum().rem(10007)}")
}