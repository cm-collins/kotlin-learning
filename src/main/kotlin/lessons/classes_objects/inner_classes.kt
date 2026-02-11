/**
 * NESTED CLASSES vs INNER CLASSES (BEGINNER FRIENDLY)
 * ============================================================
 *
 * Kotlin has two “classes inside classes” concepts:
 *
 * 1) Nested class (default)
 *    - Declared inside another class, but it does NOT hold a reference to the outer instance.
 *    - Think: "namespaced helper class"
 *    - You create it like: Outer.Nested()
 *
 * 2) Inner class (uses the `inner` keyword)
 *    - Holds a reference to an outer instance.
 *    - Can access outer properties/methods directly.
 *    - You create it from an outer instance: val inner = outer.Inner()
 *
 * When to use which?
 * - Use a NESTED class when the inner type is just logically grouped with the outer,
 *   and it doesn't need outer state.
 * - Use an INNER class only when it truly needs to access the outer instance.
 *
 * Caution:
 * - Inner classes keep an implicit reference to the outer object.
 *   In long-lived objects (especially Android), that can contribute to memory leaks if misused.
 */

fun main() {
    nestedClassDemo()
    innerClassDemo()
    lessonInnerMiniExercise()
}

/* ============================================================
   1) NESTED CLASS DEMO (DEFAULT)
   ============================================================ */
// Beginner note:
// - This is like a static nested class in Java.
// - It cannot access outer instance properties unless you pass them in.
fun nestedClassDemo() {
    println("=== Nested class demo ===")

    val nested = LessonInnerOuter.Nested()
    nested.sayHello()

    println()
}

/* ============================================================
   2) INNER CLASS DEMO (`inner`)
   ============================================================ */
// Beginner note:
// - Inner class has access to the outer instance.
// - It can read outer fields and call outer methods.
fun innerClassDemo() {
    println("=== Inner class demo ===")

    val outer = LessonInnerOuter(ownerName = "Munene")
    val inner = outer.Inner()

    inner.printOwner()

    // You can also reference the outer instance explicitly:
    println("Outer via this@LessonInnerOuter.ownerName = ${outer.ownerName}")

    println()
}

/* ============================================================
   OUTER CLASS
   ============================================================ */
class LessonInnerOuter(val ownerName: String) {

    fun outerGreeting(): String = "Hello from Outer (owner=$ownerName)"

    // NESTED class (no `inner` keyword):
    class Nested {
        fun sayHello() {
            println("Hello from Nested")
            // Can't access ownerName here because Nested has no outer reference.
        }
    }

    // INNER class (has a reference to the outer instance):
    inner class Inner {
        fun printOwner() {
            println("Outer ownerName = $ownerName")
            println("outerGreeting() = ${outerGreeting()}")
        }
    }
}

/* ============================================================
   MINI EXERCISE
   ============================================================ */
fun lessonInnerMiniExercise() {
    println("=== Mini exercise (try it) ===")
    println(
        """
        1) Create a class Car(model: String) with:
           - a nested class Specs(horsePower: Int)
           - an inner class Driver(name: String) that can print the car model + driver name

        2) In main(), create:
           - Car.Specs(...)
           - a Car(...) then car.Driver(...)
        """.trimIndent()
    )
    println()
}

