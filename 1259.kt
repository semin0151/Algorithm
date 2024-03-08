fun main() {
    val sb = StringBuilder()        
    while(true) {
        val num = readLine()?:"0"
        
        if(num.toInt() == 0) break  

        if(check(num)) sb.append("yes\n")
        else sb.append("no\n")
    }

    print(sb)
}

fun check(num: String): Boolean {
    val length = num.length
    for (index in 0..length/2-1) {
        if(num[index] != num[length-1-index]) {
            return false
        }
    }
    return true
}