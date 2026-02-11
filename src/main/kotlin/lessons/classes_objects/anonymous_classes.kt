/**
 * ANONYMOUS CLASSES / OBJECT EXPRESSIONS (BEGINNER FRIENDLY)
 * ============================================================
 *
 * In Kotlin, what people call “anonymous classes” are usually written using an
 * **object expression**:
 *
 *   val x = object : SomeInterface { ... }
 *
 * This creates a one-off object instance without giving it a class name.
 *
 * When and where is this used?
 * - **Callbacks / listeners** (especially common in Android and UI code)
 * - **Adapters / strategies** (you want to plug in behavior)
 * - **Small one-off implementations** of an interface/abstract class
 * - **Comparators** and custom behavior objects
 *
 * Prefer a lambda instead when:
 * - The API expects a single function (one-method interface / functional style).
 *
 * Prefer a named class instead when:
 * - The implementation is large, reused, or needs testing.
 */

fun main() {
    callbackListenerDemo()
    extendingAbstractClassDemo()
    comparatorDemo()
    lessonAnonMiniExercise()
}

/* ============================================================
   1) CALLBACKS / LISTENERS (COMMON USE CASE)
   ============================================================ */
// Beginner note:
// - A listener is an object that receives events.
// - In real apps, this is used for button clicks, sensor updates, network callbacks, etc.
fun callbackListenerDemo() {
    println("=== Callback/listener demo ===")

    val emitter = LessonAnonValueEmitter()

    // Anonymous object implementing an interface:
    emitter.start(object : LessonAnonOnValueListener {
        override fun onValue(value: Int) {
            println("Listener got value: $value")
        }
    })

    println()
}

interface LessonAnonOnValueListener {
    fun onValue(value: Int)
}

class LessonAnonValueEmitter {
    fun start(listener: LessonAnonOnValueListener) {
        // Simulate events:
        for (v in listOf(10, 20, 30)) {
            listener.onValue(v)
        }
    }
}

/* ============================================================
   2) EXTENDING AN ABSTRACT CLASS (ONE-OFF IMPLEMENTATION)
   ============================================================ */
// Beginner note:
// - You can also extend an abstract class using an anonymous object.
// - Useful when you need a quick implementation right here.
fun extendingAbstractClassDemo() {
    println("=== Extending an abstract class demo ===")

    val processor = object : LessonAnonProcessor() {
        override fun process(input: String): String = input.trim().uppercase()
    }

    println(processor.process("  kotlin  "))
    println()
}

abstract class LessonAnonProcessor {
    abstract fun process(input: String): String
}

/* ============================================================
   3) COMPARATORS (CUSTOM SORT BEHAVIOR)
   ============================================================ */
// Beginner note:
// - A Comparator decides ordering.
// - Sometimes a lambda works (sortedBy), but an anonymous object can be clearer for custom rules.
fun comparatorDemo() {
    println("=== Comparator demo ===")

    val names = listOf("Munene", "Amina", "Brian", "Caro")

    val byLengthThenAlpha = object : Comparator<String> {
        override fun compare(a: String, b: String): Int {
            val len = a.length.compareTo(b.length)
            return if (len != 0) len else a.compareTo(b)
        }
    }

    println(names.sortedWith(byLengthThenAlpha))
    println()
}

/* ============================================================
   MINI EXERCISE
   ============================================================ */
fun lessonAnonMiniExercise() {
    println("=== Mini exercise (try it) ===")
    println(
        """
        1) Create an interface ClickListener { fun onClick(id: String) }
           - Pass an anonymous object to a function simulateClick(listener).

        2) Create an abstract class Logger { abstract fun log(msg: String) }
           - Create an anonymous object that prints: "[LOG] msg"

        3) Write a Comparator<Int> anonymous object that sorts numbers by:
           - even numbers first, then odd numbers
        """.trimIndent()
    )
    println()
}

