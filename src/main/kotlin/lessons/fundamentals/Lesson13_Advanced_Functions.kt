/**
 * LESSON 13: ADVANCED FUNCTIONS
 * ============================================================
 *
 * This lesson completes Stage 1.3 pending items:
 * - Single-expression functions
 * - Varargs
 * - Infix functions
 * - Local functions
 * - Tail recursion
 */

fun main() {
    lesson13SingleExpressionFunctions()
    lesson13VarargsAndSpread()
    lesson13InfixFunctions()
    lesson13LocalFunctions()
    lesson13TailRecursion()
    lesson13MiniExercise()
}

/* ============================================================
   1) SINGLE-EXPRESSION FUNCTIONS
   ============================================================ */
// Beginner note:
// - A single-expression function is a function written in one line using `=`.
// - Use it when the function body is very small (simple math, simple if/else, small mapping).
// - It improves readability by removing extra braces and `return`.
fun lesson13SingleExpressionFunctions() {
    println("=== Lesson 13.1) Single-expression functions ===")

    println("sum(2, 3) = ${lesson13Sum(2, 3)}")
    println("max(10, 7) = ${lesson13Max(10, 7)}")

    println()
}

// Single-expression function:
// - No braces
// - The expression result is returned automatically
fun lesson13Sum(a: Int, b: Int): Int = a + b
fun lesson13Max(a: Int, b: Int): Int = if (a >= b) a else b

/* ============================================================
   2) VARARGS + SPREAD OPERATOR (*)
   ============================================================ */
// Beginner note:
// - `vararg` means “accept any number of arguments” (0, 1, 2, 3...).
// - Inside the function, Kotlin gives you those values as an array-like collection.
// - `*` is the spread operator: it “unpacks” an array into vararg arguments.
fun lesson13VarargsAndSpread() {
    println("=== Lesson 13.2) Varargs + spread operator ===")

    println("sumAll(1,2,3) = ${lesson13SumAll(1, 2, 3)}")
    println("sumAll() = ${lesson13SumAll()}") // valid: zero args

    val arr = intArrayOf(10, 20, 30)
    println("sumAll(*arr) = ${lesson13SumAll(*arr)}") // spread operator

    println()
}

fun lesson13SumAll(vararg values: Int): Int = values.sum()

/* ============================================================
   3) INFIX FUNCTIONS
   ============================================================ */
// Beginner note:
// - Infix functions let you call a function without dots and parentheses: `a op b`.
// - They are optional sugar (nice for readability), not a new “power” of Kotlin.
// - Rule: the function must have exactly ONE parameter.
fun lesson13InfixFunctions() {
    println("=== Lesson 13.3) Infix functions ===")

    // Infix calls look like a mini DSL:
    val message = "Kotlin" lesson13Then "is fun"
    println(message)

    val p = Lesson13Point(x = 2, y = 5)
    println("point moved = ${p moveBy 3}")

    println()
}

// Infix function rules:
// - Must be a member function or extension function
// - Must have exactly ONE parameter
infix fun String.lesson13Then(other: String): String = "$this $other"

data class Lesson13Point(val x: Int, val y: Int)

// Member infix:
infix fun Lesson13Point.moveBy(delta: Int): Lesson13Point = copy(x = x + delta, y = y + delta)

/* ============================================================
   4) LOCAL FUNCTIONS
   ============================================================ */
// Beginner note:
// - A local function is a function declared inside another function.
// - Use it to keep small helper logic close to where it's used (reduces clutter).
// - It can access variables from the outer function (like a closure).
fun lesson13LocalFunctions() {
    println("=== Lesson 13.4) Local functions ===")

    fun normalizeEmailLocal(email: String?): String {
        if (email.isNullOrBlank()) return "(no email)"
        return email.trim().lowercase()
    }

    val emails = listOf(" Alice@Example.COM ", null, "  ")
    for (e in emails) {
        println("normalized = ${normalizeEmailLocal(e)}")
    }

    println()
}

/* ============================================================
   5) TAIL RECURSION
   ============================================================ */
// Beginner note:
// - Recursion is when a function calls itself.
// - Tail recursion is a special form where the *last* operation is the recursive call.
// - Kotlin can optimize tailrec functions to run like loops (less risk of stack overflow).
fun lesson13TailRecursion() {
    println("=== Lesson 13.5) Tail recursion ===")

    // Tail recursion means:
    // - the recursive call is the LAST thing the function does
    // - Kotlin can optimize it into a loop (when possible) using `tailrec`
    println("factorial(5) = ${lesson13Factorial(5)}")
    println("gcd(54, 24) = ${lesson13Gcd(54, 24)}")

    println()
}

tailrec fun lesson13Factorial(n: Int, acc: Long = 1L): Long {
    require(n >= 0) { "n must be >= 0" }
    return if (n <= 1) acc else lesson13Factorial(n - 1, acc * n)
}

tailrec fun lesson13Gcd(a: Int, b: Int): Int {
    val x = kotlin.math.abs(a)
    val y = kotlin.math.abs(b)
    return if (y == 0) x else lesson13Gcd(y, x % y)
}

/* ============================================================
   MINI EXERCISE (Try it yourself)
   ============================================================ */
fun lesson13MiniExercise() {
    println("=== Lesson 13: Mini exercise (try it) ===")
    println(
        """
        1) Write a single-expression function: isAdult(age: Int): Boolean

        2) Write a vararg function: average(vararg values: Int): Double
           - Return 0.0 when no values are passed.

        3) Create an infix extension on Int:
           - Example: 3 times "Hi" -> "HiHiHi"

        4) Write a tailrec function: sumUpTo(n: Int): Long
           - sumUpTo(3) = 1 + 2 + 3 = 6
        """.trimIndent()
    )
    println()
}

