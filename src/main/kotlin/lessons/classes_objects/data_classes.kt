import java.util.Calendar

/**
 * DATA CLASSES (Kotlin)
 * ============================================================
 *
 * A `data class` is a class meant to hold data (state).
 *
 * Kotlin automatically generates for a data class:
 * - `toString()`  -> nice printing
 * - `equals()` + `hashCode()` -> value-based comparison (content)
 * - `copy(...)`   -> make a new object with some changed fields
 * - `componentN()` functions -> enables destructuring: val (a, b) = obj
 *
 * Rule of thumb:
 * - Use `data class` for models (DTOs, UI state, domain models).
 * - Use a normal `class` when identity/behavior matters more than “just data”.
 */

fun main() {
    lessonDataClassToStringEqualsHashCode()
    lessonDataClassCopy()
    lessonDataClassDestructuring()
    lessonDataClassComputedProperty()
    lessonDataClassMiniExercise()
}

/* ============================================================
   1) toString + equals + hashCode
   ============================================================ */
// Beginner note:
// - For data classes, `==` compares CONTENT (all primary-constructor properties).
// - `===` still checks if it’s the exact same instance (same object in memory).
fun lessonDataClassToStringEqualsHashCode() {
    println("=== Data class: toString / equals / hashCode ===")

    val p1 = LessonDataPerson(name = "Amina", birthYear = 2000, email = "amina@example.com")
    val p2 = LessonDataPerson(name = "Amina", birthYear = 2000, email = "amina@example.com")
    val p3 = p1

    // toString() is generated
    println("p1 = $p1")

    // equals() is value-based for data classes
    println("p1 == p2  -> ${p1 == p2}")   // true (same content)
    println("p1 === p2 -> ${p1 === p2}")  // false (different instances)

    println("p1 == p3  -> ${p1 == p3}")   // true
    println("p1 === p3 -> ${p1 === p3}")  // true

    println()
}

/* ============================================================
   2) copy(...)
   ============================================================ */
// Beginner note:
// - `copy` makes a new object with the same data, except what you override.
fun lessonDataClassCopy() {
    println("=== Data class: copy(...) ===")

    val original = LessonDataPerson(name = "Brian", birthYear = 1998, email = "brian@example.com")
    val updatedEmail = original.copy(email = "brian@newmail.com")

    println("original     = $original")
    println("updatedEmail = $updatedEmail")

    println()
}

/* ============================================================
   3) Destructuring (componentN)
   ============================================================ */
// Beginner note:
// - You can destructure a data class into variables in the same order as its constructor params.
fun lessonDataClassDestructuring() {
    println("=== Data class: destructuring ===")

    val person = LessonDataPerson(name = "Munene", birthYear = 2002, email = "munene@example.com")
    val (name, birthYear, email) = person

    println("name=$name, birthYear=$birthYear, email=$email")
    println()
}

/* ============================================================
   4) Computed properties (not stored)
   ============================================================ */
// Beginner note:
// - Properties in the primary constructor are the “data” used for equals/copy/destructuring.
// - A computed property (custom getter) is derived from those values.
fun lessonDataClassComputedProperty() {
    println("=== Data class: computed property ===")

    val person = LessonDataPerson(name = "Caro", birthYear = 1995, email = "caro@example.com")
    println("person.age = ${person.age}")

    println()
}

/* ============================================================
   MINI EXERCISE
   ============================================================ */
fun lessonDataClassMiniExercise() {
    println("=== Mini exercise (try it) ===")
    println(
        """
        1) Create a data class Product(name: String, price: Double)
           - Create two products with same values and compare them with == and ===

        2) Use copy(...) to create a discounted product (price reduced).

        3) Destructure a Product into (name, price) and print them.
        """.trimIndent()
    )
    println()
}

data class LessonDataPerson(
    val name: String,
    val birthYear: Int,
    val email: String
) {
    // Derived (computed) property
    val age: Int
        get() = Calendar.getInstance().get(Calendar.YEAR) - birthYear
}