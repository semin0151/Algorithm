fun main() {
    val num = readLine()?:""
    val sb = StringBuilder()

    if(num=="0") {
        print("0")
        return
    }

    num.mapIndexed { index, char -> 
        sb.append(when(char) {
            '1' -> {
                if(index == 0) {
                    "1"
                } else {
                    "001"
                }   
            }
            '2' -> {
                if(index == 0) {
                    "10"
                } else {
                    "010"
                }   
            }
            '3' -> {
                if(index == 0) {
                    "11"
                } else {
                    "011"
                }
            }
            '4' -> "100"
            '5' -> "101"
            '6' -> "110"
            '7' -> "111"
            else -> "000"
        })
    }
    print(sb)
}