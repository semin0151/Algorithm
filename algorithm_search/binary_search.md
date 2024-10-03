# Binary Search

- 이분 탐색
- 경우의 수를 2/n개로 줄여나가면서 해답을 찾는 방법
- 정렬이 되어있거나, 해답이 되는 케이스의 대소관계가 정의되어 있어야 함.

```
fun binarySearch(arr: List<Int>, target: Int): Int {
    var start = 0
    var end = arr.size
    var answer = 0

    while(start <= end) {
        val mid = (start + end).div(2)

        if(mid >= target) {
            start = mid.inc()
            answer = mid
        } else {
            end = mid.dec()
        }
    }

    return mid
}
```