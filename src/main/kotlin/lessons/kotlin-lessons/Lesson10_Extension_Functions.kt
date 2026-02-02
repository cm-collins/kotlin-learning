/**
 * LESSON 10: EXTENSION FUNCTIONS + SCOPE FUNCTIONS
 * ============================================================
 *
 * This lesson covers two related Kotlin topics that you will use every day:
 *
 * 1) Extension functions (and extension properties)
 *    - Add "extra" functions to existing types without editing their source code.
 *    - Great for readability, reuse, and domain-specific helpers.
 *
 * 2) Scope functions: let / apply / run / also / with
 *    - Compact ways to run a code block with an object as the context.
 *    - Helps with null-safety, configuration, and clean chaining.
 *
 * Key idea:
 * - Extensions look like you're adding methods to a type, but they are resolved statically.
 * - Scope functions differ mainly in:
 *   - How you access the object inside the lambda: `it` or `this`
 *   - What the function returns: the object or the lambda result
 */

fun main() {
    extensionFunctionsBasicsDemo()
    extensionPropertiesDemo()
    nullableReceiverExtensionsDemo()
    extensionResolutionRulesDemo()
    primeNumberExtensionDemo()

    println()
    println("============================================================")
    println("Scope functions")
    println("============================================================")

    scopeFunctionsQuickCheatSheet()
    letDemo()
    applyDemo()
    runDemo()
    alsoDemo()
    withDemo()

    lesson10MiniExercise()
}

/* ============================================================
   1) EXTENSION FUNCTIONS BASICS
   ============================================================ */
fun extensionFunctionsBasicsDemo() {
    println("=== 1) Extension functions basics ===")

    val name = "munene"
    println("capitalizeFirst(): ${name.capitalizeFirst()}")

    val numbers = listOf(10, 20, 30, 40)
    println("secondOrNull(): ${numbers.secondOrNull()}")

    println()
}

// Extension function on String:
// - Receiver type is String (the type before the dot)
// - Inside the body, `this` refers to the receiver (the String instance)
fun String.capitalizeFirst(): String {
    if (this.isEmpty()) return this
    return this[0].uppercase() + this.substring(1)
}

// Generic extension function:
// - Works for List<Int>, List<String>, List<User>, etc.
fun <T> List<T>.secondOrNull(): T? = if (this.size >= 2) this[1] else null

/* ============================================================
   2) EXTENSION PROPERTIES
   ============================================================ */
fun extensionPropertiesDemo() {
    println("=== 2) Extension properties ===")

    val sentence = "Kotlin scope functions are very useful"
    println("wordCount: ${sentence.wordCount}")

    println()
}

// Extension property:
// - No backing field (you can't store state in an extension property)
// - Usually computed from existing data
val String.wordCount: Int
    get() = this.trim()
        .split(Regex("\\s+"))
        .filter { it.isNotBlank() }
        .size

/* ============================================================
   3) NULLABLE RECEIVER EXTENSIONS
   ============================================================ */
fun nullableReceiverExtensionsDemo() {
    println("=== 3) Nullable receiver extensions ===")

    val a: String? = null
    val b: String? = "  hello  "

    println("a.safeTrimOrEmpty() = '${a.safeTrimOrEmpty()}'")
    println("b.safeTrimOrEmpty() = '${b.safeTrimOrEmpty()}'")

    println()
}

// Nullable receiver:
// - Receiver is String? not String
// - Allows calling the extension even when the value is null
fun String?.safeTrimOrEmpty(): String = this?.trim().orEmpty()

/* ============================================================
   4) EXTENSION RESOLUTION RULES (important!)
   ============================================================ */
fun extensionResolutionRulesDemo() {
    println("=== 4) Extension resolution rules ===")

    // Rule A: If a MEMBER function exists with the same signature, it wins.
    val person = Lesson10Person(name = "Amina")
    println("person.greet() = ${person.greet()}") // calls the member, not the extension

    // Rule B: Extensions are resolved statically (by the declared type).
    val declaredAsParent: Lesson10Parent = Lesson10Child()
    println("declaredAsParent.whoAmI() = ${declaredAsParent.whoAmI()}") // uses Parent version

    val declaredAsChild: Lesson10Child = Lesson10Child()
    println("declaredAsChild.whoAmI() = ${declaredAsChild.whoAmI()}") // uses Child version

    println()
}

data class Lesson10Person(val name: String) {
    fun greet(): String = "Hi, I'm $name (member function)"
}

// Same name as member function:
// - This extension exists, but it will NOT be called when greet() is a member.
fun Lesson10Person.greet(): String = "Hi, I'm $name (extension function)"

open class Lesson10Parent
class Lesson10Child : Lesson10Parent()

fun Lesson10Parent.whoAmI(): String = "I am Parent (extension)"
fun Lesson10Child.whoAmI(): String = "I am Child (extension)"

/* ============================================================
   5) PRACTICAL EXTENSION: Int.isPrime()
   ============================================================ */
