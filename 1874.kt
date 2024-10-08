import java.util.*

fun main() {
    val n = readLine()?.toInt() ?: 0
    val stack = Stack<Int>()
    val sb = StringBuilder()
    var current = 1
    var flag = false

    sb.append("+\n")
    stack.add(current++)

    loop@for(i in 0 until n) {
        val num = readLine()?.toInt() ?: 0

        if(stack.isEmpty()) {
            if(num < current) {
                flag = true
                break@loop
            } else {
                sb.append("+\n")
                stack.add(current++)
            }
        } 

        if(stack.peek() < num) {
            while(stack.isNotEmpty() && stack.peek() != num) {
                if(stack.peek() > num) {
                    flag = true
                    break@loop
                }
                sb.append("+\n")
                stack.add(current++)
            }
            sb.append("-\n")
            stack.pop()
        } else if(stack.peek() == num) {
            sb.append("-\n")
            stack.pop()
        } else {
            while(stack.isNotEmpty() && stack.peek() != num) {
                sb.append("-\n")
                stack.pop()
            }
        }
    }

    if(flag) print("NO") else print(sb.toString())
}