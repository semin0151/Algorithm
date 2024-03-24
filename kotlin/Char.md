# Char
## Extension Properties
### code
Return the code of this Char.
```
val Char.code: Int
```
## Extension Functions
### digitToInt
Returns the numeric value of the decimal digit that this Char represents. Throws an exception if this Char is not a valid decimal digit.

```
fun Char.digitToInt(): Int
```
Returns the numeric value of the digit that this Char represents in the specified radix. Throws an exception if the radix is not in the range 2..36 or if this Char is not a valid digit in the specified radix.

```
fun Char.digitToInt(radix: Int): Int
```

### digitToIntOrNull
Returns the numeric value of the decimal digit that this Char represents, or null if this Char is not a valid decimal digit.

```
fun Char.digitToIntOrNull(): Int?
```
Returns the numeric value of the digit that this Char represents in the specified radix, or null if this Char is not a valid digit in the specified radix. Throws an exception if the radix is not in the range 2..36.

```
fun Char.digitToIntOrNull(radix: Int): Int?
```
## References
- [Link][def]

[def]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/