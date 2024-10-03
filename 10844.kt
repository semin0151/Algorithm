fun main() {
    val n = readLine()?.toInt() ?: 0
 
    val arr = Array<LongArray>(n.inc()) { LongArray(10) }

    for(i in 1..9) {
        arr[1][i] = 1
    }

    for(i in 2..n) {
        for(j in 0..9) {
            when(j) {
                0 -> arr[i][j] = arr[i-1][1].rem(1_000_000_000)
                9 -> arr[i][j] = arr[i-1][8].rem(1_000_000_000)
                else -> arr[i][j] = (arr[i-1][j-1] + arr[i-1][j+1]).rem(1_000_000_000)
            }
        }
    }

    print("${arr[n].sum().rem(1_000_000_000)}")
}