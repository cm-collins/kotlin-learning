/**
 * Kotlin Beginner Practice File
 * =============================
 * RULES:
 * 1) Read from top to bottom.
 * 2) Uncomment ONE section in main() at a time.
 * 3) Practice by changing values and re-running.
 */

fun main() {

    // ---------------------------------------------------------
    // LESSON 1: Variables (val vs var)
    // ---------------------------------------------------------
    // variablesExample()

    // ---------------------------------------------------------
    // LESSON 2: Data Types (Int, Double, Float, Boolean, Char, String)
    // ---------------------------------------------------------
    // dataTypesExample()

    // ---------------------------------------------------------
    // LESSON 3: Arithmetic Operators (+, -, *, /, %)
    // ---------------------------------------------------------
    // arithmeticOperatorsExample()

    // ---------------------------------------------------------
    // LESSON 4: Comparison Operators (==, !=, <, >, <=, >=)
    // ---------------------------------------------------------
    // comparisonOperatorsExample()

    // ---------------------------------------------------------
    // LESSON 5: Logical Operators (&&, ||, !)
    // ---------------------------------------------------------
    // logicalOperatorsExample()

    // ---------------------------------------------------------
    // LESSON 6: If / Else If / Else
    // ---------------------------------------------------------
    // ifConditionsExample()

    // ---------------------------------------------------------
    // LESSON 7: Functions (declaring + calling)
    // ---------------------------------------------------------
    // functionsExample()

    // ---------------------------------------------------------
    // LESSON 8: Exercise - Palindrome Checker
    // ---------------------------------------------------------
    palindromeExample()
}

/* ============================================================
   LESSON 1: DECLARING VARIABLES (val vs var)
   ============================================================ */
//fun variablesExample() {
//
//    // val = immutable (cannot change)
//    val name: String = "Brian"
//    println("Name (val): $name")
//
//    // var = mutable (can change)
//    var age: Int = 20
//    println("Age before: $age")
//    age = 21
//    println("Age after: $age")
//
//    // Type inference (Kotlin can guess types)
//    val country = "Kenya"   // Kotlin knows this is String
//    val year = 2026         // Kotlin knows this is Int
//    println("Country: $country, Year: $year\n")
//}

/* ============================================================
   LESSON 2: DATA TYPES
   ============================================================ */
//fun dataTypesExample() {
//
//    val myInt: Int = 10
//    val myLong: Long = 10000000000L
//    val myDouble: Double = 10.55
//    val myFloat: Float = 10.55F
//    val myBoolean: Boolean = true
//    val myChar: Char = 'K'
//    val myString: String = "Kotlin"
//
//    println("Int: $myInt")
//    println("Long: $myLong")
//    println("Double: $myDouble")
//    println("Float: $myFloat")
//    println("Boolean: $myBoolean")
//    println("Char: $myChar")
//    println("String: $myString\n")
//
//    // Quick note:
//    // Double is the default decimal type in Kotlin.
//}

/* ============================================================
   LESSON 3: ARITHMETIC OPERATORS
   ============================================================ */
//fun arithmeticOperatorsExample() {
//    val a = 10
//    val b = 3
//
//    println("a + b = ${a + b}")  // addition
//    println("a - b = ${a - b}")  // subtraction
//    println("a * b = ${a * b}")  // multiplication
//    println("a / b = ${a / b}")  // division (Int division gives Int)
//    println("a % b = ${a % b}")  // modulus (remainder)
//
//    // If you want decimal division, use Double:
//    val result = a.toDouble() / b
//    println("a / b (decimal) = $result\n")
//}

/* ============================================================
   LESSON 4: COMPARISON OPERATORS
   ============================================================ */
//fun comparisonOperatorsExample() {
//    val x = 7
//    val y = 10
//
//    println("x == y : ${x == y}")
//    println("x != y : ${x != y}")
//    println("x < y  : ${x < y}")
//    println("x > y  : ${x > y}")
//    println("x <= y : ${x <= y}")
//    println("x >= y : ${x >= y}\n")
//}

/* ============================================================
   LESSON 5: LOGICAL OPERATORS
   ============================================================ */
//fun logicalOperatorsExample() {
//    val isAdult = true
//    val hasID = false
//
//    // && (AND) -> both must be true
//    println("Adult AND has ID: ${isAdult && hasID}")
//
//    // || (OR) -> at least one must be true
//    println("Adult OR has ID: ${isAdult || hasID}")
//
//    // ! (NOT) -> reverses boolean value
//    println("NOT hasID: ${!hasID}\n")
//}

/* ============================================================
   LESSON 6: IF CONDITIONS
   ============================================================ */
//fun ifConditionsExample() {
//    val x = 7
//    val y = 7
//
//    if (x < y) {
//        println("$x is less than $y")
//    } else if (x > y || x * y == 49) {
//        println("At least one condition is true (x > y OR x*y == 49)")
//    } else {
//        println("$x is equal to $y")
//    }
//
//    println("This line always runs\n")
//}

/* ============================================================
   LESSON 7: FUNCTIONS
   ============================================================ */
//fun functionsExample() {
//
//    // Calling functions
//    greetUser("Brian")
//    val sum = addNumbers(10, 5)
//    println("Sum = $sum")
//
//    val evenCheck = isEven(12)
//    println("12 is even? $evenCheck\n")
//}

// Function that returns nothing (Unit)
//fun greetUser(name: String) {
//    println("Hello, $name!")
//}

// Function that returns an Int
//fun addNumbers(a: Int, b: Int): Int {
//    return a + b
//}

// Function returning Boolean
//fun isEven(number: Int): Boolean {
//    return number % 2 == 0
//}

/* ============================================================
   LESSON 8: EXERCISE - PALINDROME CHECKER
   ============================================================ */
//fun palindromeExample() {
//    val word: String = "madam"
//
//    val cleaned = word.lowercase().replace(" ", "")
//    val reversed = cleaned.reversed()
//
//    if (cleaned == reversed) {
//        println("\"$word\" is a palindrome ✅")
//    } else {
//        println("\"$word\" is NOT a palindrome ❌")
//    }
//
//    // Try more examples:
//    // println(isPalindrome("Race car")) // true
//    // println(isPalindrome("Hello"))    // false
//}
//
//fun isPalindrome(input: String): Boolean {
//    val cleaned = input.lowercase().replace(" ", "")
//    return cleaned == cleaned.reversed()
}
