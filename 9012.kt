import java.util.*

fun main() {
    val testcase = readLine()?.toInt()?:0
    val sb = StringBuilder()
    for(time in 1..testcase) {
        val text = readLine()?:""
        if(check(text)) sb.append("YES\n")
        else sb.append("NO\n")
    }
    print(sb)
}

fun check(text: String): Boolean {
    val stack = Stack<Boolean>()

    text.map { char ->
        if(char == '(') stack.add(true)
        else {
            if(stack.isEmpty()) return false
            else stack.pop()
        }
    }

    return if(stack.isEmpty()) true
    else false
} 