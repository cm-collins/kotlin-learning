/**
 * LESSON 2: DATA TYPES
 * ============================================================
 * 
 * Learn about Kotlin's basic data types:
 * - Int, Long, Double, Float
 * - Boolean, Char, String
 */

fun main() {
    dataTypesExample()
}

fun dataTypesExample() {
    val myInt: Int = 10
    val myLong: Long = 10000000000L
    val myDouble: Double = 10.55
    val myFloat: Float = 10.55F
    val myBoolean: Boolean = true
    val myChar: Char = 'K'
    val myString: String = "Kotlin"

    println("Int: $myInt")
    println("Long: $myLong")
    println("Double: $myDouble")
    println("Float: $myFloat")
    println("Boolean: $myBoolean")
    println("Char: $myChar")
    println("String: $myString\n")

    // Quick note:
    // Double is the default decimal type in Kotlin.
}
