# DFS

- 깊이 우선 탐색
- stack으로 주로 구현(재귀)

```
val arr: Array<IntArray>
val check: Array<BooleanArray>
val dy = listOf(1,-1,0,0)
val dx = listOf(0,0,-1,1)

fun dfs(currentY: Int, currentX: Int) {
    for(i in 0 until 4) {
        if(nextY in 0 until arr.size && 
            nextX in 0 until arr[0].size && 
            check[nextY][nextX]) {
                check[nextY][nextX] = false
                dfs(nextY, nextX)
            }
    }
}
```