fun main() {
    val a = readLine()?:"0"
    val b = readLine()?:"0"
    val c = readLine()?:"0"
    val ab = "${a}${b}"
    
    print("${a.toInt() + b.toInt() - c.toInt()}\n")
    print("${ab.toInt() - c.toInt()}\n")
}