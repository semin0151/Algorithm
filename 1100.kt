fun main() {
    var answer = 0
    for(i in 0..7) {
        val text = readLine()?:""
        for (j in 0..7) {
            val ch = text.get(j)
            if(ch == 'F' && (i+j)%2 ==0) answer = answer.inc()
        }
    }
    print(answer)
}