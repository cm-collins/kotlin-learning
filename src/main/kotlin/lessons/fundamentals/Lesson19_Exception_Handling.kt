/**
 * LESSON 19: EXCEPTION HANDLING
 * ============================================================
 *
 * This lesson completes Stage 1.7:
 * - Try-catch-finally
 * - Throwing exceptions
 * - Custom exceptions
 * - Nothing type
 * - Checked vs unchecked exceptions (Kotlin vs Java)
 *
 * Beginner mindset:
 * - Exceptions are for “unexpected” or invalid situations.
 * - For invalid function arguments, prefer `require(...)` / `check(...)`.
 * - Always include a helpful message so debugging is easier.
 */

import interop.Lesson19JavaCheckedApi

fun main() {
    lesson19TryCatchFinally()
    lesson19ThrowingExceptions()
    lesson19CustomExceptions()
    lesson19NothingType()
    lesson19CheckedVsUnchecked()
    lesson19MiniExercise()
}

/* ============================================================
   1) TRY / CATCH / FINALLY
   ============================================================ */
// Beginner note:
// - try { ... } runs code that might fail.
// - catch (e: Exception) { ... } handles the failure.
// - finally { ... } runs whether it failed or not (cleanup).
fun lesson19TryCatchFinally() {
    println("=== Lesson 19.1) try/catch/finally ===")

    val inputs = listOf("42", "not-a-number", "100")

    for (raw in inputs) {
        try {
            val value = raw.toInt() // can throw NumberFormatException
            println("Parsed '$raw' -> $value")
        } catch (e: NumberFormatException) {
            println("Failed to parse '$raw': ${e.message}")
        } finally {
            // finally is good for “always do this”
            // e.g., closing a resource, logging, resetting state, etc.
        }
    }

    println()
}

/* ============================================================
   2) THROWING EXCEPTIONS
   ============================================================ */
// Beginner note:
// - You throw an exception when you want to stop execution due to invalid state/input.
// - Prefer `require(...)` for invalid function arguments.
fun lesson19ThrowingExceptions() {
    println("=== Lesson 19.2) throwing exceptions ===")

    println("divide(10, 2) = ${lesson19Divide(10, 2)}")

    try {
        println("divide(10, 0) = ${lesson19Divide(10, 0)}")
    } catch (e: IllegalArgumentException) {
        println("Caught error: ${e.message}")
    }

    println()
}

fun lesson19Divide(a: Int, b: Int): Int {
    require(b != 0) { "b must not be 0" }
    return a / b
}

/* ============================================================
   3) CUSTOM EXCEPTIONS
   ============================================================ */
// Beginner note:
// - Custom exceptions make errors clearer and more “domain-specific”.
// - Naming convention: SomethingException (e.g., InvalidUserInputException).
fun lesson19CustomExceptions() {
    println("=== Lesson 19.3) custom exceptions ===")

    try {
        lesson19RegisterUser(username = "ab") // too short
    } catch (e: Lesson19InvalidUsernameException) {
        println("Registration failed: ${e.message}")
    }

    val user = lesson19RegisterUser(username = "munene")
    println("Registered user: $user")

    println()
}

class Lesson19InvalidUsernameException(message: String) : Exception(message)

data class Lesson19User(val username: String)

fun lesson19RegisterUser(username: String): Lesson19User {
    if (username.length < 3) {
        throw Lesson19InvalidUsernameException("Username must be at least 3 characters")
    }
    return Lesson19User(username)
}

/* ============================================================
   4) NOTHING TYPE
   ============================================================ */
// Beginner note:
// - `Nothing` means: “this function never returns normally”.
// - It always throws an exception (or loops forever).
// - It helps Kotlin with smart typing and control flow.
fun lesson19NothingType() {
    println("=== Lesson 19.4) Nothing type ===")

    val maybeName: String? = null

    // Elvis operator with a function that returns Nothing:
    // - If maybeName is null, lesson19Fail(...) throws and the whole expression stops.
    val name: String = maybeName ?: lesson19Fail("Name is required")
    println("This line will not run. name=$name")
}

fun lesson19Fail(message: String): Nothing {
    throw IllegalStateException(message)
}

/* ============================================================
   5) CHECKED VS UNCHECKED EXCEPTIONS (Kotlin vs Java)
   ============================================================ */
// Beginner note:
// - Kotlin does NOT have checked exceptions. The compiler won’t force you to catch/declare.
// - Java DOES have checked exceptions (e.g., IOException) declared with `throws`.
// - When calling Java from Kotlin, Kotlin still won’t force a try/catch, but the exception can still happen at runtime.
fun lesson19CheckedVsUnchecked() {
    println()
    println("=== Lesson 19.5) checked vs unchecked (Kotlin vs Java) ===")

    try {
        // Java method declares: throws IOException
        // Kotlin lets you call it without being forced to catch, but it can throw at runtime.
        Lesson19JavaCheckedApi.alwaysThrowsIOException()
    } catch (e: Exception) {
        println("Caught exception from Java call: ${e::class.simpleName} - ${e.message}")
    }

    println()
}

/* ============================================================
   MINI EXERCISE (Try it yourself)
   ============================================================ */
fun lesson19MiniExercise() {
    println("=== Lesson 19: Mini exercise (try it) ===")
    println(
        """
        1) Write a function safeParseInt(input: String): Int?
           - Use try/catch and return null if it can't be parsed.

        2) Write a custom exception: InvalidAgeException
           - Throw it when age < 0 or age > 150.

        3) Write a function failIfBlank(value: String?): String
           - Return value trimmed if not blank, otherwise throw using a Nothing-returning helper.
        """.trimIndent()
    )
    println()
}

