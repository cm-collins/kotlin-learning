/**
 * LESSON 6: NULL SAFETY AND USER INPUT
 * ============================================================
 * 
 * Learn about:
 * - Nullable types in Kotlin
 * - Safe calls (?.) and null checks
 * - Reading user input with readLine()
 * - Handling nullable values safely
 */

fun main() {
    nullValuesUserInput()
}

/* ============================================================
   NULL VALUES AND USER INPUTS
   ============================================================ */
// Beginner note:
// - `readLine()` returns String? (nullable) because input may be missing.
// - Use safe calls (?.) or a null-check before calling String methods.
// - Prefer toIntOrNull() for parsing input to avoid NumberFormatException.
fun nullValuesUserInput() {
    val userInput = readLine() // readLine() is a nullable method, always returns String?

    // Safe call operator - only executes if userInput is not null
    println("You entered ${userInput?.uppercase()}")

    // Explicit null check
    if (userInput != null) {
        // Smart cast: Kotlin knows userInput is not null here
        println("You entered ${userInput.toInt() - 5}") // working with integers
    } else {
        println("No input provided")
    }
}
