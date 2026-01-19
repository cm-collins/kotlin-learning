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

fun functionsExample() {
    // Calling functions
    greetUser("Brian")
    val sum = addNumbers(10, 5)
    println("Sum = $sum")

    val evenCheck = isEven(12)
    println("12 is even? $evenCheck\n")
}

// Function that returns nothing (Unit)
fun greetUser(name: String) {
    println("Hello, $name!")
}

// Function that returns an Int
fun addNumbers(a: Int, b: Int): Int {
    return a + b
}

// Function returning Boolean
fun isEven(number: Int): Boolean {
    return number % 2 == 0
}
