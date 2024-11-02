import java.util.*

fun main() {
    val k = readLine()?.toInt()?:0
    var maxWidth = 0
    var maxHeight = 0
    var maxWidthIndex = 0
    var maxHeightIndex = 0
    val arr = mutableListOf<Pair<Int, Int>>()
    var answer: Int

    for(i in 0 until 6) {
        val (a, b) = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()
        arr.add(a to b)
        if(a <= 2) {
            if(maxWidth < b) {
                maxWidth = b
                maxWidthIndex = i
            }
        } else {
            if(maxHeight < b) {
                maxHeight = b
                maxHeightIndex = i
            }
        }
    }

    if ((maxWidthIndex == 0 && maxHeightIndex == 5)) {
        val minHeight = arr[maxWidthIndex.inc().getIndex()].second
        val minWidth = arr[maxHeightIndex.dec().getIndex()].second
        answer = (maxWidth * maxHeight) - ((maxWidth - minWidth) * (maxHeight - minHeight))
    } else if((maxWidthIndex == 5 && maxHeightIndex == 0)) {
        val minHeight = arr[maxWidthIndex.dec().getIndex()].second
        val minWidth = arr[maxHeightIndex.inc().getIndex()].second
        answer = (maxWidth * maxHeight) - ((maxWidth - minWidth) * (maxHeight - minHeight))
    } else if (maxWidthIndex < maxHeightIndex) {
        val minHeight = arr[maxWidthIndex.dec().getIndex()].second
        val minWidth = arr[maxHeightIndex.inc().getIndex()].second
        answer = (maxWidth * maxHeight) - ((maxWidth - minWidth) * (maxHeight - minHeight))
    } else {
        val minWidth = arr[maxHeightIndex.dec().getIndex()].second
        val minHeight = arr[maxWidthIndex.inc().getIndex()].second
        answer = (maxWidth * maxHeight) - ((maxWidth - minWidth) * (maxHeight - minHeight))
    }

    print("${answer.times(k)}")
}

fun Int.getIndex(): Int {
    return if(this in 0 until 6) this 
    else if(this < 0) this.plus(6)
    else this.minus(6)
}