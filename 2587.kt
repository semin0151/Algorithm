fun main() {
    arrayListOf<Int>().apply {
        for(index in 1..5) {
            add(readLine()?.toInt()?:0)
        }
        sort()
    }.also {
        print("${it.sum()/it.size}\n${it.get(it.size/2)}")
    }
}