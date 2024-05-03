
# String
## Properties
### length
Returns the length of this character sequence.
```
val length: Int
```
## Function
### compareTo
Compares this object with the specified object for order. Returns zero if this object is equal to the specified other object, a negative number if it's less than other, or a positive number if it's greater than other.

```
fun compareTo(other: String): Int
```
### equals
Indicates whether some other object is "equal to" this one. Implementations must fulfil the following requirements:
```
fun equals(other: Any?): Boolean
```
### get
Returns the character of this string at specified index.
```
fun get(index: Int): Char
```
## Extension Properties
### indices
Returns the range of valid character indices for this char sequence.
```
val CharSequence.indices: IntRange
```
### lastIndex
Returns the index of the last character in the char sequence or -1 if it is empty.
```
val CharSequence.lastIndex: Int
```
## Extension Functions
### all
Returns `true` if all characters match the given predicate.
```
fun CharSequence.all(predicate: (Char) -> Boolean): Boolean
```
### any
Returns `true` if at least one character match the given predicate.
```
fun CharSequence.any(predicate: (Char) -> Boolean): Boolean
```
### contains
Returns `true` if this char sequence contains the specified other sequence of characters as a substring.
```
operator fun CharSequence.contains(
    other: CharSequence,
    ignoreCase: Boolean = false
): Boolean
```
Returns true if this char sequence contains the specified character char.
```
operator fun CharSequence.contains(
    char: Char,
    ignoreCase: Boolean = false
): Boolean
```
Returns true if this char sequence contains at least one match of the specified regular expression regex.
```
operator fun CharSequence.contains(regex: Regex): Boolean
```
### filter
Returns a string containing only those characters from the original string that match the given predicate.
```
fun String.filter(predicate: (Char) -> Boolean): String
```
### filterIndexed
Returns a string containing only those characters from the original string that match the given predicate.
```
fun String.filterIndexed(predicate: (index: Int, Char) -> Boolean): String
```
### find
Returns the first character matching the given predicate, or `null` if no such character was found.
```
fun CharSequence.find(predicate: (Char) -> Boolean): Char?
```
### findLast
Returns the last character matching the given predicate, or `null` if no such character was found.
```
fun CharSequence.findLast(
    predicate: (Char) -> Boolean
): Char?
```
### first
Returns the first character.
```
fun CharSequence.first(): Char
```
Returns the first character matching the given predicate.
```
fun CharSequence.first(predicate: (Char) -> Boolean): Char
```
### forEach
Performs the given action on each character.
```
fun CharSequence.forEach(action: (Char) -> Unit)
```
### forEachIndexed
Performs the given action on each character, providing sequential index with the character.
```
fun CharSequence.forEachIndexed(
    action: (index: Int, Char) -> Unit)
```
### getOrElse
Returns a character at the given index or the result of calling the defaultValue function if the index is out of bounds of this char sequence.
```
fun CharSequence.getOrElse(
    index: Int,
    defaultValue: (Int) -> Char
): Char
```
### getOrNull
Returns a character at the given index or null if the index is out of bounds of this char sequence.
```
fun CharSequence.getOrNull(index: Int): Char?
```
### indexOf
Returns the index within this string of the first occurrence of the specified character, starting from the specified startIndex.
```
fun CharSequence.indexOf(
    char: Char,
    startIndex: Int = 0,
    ignoreCase: Boolean = false
): Int
```
Returns the index within this char sequence of the first occurrence of the specified string, starting from the specified startIndex.
```
fun CharSequence.indexOf(
    string: String,
    startIndex: Int = 0,
    ignoreCase: Boolean = false
): Int
```
### indexOfFirst
Returns index of the first character matching the given predicate, or -1 if the char sequence does not contain such character.
```
fun CharSequence.indexOfFirst(
    predicate: (Char) -> Boolean
): Int
```
### indexOfLast
Returns index of the last character matching the given predicate, or -1 if the char sequence does not contain such character.
```
fun CharSequence.indexOfLast(
    predicate: (Char) -> Boolean
): Int
```
### isEmpty
Returns true if this char sequence is empty (contains no characters).
```
fun CharSequence.isEmpty(): Boolean
```
### isNotEmpty
Returns true if this char sequence is not empty.
```
fun CharSequence.isNotEmpty(): Boolean
```
### last
Returns the last character.
```
fun CharSequence.last(): Char
```
Returns the last character matching the given predicate.
```
fun CharSequence.last(predicate: (Char) -> Boolean): Char
```
### lowercase
Returns a copy of this string converted to lower case using the rules of the specified locale.
```
fun String.lowercase(locale: Locale): String
```
### map
Returns a list containing the results of applying the given transform function to each character in the original char sequence.
```
fun <R> CharSequence.map(transform: (Char) -> R): List<R>
```
### mapIndexed
Returns a list containing the results of applying the given transform function to each character and its index in the original char sequence.
```
fun <R> CharSequence.mapIndexed(
    transform: (index: Int, Char) -> R
): List<R>
```
### random
Returns a random character from this char sequence.
```
fun CharSequence.random(): Char
```
Returns a random character from this char sequence using the specified source of randomness.
```
fun CharSequence.random(random: Random): Char
```
### replace
Returns a new string obtained by replacing each substring of this char sequence that matches the given regular expression with the given replacement.
```
fun CharSequence.replace(
    regex: Regex,
    replacement: String
): String
```
Returns a new string obtained by replacing each substring of this char sequence that matches the given regular expression with the result of the given function transform that takes MatchResult and returns a string to be used as a replacement for that match.
```
fun CharSequence.replace(
    regex: Regex,
    transform: (MatchResult) -> CharSequence
): String
```
### reversed
Returns a string with characters in reversed order.
```
fun String.reversed(): String
```
### split
Splits this char sequence to a list of strings around occurrences of the specified delimiters.
```
fun CharSequence.split(
    vararg delimiters: String,
    ignoreCase: Boolean = false,
    limit: Int = 0
): List<String>
fun CharSequence.split(
    vararg delimiters: Char,
    ignoreCase: Boolean = false,
    limit: Int = 0
): List<String>
```
Splits this char sequence to a list of strings around matches of the given regular expression.
```
fun CharSequence.split(
    regex: Regex,
    limit: Int = 0
): List<String>
```
Splits this char sequence around matches of the given regular expression.
```
fun CharSequence.split(
    regex: Pattern,
    limit: Int = 0
): List<String>
```
### substring
Returns a substring specified by the given range of indices.
```
fun String.substring(range: IntRange): String
```
### toBigDecimal
Parses the string as a java.math.BigDecimal number and returns the result.
```
fun String.toBigDecimal(): BigDecimal
fun String.toBigDecimal(mathContext: MathContext): BigDecimal
```
### toBigInteger
Parses the string as a java.math.BigInteger number and returns the result.
```
fun String.toBigInteger(): BigInteger
fun String.toBigInteger(radix: Int): BigInteger
```
### toList
Returns a List containing all characters.
```
fun CharSequence.toList(): List<Char>
```
### uppercase
Returns a copy of this string converted to upper case using the rules of the specified locale.
```
fun String.uppercase(locale: Locale): String
```
## References
- [Link][def]

[def]: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/