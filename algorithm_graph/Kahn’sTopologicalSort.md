# Kahn’s Topological Sort
- BFS(너비 우선 탐색) 기반 위상정렬
- indegree(진입 차수) 를 이용해 순환참조(사이클) 여부를 판별
- 단방향 그래프(Directed Graph) 전용
- 사이클 판정	모든 노드를 처리 못하면 (count < n) → 사이클 존재
- 시간 복잡도	O(N + E)

```kotlin
import java.util.ArrayDeque

fun hasCycle(n: Int, edges: Array<IntArray>): Boolean {
    val graph = Array(n) { mutableListOf<Int>() }
    val indegree = IntArray(n)

    // 그래프 구성
    for ((u, v) in edges) {
        graph[u].add(v)
        indegree[v]++
    }

    // indegree 0인 노드부터 큐에 삽입
    val queue = ArrayDeque<Int>()
    for (i in 0 until n)
        if (indegree[i] == 0) queue.add(i)

    var count = 0
    while (queue.isNotEmpty()) {
        val cur = queue.removeFirst()
        count++
        for (next in graph[cur]) {
            indegree[next]--
            if (indegree[next] == 0) queue.add(next)
        }
    }

    return count < n // 처리되지 않은 노드가 있으면 사이클 존재
}
```
