fun main() {
    val time = readLine()?.toInt() ?: 0
    val arr = arrayListOf<Int>()
    val sb = StringBuilder()

    for (index in 1..time) {
        arr.add(readLine()?.toInt() ?: 0)
    }

    arr.sort()
    arr.map { num ->
        sb.append("$num\n")
    }
    print(sb)
}