/**
 * VALUE CLASSES (a.k.a. inline classes) — `@JvmInline value class`
 * ============================================================
 *
 * Goal:
 * - Make your code MORE type-safe without creating “extra” wrapper objects in many cases.
 *
 * Example problem:
 * - If you use String everywhere, you can accidentally mix up values:
 *     sendEmail(to = "123") // oops, that was a userId, not an email
 *
 * Solution:
 * - Wrap important primitives/Strings in a value class:
 *     value class Email(val value: String)
 *
 * Key properties:
 * - A value class has exactly ONE property in its primary constructor.
 * - On the JVM, Kotlin tries to represent it as the underlying type at runtime (no extra allocation)…
 *   …but it MAY be “boxed” (wrapped) in some situations (Any, generics, nullable).
 *
 * Value class vs data class (simple rule):
 * - Use a value class for a SINGLE VALUE wrapper (Email, UserId, MoneyCents).
 * - Use a data class for multiple fields (User(name, email, age)).
 */

fun main() {
    lessonValueClassBasics()
    lessonValueClassTypeSafetyDemo()
    lessonValueClassBoxingDemo()
    lessonValueMiniExercise()
}

/* ============================================================
   1) BASICS + VALIDATION (init block)
   ============================================================ */
// Beginner note:
// - You can validate in `init` just like a normal class.
// - If validation fails, throw an exception (or create a safe factory function).
fun lessonValueClassBasics() {
    println("=== Value class basics ===")

    val email = Email("william.strong@my-own-personal-domain.com")
    println("email.value = ${email.value}")
    println("email.domain() = ${email.domain()}")

    // Uncomment to see validation fail:
    // Email("not-an-email")

    println()
}

/* ============================================================
   2) TYPE-SAFETY BENEFIT
   ============================================================ */
// Beginner note:
// - This is the main win: you cannot pass the wrong type by mistake.
fun lessonValueClassTypeSafetyDemo() {
    println("=== Type safety demo ===")

    val userId = UserId(123)
    val email = Email("amina@example.com")

    lessonSendWelcomeEmail(userId = userId, email = email)

    // This WON'T compile (good!):
    // lessonSendWelcomeEmail(userId = email, email = userId)

    println()
}

fun lessonSendWelcomeEmail(userId: UserId, email: Email) {
    println("Sending welcome email to userId=${userId.value}, email=${email.value}")
}

/* ============================================================
   3) BOXING (WHEN IT ACTS LIKE A REAL OBJECT)
   ============================================================ */
// Beginner note:
// - Value classes *often* avoid extra allocations, but they can be boxed.
// - Common boxing situations:
//   - when used as `Any`
//   - when used as nullable (Email?)
//   - when used in generics (List<Email>)
fun lessonValueClassBoxingDemo() {
    println("=== Boxing demo ===")

    val email = Email("brian@example.com")

    val asAny: Any = email            // boxed
    val asNullable: Email? = email    // may be boxed
    val list: List<Email> = listOf(email) // generic → boxing can happen

    println("asAny = $asAny")
    println("asNullable = $asNullable")
    println("list = $list")

    // Equality still works as you'd expect:
    println("Email('x') == Email('x') -> ${Email("x@y.com") == Email("x@y.com")}")

    println()
}

/* ============================================================
   MINI EXERCISE
   ============================================================ */
fun lessonValueMiniExercise() {
    println("=== Mini exercise (try it) ===")
    println(
        """
        1) Create a value class PhoneNumber(val value: String)
           - Validate that it starts with "+".

        2) Create a value class MoneyCents(val value: Long)
           - Add a function to format it as dollars (value/100.0).

        3) Why is this safer than using String/Long everywhere?
           - It prevents mixing different meanings of the same primitive type.
        """.trimIndent()
    )
    println()
}

/* ============================================================
   VALUE CLASSES
   ============================================================ */
@JvmInline
value class Email(val value: String) {
    init {
        require(value.contains("@")) { "Invalid email address: missing '@'" }
    }

    fun domain(): String = value.substringAfter("@")
}

@JvmInline
value class UserId(val value: Int) {
    init {
        require(value > 0) { "UserId must be positive" }
    }
}