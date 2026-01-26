/**
 * LESSON 9: FUNCTION PARAMETERS
 * ============================================================
 *
 * This lesson focuses on “everything around function parameters” in Kotlin:
 *
 * - Parameter types (and return types)
 * - Default arguments
 * - Named arguments
 * - vararg parameters (+ the spread operator *)
 * - Nullable parameters and validation
 * - Higher-order functions (functions that accept lambdas)
 * - Trailing lambda syntax
 *
 * Tip:
 * Kotlin parameters are read-only inside the function (you can't reassign them).
 *
 * Parameter types (important):
 * - Parameters ALWAYS have a type: `name: String`, `age: Int`, `email: String?`
 * - Kotlin can infer types for variables (`val x = 10`), but function parameters
 *   must declare their types explicitly.
 * - A `?` means nullable: `String?` can hold null, `String` cannot.
 * - Function type parameters look like: `(InputType) -> OutputType`
 */

fun main() {
    basicParametersExample()
    defaultAndNamedArgsExample()
    varargExample()
    nullableParamsAndValidationExample()
    higherOrderFunctionExample()

    // Optional mini exercise — uncomment to try:
    // miniExercise()
}

/* ============================================================
   1) BASIC PARAMETERS + RETURN TYPES
   ============================================================ */
fun basicParametersExample() {
    println("=== 1) Basic parameters ===")

    val total = add(a = 10, b = 5)
    println("add(10, 5) = $total")

    greet(name = "Munene")
    println()
}

// a and b are parameters of type Int, and the function returns an Int.
fun add(a: Int, b: Int): Int = a + b

// name is a non-nullable String parameter.
// Return type is Unit (like void). Writing ": Unit" is optional.
fun greet(name: String): Unit {
    // Unit is like “void” in other languages (and it's optional to write)
    println("Hello, $name!")
}

/* ============================================================
   2) DEFAULT ARGUMENTS + NAMED ARGUMENTS
   ============================================================ */
fun defaultAndNamedArgsExample() {
    println("=== 2) Default + named arguments ===")

    // Default arguments: you can omit parameters with defaults
    println(formatUser(name = "Alice"))
    println(formatUser(name = "Brian", role = "Admin"))

    // Named arguments: useful when there are many params or same types
    println(buildUrl(host = "example.com", path = "/users", useHttps = true))
    println(buildUrl(path = "/health", host = "localhost", useHttps = false))
    println()
}

// Default parameters:
// - role defaults to "User"
// - isActive defaults to true
// This avoids writing multiple overloads like formatUser(name) and formatUser(name, role).
fun formatUser(name: String, role: String = "User", isActive: Boolean = true): String {
    val status = if (isActive) "active" else "inactive"
    return "$name ($role) is $status"
}

// Named arguments:
// - Call sites can pass parameters by name (host=..., path=..., useHttps=...)
// - Helpful when multiple parameters have the same type (e.g., many Strings)
// - Lets you reorder arguments safely
fun buildUrl(host: String, path: String, useHttps: Boolean = true): String {
    val scheme = if (useHttps) "https" else "http"
    return "$scheme://$host$path"
}

/* ============================================================
   3) vararg PARAMETERS (variable number of args)
   ============================================================ */
fun varargExample() {
    println("=== 3) vararg ===")

    println(sumAll(1, 2, 3))
    println(sumAll(10))

    val numbers = intArrayOf(4, 5, 6)
    // Spread operator (*) expands an array into vararg arguments
    println(sumAll(*numbers))
    println()
}

// vararg parameters:
// - Allow the caller to pass 0..N arguments
// - Inside the function, `values` behaves like an array of Ints
fun sumAll(vararg values: Int): Int = values.sum()

/* ============================================================
   4) NULLABLE PARAMETERS + VALIDATION
   ============================================================ */
fun nullableParamsAndValidationExample() {
    println("=== 4) Nullable params + validation ===")

    println(normalizeEmail(" Alice@Example.COM "))
    println(normalizeEmail(null))

    // Using require() for parameter validation
    println("divide(10, 2) = ${divide(10, 2)}")
    // divide(10, 0) // Uncomment to see IllegalArgumentException
    println()
}

// Nullable parameter:
// - email: String? means callers can pass null
// - Great for optional inputs (e.g., optional form fields)
fun normalizeEmail(email: String?): String {
    // Treat null/blank as “no email”
    if (email.isNullOrBlank()) return "(no email)"
    return email.trim().lowercase()
}

// Parameter validation:
// - require(condition) throws IllegalArgumentException if condition is false
// - Use it for guarding invalid parameter values early
fun divide(a: Int, b: Int): Int {
    require(b != 0) { "b must not be 0" }
    return a / b
}

/* ============================================================
   5) HIGHER-ORDER FUNCTIONS (functions that accept lambdas)
   ============================================================ */
fun higherOrderFunctionExample() {
    println("=== 5) Higher-order functions ===")

    val numbers = listOf(1, 2, 3, 4)

    // Passing a lambda as a parameter
    val squared = transform(numbers) { n -> n * n }
    println("Squared: $squared")

    // Trailing lambda syntax (when the last parameter is a lambda)
    val doubled = transform(numbers) { it * 2 }
    println("Doubled: $doubled")

    // Another example: custom filter using a predicate
    val evens = select(numbers) { it % 2 == 0 }
    println("Evens: $evens")
    println()
}

// Function-type parameter:
// - mapper has type: (Int) -> Int
//   meaning: it accepts an Int and returns an Int
// - This is the same idea used in standard library functions like map { ... }
fun transform(items: List<Int>, mapper: (Int) -> Int): List<Int> {
    val result = mutableListOf<Int>()
    for (item in items) {
        result.add(mapper(item))
    }
    return result
}

// predicate has type: (Int) -> Boolean
// - This is similar to filter { ... } in the standard library
fun select(items: List<Int>, predicate: (Int) -> Boolean): List<Int> {
    val result = mutableListOf<Int>()
    for (item in items) {
        if (predicate(item)) result.add(item)
    }
    return result
}

/* ============================================================
   MINI EXERCISE (Try it yourself)
   ============================================================ */
fun miniExercise() {
    // 1) Write a function: repeatWord(word: String, times: Int = 3): String
    //    - It should return "word" repeated 'times' separated by "-".
    //    - Example: repeatWord("Hi") -> "Hi-Hi-Hi"
    //
    // 2) Write a function: average(vararg values: Int): Double
    //    - Return 0.0 if no values are provided.
    //
    // 3) Write a function: safeParseInt(input: String?): Int?
    //    - Return null if input is null/blank/not a valid number.
    //
    // 4) Write a function: applyToName(name: String, block: (String) -> String): String
    //    - Call the lambda on the name and return the result.
}
