# Two Pointer
- 정렬된 배열에서 두 개의 포인터를 움직이며 조건을 만족하는 쌍이나 구간을 찾는 알고리즘
- 완전 탐색보다 효율적(O(N))

```kotlin
fun countAffordablePairs(prices: IntArray, budget: Int): Int {
    prices.sort()
    var left = 0
    var right = prices.lastIndex
    var count = 0

    while (left < right) {
        val sum = prices[left] + prices[right]
        if (sum <= budget) {
            count += (right - left)
            left++
        } else {
            right--
        }
    }

    return count
}
```
