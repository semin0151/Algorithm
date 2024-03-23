
# Int
## Function
### plus
Add the other value to this value.

```
operator fun plus(other: Byte): Int
operator fun plus(other: Short): Int
operator fun plus(other: Int): Int
operator fun plus(other: Long): Long
operator fun plus(other: Float): Float
operator fun plus(other: Double): Double
```
### minus
Subtracts the other value from this value.

```
operator fun minus(other: Byte): Int
operator fun minus(other: Short): Int
operator fun minus(other: Int): Int
operator fun minus(other: Long): Long
operator fun minus(other: Float): Float
operator fun minus(other: Double): Double
```
### times
Multiplies the other value by this value.

```
operator fun times(other: Byte): Int
operator fun times(other: Short): Int
operator fun times(other: Int): Int
operator fun times(other: Long): Long
operator fun times(other: Float): Float
operator fun times(other: Double): Double
```
### div
Divides this value by the other value, truncating the result to an integer that is closer to zero.

```
operator fun div(other: Byte): Int
operator fun div(other: Short): Int
operator fun div(other: Int): Int
operator fun div(other: Long): Long
```
Divides this value by the other value.
```
operator fun div(other: Float): Float
operator fun div(other: Double): Double
```
### inc
Retrun this value incremented by one.

```
operator fun inc(): Int
```
### dec
Retrun this value decremented by one.

```
operator fun dec(): Int
```
## Companion Object Properties
### MAX_VALUE
A constant holding the maximum value an instance of Int can have.

```
const val MAX_VALUE: Int = 2147483647
```
### MIN_VALUE
A constant holding the minimum value an instance of Int can have.

```
const val MIN_VALUE: Int = -2147483648
```
## References
- [Link][def]

[def]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/