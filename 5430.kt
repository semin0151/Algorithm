import java.util.*

fun main() {
    val testcase = readLine()?.toInt()?:0
    val sb = StringBuilder()

    for(tt in 1..testcase) {
        val text = readLine()?.replace("RR", "") ?: ""
        val size = readLine()?.toInt() ?: 0
        val arr = readLine()?.replace("[", "")?.replace("]", "")?.takeIf { it.isNotEmpty() }?.split(",")?.map { it.toInt() } ?: emptyList()
        var startIndex = 0
        var endIndex = size
        var reversed = false

        for(ch in text) {
            when(ch) {
                'R' -> {
                    reversed = reversed.not()
                }
                else -> {
                    if(reversed) endIndex--
                    else startIndex++
                }
            }

            if(startIndex > endIndex) {
                break
            }
        }

        if(startIndex > endIndex) sb.append("error\n")
        else if(reversed) sb.append("${arr.subList(startIndex, endIndex).reversed().joinToString(",", "[", "]")}\n")
        else sb.append("${arr.subList(startIndex, endIndex).joinToString(",", "[", "]")}\n")
    }

    print(sb.toString())
}

/**
 * 4
 * RDD
 * 4
 * [1,2,3,4]
 * DD
 * 1
 * [42]
 * RRD
 * 6
 * [1,1,2,3,5,8]
 * D
 * 0
 * []
 */