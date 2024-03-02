import java.util.*

var first = ""
var second = ""

fun main() {
    //val st = StringTokenizer(readLine())
    val st = StringTokenizer("999 999")

    first = st.nextToken().reversed()
    second = st.nextToken().reversed()

    addZero()

    print("${addNumber()}")
}

fun addZero() {
    if(first.length > second.length) {
        for(count in 1.. first.length - second.length) {
            second += "0"
        }
    } else {
        for(count in 1.. second.length - first.length) {
            first += "0"
        }
    }
}

fun addNumber(): String {
    var sb = StringBuilder()
    var upCount = 0

    for (index in 0 until first.length) {
        print("")
        val sum = Character.getNumericValue(first.get(index)) + Character.getNumericValue(second.get(index)) + upCount
        upCount = sum/10
        sb.append("${sum%10}")
    }
    if(upCount > 0)sb.append("$upCount")

    return sb.toString().reversed()
}

//18446744073709551615
//18446744073709551615