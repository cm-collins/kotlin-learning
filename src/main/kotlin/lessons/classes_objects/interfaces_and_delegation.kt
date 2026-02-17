/**
 * INTERFACES + DEFAULT IMPLEMENTATIONS + MULTIPLE INTERFACES + DELEGATION (`by`)
 * =============================================================================
 *
 * Beginner-friendly goals:
 * - Understand what an interface is (a contract / capability)
 * - Learn that interfaces can contain:
 *   - abstract functions/properties (must be implemented)
 *   - default method bodies (optional to override)
 * - See how a class can implement MULTIPLE interfaces
 * - Learn how Kotlin delegation (`by`) forwards work to another object
 *
 * Think of it this way:
 * - Abstract class: "is-a base type with shared state/behavior" (single inheritance)
 * - Interface: "can-do capability" (multiple inheritance of behavior/contracts)
 */

fun main() {
    interfaceBasicsDemo()
    interfaceDefaultImplDemo()
    multipleInterfacesDemo()
    delegationByDemo()
    lessonInterfacesMiniExercise()
}

/* ============================================================
   1) INTERFACE BASICS
   ============================================================ */
// Beginner note:
// - An interface describes WHAT something can do.
// - It does not usually hold state (it can declare properties, but not backing fields).
// - A class "implements" an interface using `: InterfaceName`.
private fun interfaceBasicsDemo() {
    println("=== Interface basics ===")

    val printer: LessonPrintable = LessonConsolePrinter(prefix = "[INFO]")
    printer.printLine("Hello interfaces")

    // Polymorphism:
    // We can treat different implementations the same way through the interface type.
    val loud: LessonPrintable = LessonLoudPrinter()
    loud.printLine("same contract, different behavior")

    println()
}

private interface LessonPrintable {
    fun printLine(message: String)
}

private class LessonConsolePrinter(
    private val prefix: String
) : LessonPrintable {
    override fun printLine(message: String) {
        println("$prefix $message")
    }
}

private class LessonLoudPrinter : LessonPrintable {
    override fun printLine(message: String) {
        println(message.uppercase())
    }
}

/* ============================================================
   2) DEFAULT IMPLEMENTATIONS IN INTERFACES
   ============================================================ */
// Beginner note:
// - Interfaces can provide default method bodies.
// - A class may choose to override them, but it doesn't have to.
// - Interfaces can also declare properties (like `val name: String`).
//   Those properties are abstract unless they provide a custom getter.
private fun interfaceDefaultImplDemo() {
    println("=== Interface default implementations ===")

    val repo = LessonInMemoryUserRepo()
    repo.addUser("Asha")
    repo.addUser("Brian")
    println("count = ${repo.count()}") // default implementation
    println("exists(Asha) = ${repo.exists("Asha")}") // default implementation

    println()
}

private interface LessonUserRepository {
    // Abstract function: implementers must provide it.
    fun allUsers(): List<String>

    // Default implementation using the abstract function above.
    fun count(): Int = allUsers().size

    // Another default method.
    fun exists(name: String): Boolean = allUsers().any { it == name }
}

private class LessonInMemoryUserRepo : LessonUserRepository {
    private val users = mutableListOf<String>()

    fun addUser(name: String) {
        users.add(name)
    }

    override fun allUsers(): List<String> = users
}

/* ============================================================
   3) MULTIPLE INTERFACE IMPLEMENTATION
   ============================================================ */
// Beginner note:
// - Kotlin allows implementing multiple interfaces:
//   class X : InterfaceA, InterfaceB
// - If two interfaces contain a function with the same signature AND both provide
//   a default implementation, you MUST resolve the conflict by overriding it.
private fun multipleInterfacesDemo() {
    println("=== Multiple interfaces ===")

    val smart = LessonSmartDevice(id = "dev-01")
    smart.turnOn()
    smart.connect()
    smart.status() // conflict resolved

    println()
}

private interface LessonPowerable {
    fun turnOn()
    fun turnOff()

    fun status() {
        println("Powerable: status ok")
    }
}

private interface LessonConnectable {
    fun connect()
    fun disconnect()

    fun status() {
        println("Connectable: status ok")
    }
}

private class LessonSmartDevice(
    private val id: String
) : LessonPowerable, LessonConnectable {

    override fun turnOn() {
        println("Device $id turned on")
    }

    override fun turnOff() {
        println("Device $id turned off")
    }

    override fun connect() {
        println("Device $id connected")
    }

    override fun disconnect() {
        println("Device $id disconnected")
    }

    // Conflict resolution: both interfaces define `status()` with a body.
    override fun status() {
        // You can call each default implementation explicitly:
        super<LessonPowerable>.status()
        super<LessonConnectable>.status()
        println("SmartDevice: combined status ok")
    }
}

/* ============================================================
   4) DELEGATION PATTERN (`by` KEYWORD)
   ============================================================ */
// Beginner note:
// - Delegation is composition with less boilerplate.
// - Instead of writing "forwarding" methods yourself, Kotlin can do it:
//   class X(dep: Interface) : Interface by dep
//
// Why it's useful:
// - It keeps classes small and focused.
// - It avoids inheritance when you just want to reuse behavior.
// - It makes testing easier (swap the delegate with a fake).
private fun delegationByDemo() {
    println("=== Delegation with `by` ===")

    val baseLogger = LessonConsoleLogger(tag = "Auth")
    val logger: LessonLogger = LessonTimestampLogger(delegate = baseLogger)

    logger.log("User signed in")
    logger.log("Token refreshed")

    println()
}

private interface LessonLogger {
    fun log(message: String)
}

private class LessonConsoleLogger(
    private val tag: String
) : LessonLogger {
    override fun log(message: String) {
        println("[$tag] $message")
    }
}

// This class *implements* LessonLogger by delegating to another LessonLogger.
// We can also override some methods to customize behavior.
private class LessonTimestampLogger(
    private val delegate: LessonLogger
) : LessonLogger by delegate {

    override fun log(message: String) {
        val timestamp = System.currentTimeMillis()
        delegate.log("$timestamp: $message")
    }
}

/* ============================================================
   MINI EXERCISE
   ============================================================ */
private fun lessonInterfacesMiniExercise() {
    println("=== Mini exercise (try it) ===")
    println(
        """
        1) Create an interface AuthProvider with:
           - fun signIn(username: String, password: String): Boolean
           - a default method fun printAttempt(username: String) { ... }

        2) Create two implementations:
           - FakeAuthProvider (always returns true for a certain username/password)
           - AlwaysFailAuthProvider (always returns false)

        3) Create a class LoggingAuthProvider(delegate: AuthProvider) that uses delegation:
           class LoggingAuthProvider(...) : AuthProvider by delegate
           - override signIn(...) to log before/after calling delegate.signIn(...)
        """.trimIndent()
    )
    println()
}

