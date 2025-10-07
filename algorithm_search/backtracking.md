# Backtracking
- DFS(깊이 우선 탐색) 기반의 완전 탐색 기법
- 가능한 모든 경우를 시도하고, 조건 불일치 시 되돌아감(백트래킹)

```kotlin
fun countAffordablePairs(prices: Array<Int>, budget: Int): Int {
    // Write your code here
    val CASE = 2
    var cnt = 0
    val combination = IntArray(CASE)
    
    fun backtrack(current: Int) {
        if (current == CASE) {
            var sum = combination.sumOf { prices[it] }
            if (sum <= budget) cnt++
        } else {
            for (i in 0 until prices.size) {
                if (current == 0 || combination[current.dec()] < i) {
                    combination[current] = i
                    backtrack(current.inc())
                }
            }
        }
    }
    
    backtrack(0)
    
    return cnt
}
```
