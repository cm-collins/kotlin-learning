/**
 * LESSON 7: ARRAYS ============================================================
 *
 * Arrays store a fixed-size collection of items. In Kotlin there are 2 big categories:
 *
 * 1) Generic arrays: Array<T>
 * ```
 *    - Can hold objects like String, Int? (nullable), custom classes, etc.
 *    - Example: arrayOf("a", "b")
 * ```
 * 2) Primitive arrays: IntArray, DoubleArray, BooleanArray, ...
 * ```
 *    - Store primitives efficiently (no boxing)
 *    - Example: intArrayOf(1, 2, 3)
 * ```
 * Key concepts:
 * - Arrays are fixed-size: you can't add/remove elements (use List/MutableList for that)
 * - Indexing is 0-based: first element is index 0
 * - Common properties: size, indices
 * - Common operations: get/set via [index], for loops, forEach, joinToString
 *
 * Arrays vs Lists (quick rule):
 * - Use Array when you need a fixed-size structure or interop with Java APIs
 * - Use List/MutableList for most everyday collections work in Kotlin
 */
fun main() {
    arraysExample()
}

/* ============================================================
ARRAYS BASICS
============================================================ */
fun arraysExample() {
    // 1) Create an Array<String>
    val words: Array<String> = arrayOf("hello", "collins", "good", "morning")

    println("Words array: ${words.joinToString(prefix = "[", postfix = "]")}")
    println("Size: ${words.size}")

    // 2) Access elements (0-based indexing)
    println("First element: ${words[0]}")
    println("Last element: ${words[words.size - 1]}")

    // 3) Update elements (arrays are mutable in-place)
    words[1] = "Munene"
    println("After update: ${words.joinToString(prefix = "[", postfix = "]")}")

    // 4) Safe access (avoid IndexOutOfBoundsException)
    val maybeItem = words.getOrNull(10)
    println("getOrNull(10): $maybeItem")

    // 5) Iteration
    println("\nIterate with indices:")
    for (i in words.indices) {
        println("Index $i -> ${words[i]}")
    }

    println("\nIterate with forEachIndexed:")
    words.forEachIndexed { index, value -> println("Index $index -> $value") }

    // 6) Arrays can be created with a size and initializer
    val squares = Array(5) { i -> i * i }
    println("\nSquares: ${squares.joinToString(prefix = "[", postfix = "]")}")

    // 7) Primitive arrays (more efficient for numeric data)
    val numbers: IntArray = intArrayOf(10, 20, 30)
    println("\nIntArray: ${numbers.joinToString(prefix = "[", postfix = "]")}")
    numbers[0] += 5
    println("Updated IntArray: ${numbers.joinToString(prefix = "[", postfix = "]")}")

    // 8) Convert Array <-> List
    val wordsList = words.toList()
    println("\nAs List: $wordsList")

    val backToArray = wordsList.toTypedArray()
    println("Back to Array: ${backToArray.joinToString(prefix = "[", postfix = "]")}")

    // 9) Nullable arrays
    val nullable: Array<String?> = arrayOf("A", null, "C")
    println("\nNullable array: ${nullable.joinToString(prefix = "[", postfix = "]")}")

    // 10) Copying arrays
    val copy = words.copyOf()
    copy[0] = "HI"
    println("\nOriginal: ${words.joinToString(prefix = "[", postfix = "]")}")
    println("Copy:     ${copy.joinToString(prefix = "[", postfix = "]")}")
}
