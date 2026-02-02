/**
 * LESSON 20: LAMBDA FUNCTIONS (BEGINNER FRIENDLY)
 * ============================================================
 *
 * Goal:
 * - Understand what lambdas are, how to write them, and how Kotlin uses them everywhere.
 *
 * You will learn:
 * - Lambda expressions: { params -> body }
 * - The `it` shortcut
 * - Function types: (Input) -> Output
 * - Higher-order functions (functions that take lambdas)
 * - Trailing lambda syntax
 * - Closures (lambdas that “capture” variables)
 * - Function references (::someFunction)
 *
 * Beginner mindset:
 * - A lambda is basically a “function value” you can store in a variable and pass around.
 */

fun main() {
    lesson20LambdaBasics()
    lesson20ItShortcut()
    lesson20FunctionTypes()
    lesson20HigherOrderFunctions()
    lesson20TrailingLambdaSyntax()
    lesson20Closures()
    lesson20FunctionReferences()
    lesson20CommonStdLibUses()
    lesson20MiniExercise()
}

/* ============================================================
   1) LAMBDA BASICS
   ============================================================ */
// Beginner note:
// - Lambda syntax: { parameters -> body }
// - If there are no parameters, you can write: { body }
// - The last expression in the body becomes the return value.
fun lesson20LambdaBasics() {
    println("=== Lesson 20.1) Lambda basics ===")

    val sayHello = { println("Hello from a lambda!") }
    sayHello()

    val add = { a: Int, b: Int -> a + b }
    println("add(2, 3) = ${add(2, 3)}")

    val toUpper = { s: String -> s.uppercase() }
    println("toUpper('kotlin') = ${toUpper("kotlin")}")

    println()
}

/* ============================================================
   2) THE `it` SHORTCUT
   ============================================================ */
// Beginner note:
// - If a lambda has exactly ONE parameter, you can omit the name and use `it`.
fun lesson20ItShortcut() {
    println("=== Lesson 20.2) it shortcut ===")

    val numbers = listOf(1, 2, 3, 4, 5)

    val doubled = numbers.map { it * 2 }
    println("doubled = $doubled")

    val evens = numbers.filter { it % 2 == 0 }
    println("evens = $evens")

    println()
}

/* ============================================================
   3) FUNCTION TYPES
   ============================================================ */
// Beginner note:
// - A function type describes “a function that takes X and returns Y”.
// - Example: (Int) -> String means: takes an Int, returns a String.
fun lesson20FunctionTypes() {
    println("=== Lesson 20.3) Function types ===")

    val intToString: (Int) -> String = { n -> "Number=$n" }
    println(intToString(7))

    val isAdult: (Int) -> Boolean = { age -> age >= 18 }
    println("isAdult(16) = ${isAdult(16)}")
    println("isAdult(24) = ${isAdult(24)}")

    println()
}

/* ============================================================
   4) HIGHER-ORDER FUNCTIONS
   ============================================================ */
// Beginner note:
// - A higher-order function takes a function (lambda) as a parameter, or returns a function.
// - This is what powers Kotlin collection APIs (map/filter) and scope functions (let/run/apply).
fun lesson20HigherOrderFunctions() {
    println("=== Lesson 20.4) Higher-order functions ===")

    val result = lesson20Operate(10, 5) { a, b -> a - b }
    println("operate(10,5, minus) = $result")

    val transformed = lesson20Transform("kotlin") { it.replaceFirstChar { ch -> ch.uppercase() } }
    println("transformed = $transformed")

    println()
}

fun lesson20Operate(a: Int, b: Int, op: (Int, Int) -> Int): Int = op(a, b)

fun lesson20Transform(input: String, mapper: (String) -> String): String = mapper(input)

/* ============================================================
   5) TRAILING LAMBDA SYNTAX
   ============================================================ */
// Beginner note:
// - If the LAST parameter is a lambda, you can move it outside the parentheses.
// - This makes code more readable (especially with multiline lambdas).
fun lesson20TrailingLambdaSyntax() {
    println("=== Lesson 20.5) Trailing lambda syntax ===")

    val a = lesson20Operate(8, 2, op = { x, y -> x * y }) // lambda inside parentheses
    val b = lesson20Operate(8, 2) { x, y -> x * y }      // trailing lambda

    println("a = $a, b = $b")
    println()
}

/* ============================================================
   6) CLOSURES (CAPTURING VARIABLES)
   ============================================================ */
// Beginner note:
// - A lambda can “capture” variables from the outer scope.
// - This is powerful but be careful: captured mutable state can make code harder to reason about.
fun lesson20Closures() {
    println("=== Lesson 20.6) Closures ===")

    var counter = 0
    val increment = { counter++ } // captures counter

    increment()
    increment()
    println("counter = $counter")

    println()
}

/* ============================================================
   7) FUNCTION REFERENCES (::)
   ============================================================ */
// Beginner note:
// - `::functionName` is a reference to an existing function.
// - It’s handy when you already have a function that matches the needed signature.
fun lesson20FunctionReferences() {
    println("=== Lesson 20.7) Function references ===")

    val names = listOf("munene", "amina", "brian")
    val upper = names.map(::lesson20ToUpperCase)
    println("upper = $upper")

    println()
}

fun lesson20ToUpperCase(s: String): String = s.uppercase()

/* ============================================================
   8) COMMON STANDARD LIBRARY USES
   ============================================================ */
// Beginner note:
// - You will see lambdas most often with:
//   - Collections: map/filter/forEach
//   - Scope functions: let/apply/run/also/with
//   - Sorting: sortedBy { ... }
fun lesson20CommonStdLibUses() {
    println("=== Lesson 20.8) Common stdlib uses ===")

    val users = listOf(
        Lesson20User("Caro", 24),
        Lesson20User("Brian", 16),
        Lesson20User("Amina", 19),
    )

    val adultsSortedByName = users
        .filter { it.age >= 18 }
        .sortedBy { it.name }
        .map { it.name }

    println("adultsSortedByName = $adultsSortedByName")

    val maybeEmail: String? = "munene@example.com"
    val domain = maybeEmail?.let { it.substringAfter("@") } ?: "(no domain)"
    println("domain = $domain")

    println()
}

data class Lesson20User(val name: String, val age: Int)

/* ============================================================
   MINI EXERCISE (Try it yourself)
   ============================================================ */
fun lesson20MiniExercise() {
    println("=== Lesson 20: Mini exercise (try it) ===")
    println(
        """
        1) Create a lambda `square` that takes Int and returns Int.
           - Print square(5).

        2) Write a higher-order function `repeatAction(times: Int, action: () -> Unit)`
           - Call action() exactly `times` times.

        3) Given a list of numbers, use:
           - filter { ... } to keep only odd numbers
           - map { ... } to triple them

        4) Create a counter closure:
           - var count = 0
           - val inc = { count++ }
           - call inc() 3 times and print count
        """.trimIndent()
    )
    println()
}

