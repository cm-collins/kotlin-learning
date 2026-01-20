/**
 * LESSON 1: DECLARING VARIABLES (val vs var)
 * ============================================================
 * 
 * Learn the difference between immutable (val) and mutable (var) variables.
 * Practice type inference and explicit type declarations.
 */

fun main() {
    variablesExample()
}

fun variablesExample() {
    // val = immutable (cannot change)
    val name: String = "Brian"
    println("Name (val): $name")

    // var = mutable (can change)
    var age: Int = 20
    println("Age before: $age")
    age = 21
    println("Age after: $age")

    // Type inference (Kotlin can guess types)
    val country = "Kenya"   // Kotlin knows this is String
    val year = 2026         // Kotlin knows this is Int
    println("Country: $country, Year: $year\n")
}
