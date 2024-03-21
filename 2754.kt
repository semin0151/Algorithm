fun main() {
    val grade = readLine()?:""
    var point: Double = 0.0
    try {
        val first = grade.get(0)
        val second = grade.get(1)
        point = when(first) {
            'A' -> 4.0
            'B' -> 3.0
            'C' -> 2.0
            'D' -> 1.0
            else -> 0.0
        }

        point += when(second) {
            '+' -> 0.3
            '-' -> -0.3
            else -> 0.0
        }
    } catch (e: Exception) {
        point = 0.0
    }

    print("$point")
}