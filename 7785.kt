fun main() {
    val num = readLine()?.toInt() ?: 0
    val set = hashSetOf<String>()

    repeat(num) {
        val splitText = (readLine() ?: "").split(" ")
        val name = splitText[0]
        val command = splitText[1]

        when (command) {
            "enter" -> {
                set.add(name)
            }
            "leave" -> {
                if (set.contains(name)) {
                    set.remove(name)
                }
            }
            else -> {}
        }
    }

    print(set.toList().sortedByDescending { it }.joinToString("\n"))
}