fun primeNumberExtensionDemo() {
    println("=== 5) Practical extension: Int.isPrime() ===")

    val inputs = listOf(-5, 0, 1, 2, 3, 4, 5, 9, 11, 25, 29)
    for (n in inputs) {
        println("$n isPrime = ${n.isPrime()}")
    }

    println()
}

// Prime number check:
// - Efficient enough for learning: checks divisors up to sqrt(n)
// - Handles edge cases: n < 2 is not prime
fun Int.isPrime(): Boolean {
    val n = this
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false

    var i = 3
    while (i * i <= n) {
        if (n % i == 0) return false
        i += 2
    }
    return true
}

/* ============================================================
   6) SCOPE FUNCTIONS OVERVIEW
   ============================================================ */
fun scopeFunctionsQuickCheatSheet() {
    println("=== 6) Scope functions: cheat sheet ===")
    println(
        """
        Function  | Context object | Returns
        --------- | -------------- | ----------------------------
        let       | it             | lambda result
        run       | this           | lambda result
        apply     | this           | context object (receiver)
        also      | it             | context object (receiver)
        with(obj) | this           | lambda result
        """.trimIndent()
    )
    println()
}

/* ============================================================
   7) let — null safety and transformations
   ============================================================ */
fun letDemo() {
    println("=== 7) let ===")

    val email: String? = "munene@example.com"

    // let is great for:
    // - Null checks (email?.let { ... })
    // - Transformations (return something new)
    val domain: String = email
        ?.let { it.substringAfter("@") }
        ?: "(no domain)"

    println("email = $email")
    println("domain = $domain")

    // Another transformation example:
    val raw = "   kotlin  "
    val message = raw
        .trim()
        .lowercase()
        .let { "Normalized input: '$it' (length=${it.length})" }
    println(message)

    println()
}

/* ============================================================
   8) apply — object configuration
   ============================================================ */
fun applyDemo() {
    println("=== 8) apply ===")

    // apply returns the object itself, so it's perfect for configuration.
    val user = Lesson10User(name = "Unknown", age = 0).apply {
        name = "Munene"
        age = 24
    }

    println("Configured user = $user")

    val text = StringBuilder().apply {
        append("Hello")
        append(", ")
        append("Kotlin")
        append("!")
    }.toString()

    println("Built text = $text")
    println()
}

data class Lesson10User(var name: String, var age: Int)

/* ============================================================
   9) run — execute code block and return result
   ============================================================ */
fun runDemo() {
    println("=== 9) run ===")

    val user = Lesson10User(name = "Amina", age = 19)

    // run uses `this` and returns the lambda result.
    val label = user.run {
        val group = if (age >= 18) "adult" else "minor"
        "$name is an $group"
    }
    println(label)

    // There is also run { ... } without a receiver:
    val computed = run {
        val a = 10
        val b = 20
        a + b
    }
    println("computed via run { ... } = $computed")

    println()
}

/* ============================================================
   10) also — side effects (logging, metrics, debugging)
   ============================================================ */
fun alsoDemo() {
    println("=== 10) also ===")

    // also returns the object itself, like apply,
    // but it uses `it` (nice when you don't want to shadow `this`).
    val result = mutableListOf("a", "b", "c")
        .also { println("Before add: $it") }
        .also { it.add("d") }
        .also { println("After add:  $it") }

    println("result = $result")
    println()
}

/* ============================================================
   11) with — calling multiple methods on one object
   ============================================================ */
fun withDemo() {
    println("=== 11) with ===")

    val sb = StringBuilder()

    // with takes the object as an argument and uses `this` inside.
    val value = with(sb) {
        append("with(")
        append("StringBuilder")
        append(")")
        toString() // return value of lambda is the result
    }

    println("value = $value")
    println()
}

/* ============================================================
   WHEN TO USE WHICH SCOPE FUNCTION?
   ============================================================ */
/*
Use `let` when:
- You want a transformation (object -> new value)
- You want null-safe execution: something?.let { ... }

Use `apply` when:
- You want to configure an object and return the object
- Common with builders and UI configuration

Use `run` when:
- You want `this` inside the block and you want a computed result
- You want to create a small local scope: run { ... }

Use `also` when:
- You want to keep the chain but do a side effect (log, debug, metrics)

Use `with(obj)` when:
- You already have an object and want to call multiple methods on it
- You want a computed result from the block
*/

/* ============================================================
   MINI EXERCISE (Try it yourself)
   ============================================================ */
fun lesson10MiniExercise() {
    println("=== Mini exercise (try it) ===")
    println(
        """
        1) Write an extension: Int.isEven(): Boolean
           - Return true if the number is divisible by 2.

        2) Write an extension: String?.orUnknown(): String
           - Return "(unknown)" when null/blank, otherwise trimmed string.

        3) Using let:
           - Given val input: String? = " 42 "
           - Parse it safely to Int? (no !!) and square it if it is a valid number.

        4) Using apply:
           - Create a Lesson10User and configure it in one expression.

        5) Using also:
           - Build a list and log it before and after adding an item.
        """.trimIndent()
    )
    println()
}