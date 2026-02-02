/**
 * LESSON 4: FUNCTIONS
 * ============================================================
 * 
 * Learn how to:
 * - Declare functions with parameters and return types
 * - Call functions
 * - Use functions that return Unit (nothing) vs values
 */

fun main() {
    functionsExample()
}

/* ============================================================
   Calling functions + return values
   ============================================================ */
// Beginner note:
// - A function is a reusable block of code you can “call” by name.
// - Functions can take inputs (parameters) and can optionally return a value.
// - If a function returns nothing meaningful, Kotlin uses `Unit` (similar to void).
fun functionsExample() {
    // Calling functions
    greetUser("Brian")
    val sum = addNumbers(10, 5)
    println("Sum = $sum")

    val evenCheck = isEven(12)
    println("12 is even? $evenCheck\n")
}

/* ============================================================
   Unit-returning function
   ============================================================ */
// Beginner note:
// - This function “does something” (prints), but doesn’t return a value.
// - You usually don’t write `: Unit` because it’s the default.
fun greetUser(name: String) {
    println("Hello, $name!")
}

/* ============================================================
   Returning a value (Int)
   ============================================================ */
// Beginner note:
// - The return type comes after `:` (Int here).
// - Use `return` to send a value back to the caller.
fun addNumbers(a: Int, b: Int): Int {
    return a + b
}

/* ============================================================
   Returning Boolean
   ============================================================ */
// Beginner note:
// - Boolean functions often answer a yes/no question.
// - Naming pattern: isXxx / hasXxx / canXxx.
fun isEven(number: Int): Boolean {
    return number % 2 == 0
}
