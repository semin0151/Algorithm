fun main() {
    val testcase = readLine()?.toInt()?:0
    var answer = ""

    for (time in 1..testcase) {
        val text = readLine()?:""
        
        answer = if(answer.isEmpty()) {
            text
        } else {
            var tmp = ""
            answer.mapIndexed { index, char -> 
                if(text.get(index).equals(char)) {
                    tmp = tmp.plus(char)
                } else {
                    tmp = tmp.plus('?')
                }
            }
            tmp
        }
    }
    print(answer)
}