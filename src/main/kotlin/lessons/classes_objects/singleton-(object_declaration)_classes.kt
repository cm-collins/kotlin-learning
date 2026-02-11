import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

/**
 * SINGLETONS IN KOTLIN: `object` DECLARATIONS
 * ============================================================
 *
 * Kotlin has a special keyword: `object`.
 *
 * There are 4 related concepts worth understanding:
 *
 * 1) Object declaration (singleton)
 *    - `object DateUtil { ... }`
 *    - Creates EXACTLY ONE instance for the whole program.
 *    - You access it by name: `DateUtil.format(...)`
 *
 * 2) Data object (singleton + nicer generated functions)
 *    - `data object DateUtil2 { ... }`
 *    - Still ONE instance, but Kotlin generates a better `toString()`.
 *    - (You mainly see this with sealed hierarchies, as a singleton "case".)
 *
 * 3) Object expression (anonymous object)
 *    - `val x = object : SomeInterface { ... }`
 *    - Creates an anonymous one-off object (often used for callbacks / adapters).
 *
 * 4) Companion object (static-like members inside a class)
 *    - `class User { companion object { ... } }`
 *    - One companion per class; used for factories/constants.
 *
 * When should you use an object declaration?
 * - Stateless utilities (formatting/parsing, pure helper functions)
 * - Grouping constants
 *
 * When should you be careful?
 * - Global mutable state in a singleton can make code harder to test and reason about.
 *
 * Important behavior:
 * - Object declarations are initialized lazily (first time you access them),
 *   and initialization is thread-safe.
 * - An object declaration cannot have constructor parameters.
 */

fun main() {
    objectDeclarationBasicsDemo()
    dataObjectDemo()
    objectExpressionDemo()
    companionObjectDemo()
}

/* ============================================================
   1) OBJECT DECLARATION (SINGLETON) BASICS
   ============================================================ */
// Beginner note:
// - Think of this as a “single shared utility instance”.
// - You don't create it with SessionStorage(...). You just use `DateUtil` directly.
fun objectDeclarationBasicsDemo() {
    println("=== object declaration basics ===")

    val now = ZonedDateTime.now()
    println("Default format: ${DateUtil.format(now)}")
    println("Custom pattern: ${DateUtil.format(now, pattern = "yyyy/MM/dd")} ")

    val instant = Instant.now()
    println("Instant -> Nairobi time: ${DateUtil.format(instant, zoneId = ZoneId.of("Africa/Nairobi"))}")

    println()
}

object DateUtil {
    private val defaultFormatter: DateTimeFormatter =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm z")

    fun format(dateTime: ZonedDateTime, pattern: String? = null): String {
        val formatter = if (pattern == null) defaultFormatter else DateTimeFormatter.ofPattern(pattern)
        return dateTime.format(formatter)
    }

    fun format(instant: Instant, zoneId: ZoneId = ZoneId.systemDefault()): String {
        return format(ZonedDateTime.ofInstant(instant, zoneId))
    }
}

/* ============================================================
   2) `data object` (SINGLETON WITH GENERATED toString)
   ============================================================ */
// Beginner note:
// - `data object` is still a singleton.
// - A normal `object` prints like: DateUtil@5f184fc6 (not very helpful).
// - A `data object` prints a stable name like: DateUtil2 (nicer for debugging/logging).
fun dataObjectDemo() {
    println("=== data object demo ===")

    val now = ZonedDateTime.now()
    println("DateUtil2.format(now) = ${DateUtil2.format(now)}")
    println("DateUtil2.toString()  = $DateUtil2")

    println()
}

data object DateUtil2 {
    fun format(dateTime: ZonedDateTime): String {
        return "Year=${dateTime.year}, Month=${dateTime.monthValue}, Day=${dateTime.dayOfMonth}"
    }
}

/* ============================================================
   3) OBJECT EXPRESSION (ANONYMOUS OBJECT)
   ============================================================ */
// Beginner note:
// - Use this when you need a small interface/class implementation “right here”.
fun objectExpressionDemo() {
    println("=== object expression demo ===")

    val runnable = object : Runnable {
        override fun run() {
            println("Running from an anonymous object")
        }
    }

    runnable.run()
    println()
}

/* ============================================================
   4) COMPANION OBJECT (STATIC-LIKE MEMBERS)
   ============================================================ */
// Beginner note:
// - Companion object is attached to a class, not the whole program.
// - Common uses: factories, constants, parsing/validation helpers.
fun companionObjectDemo() {
    println("=== companion object demo ===")

    val guest = SingletonUser.guest()
    val named = SingletonUser.fromName("Amina")
    println("guest = $guest")
    println("named = $named")
    println("MIN_USERNAME_LEN = ${SingletonUser.MIN_USERNAME_LEN}")

    println()
}

data class SingletonUser(val name: String) {
    companion object {
        const val MIN_USERNAME_LEN: Int = 3

        fun guest(): SingletonUser = SingletonUser(name = "Guest")

        fun fromName(name: String): SingletonUser {
            require(name.length >= MIN_USERNAME_LEN) {
                "name must be at least $MIN_USERNAME_LEN characters"
            }
            return SingletonUser(name)
        }
    }
}
