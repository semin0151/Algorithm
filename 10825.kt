import java.util.*
import kotlin.collections.emptyList

fun main() {
    val num = readLine()?.toInt() ?: 0
    val arr = mutableListOf<Student>().apply {
        repeat(num) {
            val text = readLine()?.split(" ") ?: emptyList()
            val name = text[0]
            val korean = text[1].toInt()
            val english = text[2].toInt()
            val math = text[3].toInt()
            add(Student(name, korean, english, math))
        }
    }

    arr.sortedWith { o1, o2 ->
        if (o1.korean != o2.korean) {
            o1.korean.compareTo(o2.korean).times(-1)
        } else {
            if(o1.english != o2.english) {
                o1.english.compareTo(o2.english)
            } else {
                if(o1.math != o2.math) {
                    o1.math.compareTo(o2.math).times(-1)
                } else {
                    o1.name.compareTo(o2.name)
                }
            }
        }
    }.map { it.name }.joinToString("\n").also { answer ->
        print(answer)
    }
}

data class Student(
    val name: String,
    val korean: Int,
    val english: Int,
    val math: Int
) {
   
}