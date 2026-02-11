/**
 * ABSTRACT CLASSES (BEGINNER FRIENDLY)
 * ============================================================
 *
 * Abstract class = a class you cannot instantiate directly.
 *
 * Why use it?
 * - You want a common “base” that shares rules/behavior for many subclasses.
 * - You want to FORCE subclasses to implement certain members (abstract properties/functions).
 *
 * Key ideas:
 * - `abstract class` cannot be created with `Sensor()`.
 * - `abstract` members have no body in the base class, so subclasses MUST implement them.
 * - `open` allows inheritance. (Note: abstract classes are open by default.)
 * - `override` is required when you implement/replace a base member.
 *
 * Abstract class vs Interface (simple rule):
 * - Use an interface when you just want a “capability” contract.
 * - Use an abstract class when you want a contract + shared implementation/state.
 */

fun main() {
    abstractClassBasicsDemo()
    polymorphismDemo()
}

/* ============================================================
   1) ABSTRACT CLASS BASICS
   ============================================================ */
// Beginner note:
// - We create a concrete subclass (HeartRateSensor) and call it via a callback.
// - The callback parameter is a lambda: (Float) -> Unit
fun abstractClassBasicsDemo() {
    println("=== Abstract class basics ===")

    val sensor = HeartRateSensor()
    println("sensor.name = ${sensor.name}")

    sensor.startListening { value ->
        println("Heart rate: $value")
    }

    println()
}

/* ============================================================
   2) POLYMORPHISM (PROGRAM TO THE BASE TYPE)
   ============================================================ */
// Beginner note:
// - You can store a subclass in a variable typed as the abstract base class.
// - At runtime, Kotlin will call the overridden implementation of the real object.
fun polymorphismDemo() {
    println("=== Polymorphism demo ===")

    val sensors: List<Sensor> = listOf(
        HeartRateSensor(),
        CustomerHeartRateSensor(),
    )

    for (s in sensors) {
        println("Listening to: ${s.name}")
        s.startListening { value -> println("  value=$value") }
    }

    println()
}

/* ============================================================
   ABSTRACT BASE CLASS: Sensor
   ============================================================ */
// Beginner note:
// - Abstract base classes can contain BOTH:
//   - abstract members (must be implemented)
//   - normal members (shared code for all subclasses)
abstract class Sensor {
    abstract val name: String

    // Abstract function: subclasses MUST implement it
    abstract fun startListening(onNewValue: (Float) -> Unit)

    // Normal function with shared behavior
    fun printHeader() {
        println("-> Sensor '$name' started")
    }
}

/* ============================================================
   CONCRETE IMPLEMENTATION: HeartRateSensor
   ============================================================ */
// Beginner note:
// - This class must override all abstract members.
// - `open` is required here because we want another class to extend it.
open class HeartRateSensor : Sensor() {
    override val name: String = "Heart Rate Sensor"

    override fun startListening(onNewValue: (Float) -> Unit) {
        printHeader()

        // Simple simulation: emit a few sample values
        val sampleValues = listOf(72.0f, 73.5f, 75.0f)
        for (v in sampleValues) {
            onNewValue(v)
        }
    }
}

/* ============================================================
   SUBCLASS OVERRIDING A PROPERTY
   ============================================================ */
// Beginner note:
// - A subclass can override properties/functions to customize behavior.
class CustomerHeartRateSensor : HeartRateSensor() {
    override val name: String = "Custom Heart Rate Sensor"
}

