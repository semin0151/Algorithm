# BFS

- 너비 우선 탐색
- queue로 주로 구현

```kotlin
val arr: Array<IntArray>
val check: Array<BooleanArray>
val dy = listOf(1,-1,0,0)
val dx = listOf(0,0,-1,1)

fun bfs(currentY: Int, currentX: Int) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.offer(currentY to currentX)
    check[currentY][currentX] = false

    while(queue.isNotEmpty()) {
        for(i in 0 until 4) {
            val nextY = currentY + dy[i]
            val nextX = currentX + dx[i]
            
            if(nextY in 0 until arr.size && 
            nextX in 0 until arr[0].size && 
            check[nextY][nextX]) {
                check[nextY][nextX] = false
                queue.offer(nextY to nextX)
            }
        }
    }
}
```
