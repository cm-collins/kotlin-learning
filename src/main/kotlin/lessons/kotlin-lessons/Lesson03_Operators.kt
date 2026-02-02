/**
 * LESSON 3: OPERATORS
 * ============================================================
 * 
 * Learn about different types of operators:
 * - Arithmetic: +, -, *, /, %
 * - Comparison: ==, !=, <, >, <=, >=
 * - Logical: &&, ||, !
 */

fun main() {
    // Uncomment one at a time to practice:
    arithmeticOperatorsExample()
    // comparisonOperatorsExample()
    // logicalOperatorsExample()
}

/* ============================================================
   ARITHMETIC OPERATORS
   ============================================================ */
// Beginner note:
// - Arithmetic operators work like math: +, -, *, /, % (remainder).
// - Int division truncates: 10 / 3 = 3. Use Double for decimal division.
fun arithmeticOperatorsExample() {
    val a = 10
    val b = 3

    println("a + b = ${a + b}")  // addition
    println("a - b = ${a - b}")  // subtraction
    println("a * b = ${a * b}")  // multiplication
    println("a / b = ${a / b}")  // division (Int division gives Int)
    println("a % b = ${a % b}")  // modulus (remainder)

    // If you want decimal division, use Double:
    val result = a.toDouble() / b
    println("a / b (decimal) = $result\n")
}

/* ============================================================
   COMPARISON OPERATORS
   ============================================================ */
// Beginner note:
// - Comparison operators return Boolean: true/false.
// - `==` checks value equality in Kotlin (it calls equals()).
fun comparisonOperatorsExample() {
    val x = 7
    val y = 10

    println("x == y : ${x == y}")
    println("x != y : ${x != y}")
    println("x < y  : ${x < y}")
    println("x > y  : ${x > y}")
    println("x <= y : ${x <= y}")
    println("x >= y : ${x >= y}\n")
}

/* ============================================================
   LOGICAL OPERATORS
   ============================================================ */
// Beginner note:
// - Logical operators combine booleans:
//   && means “both must be true”, || means “at least one true”, ! means “not”.
fun logicalOperatorsExample() {
    val isAdult = true
    val hasID = false

    // && (AND) -> both must be true
    println("Adult AND has ID: ${isAdult && hasID}")

    // || (OR) -> at least one must be true
    println("Adult OR has ID: ${isAdult || hasID}")

    // ! (NOT) -> reverses boolean value
    println("NOT hasID: ${!hasID}\n")
}
