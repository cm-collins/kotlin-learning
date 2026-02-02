/**
 * LESSON 11: TYPE CONVERSION + STRINGS (TEMPLATES, OPS, FORMATTING)
 * ============================================================
 *
 * This lesson completes Stage 1.1 pending items:
 * - Type conversion and casting
 * - String templates and manipulation
 * - String formatting and common operations
 *
 * Important Kotlin rule:
 * - Kotlin does NOT do implicit numeric widening.
 *   Example: Int is NOT automatically a Long. You must convert explicitly.
 */
import java.util.Locale

fun main() {
    lesson11NumericConversions()
    lesson11ParsingStringsToNumbers()
    lesson11TypeChecksAndCasts()
    lesson11StringTemplatesAndCommonOps()
    lesson11StringFormatting()
    lesson11MiniExercise()
}

/* ============================================================
   1) TYPE CONVERSION (NUMBERS)
   ============================================================ */
// Beginner note:
// - Kotlin avoids “surprise conversions”. It won’t silently convert Int -> Long, etc.
// - Use explicit conversions like toLong(), toDouble(), toString().
fun lesson11NumericConversions() {
    println("=== Lesson 11.1) Numeric conversions ===")

    val i: Int = 42
    val l: Long = i.toLong() // explicit conversion required
    val d: Double = i.toDouble()
    val s: String = i.toString()

    println("Int i = $i")
    println("Long l = $l")
    println("Double d = $d")
    println("String s = $s")

    // Beware of precision loss when converting:
    val big = 9_999_999_999L
    val bigAsInt = big.toInt() // overflow (wrap-around) possible
    println("Long big = $big -> toInt() = $bigAsInt (overflow example)")

    println()
}

/* ============================================================
   2) PARSING STRINGS SAFELY
   ============================================================ */
// Beginner note:
// - Converting text to numbers is common with user input and APIs.
// - Prefer toIntOrNull() / toDoubleOrNull() so you don’t crash on invalid input.
// - Combine with `?:` (Elvis) to provide a default.
fun lesson11ParsingStringsToNumbers() {
    println("=== Lesson 11.2) Parsing strings safely ===")

    val good = "123"
    val bad = "12x3"
    val spaced = "  77  "

    // Unsafe parsing (throws NumberFormatException if invalid):
    val n1 = good.toInt()
    println("good.toInt() = $n1")

    // Safe parsing returns null if invalid:
    val n2 = bad.toIntOrNull()
    println("bad.toIntOrNull() = $n2")

    // Combine trim() + toIntOrNull() for user input:
    val n3 = spaced.trim().toIntOrNull()
    println("spaced.trim().toIntOrNull() = $n3")

    // Elvis operator to provide a default:
    val safeValue = bad.toIntOrNull() ?: 0
    println("bad parsed with default = $safeValue")

    println()
}

/* ============================================================
   3) TYPE CHECKS + CASTING
   ============================================================ */
// Beginner note:
// - `is` checks the type and enables smart cast (Kotlin treats it as that type in the block).
// - `as` is an unsafe cast (can throw). `as?` is a safe cast (returns null if wrong type).
fun lesson11TypeChecksAndCasts() {
    println("=== Lesson 11.3) Type checks + casts ===")

    val value: Any = "Kotlin"

    // is-check + smart cast:
    if (value is String) {
        // inside this block, value is automatically treated as String
        println("value is String of length ${value.length}")
    }

    // Explicit cast (throws if wrong type):
    val asString: String = value as String
    println("value as String = '$asString'")

    // Safe cast (returns null if wrong type):
    val maybeInt: Int? = value as? Int
    println("value as? Int = $maybeInt")

    println()
}

/* ============================================================
   4) STRING TEMPLATES + COMMON OPERATIONS
   ============================================================ */
// Beginner note:
// - Kotlin string templates: "$name" and "${expression}" are the most common way to build strings.
// - Learn these string ops early: trim, uppercase/lowercase, contains, replace, split, substringAfter/Before.
fun lesson11StringTemplatesAndCommonOps() {
    println("=== Lesson 11.4) String templates + common ops ===")

    val name = "Munene"
    val age = 24

    // String templates:
    println("Hello, $name! You are $age years old.")
    println("Next year you'll be ${age + 1}.")

    // Common ops:
    val raw = "   Kotlin is Fun   "
    println("raw = '$raw'")
    println("trim() = '${raw.trim()}'")
    println("uppercase() = '${raw.trim().uppercase()}'")
    println("lowercase() = '${raw.trim().lowercase()}'")
    println("startsWith(\"K\") = ${raw.trim().startsWith("K")}")
    println("contains(\"Fun\") = ${raw.contains("Fun")}")

    val replaced = raw.trim().replace("Fun", "Powerful")
    println("replace(...) = '$replaced'")

    // substring / substringAfter / substringBefore are very useful:
    val email = "munene@example.com"
    println("email domain = ${email.substringAfter("@")}")
    println("email name = ${email.substringBefore("@")}")

    // split:
    val words = raw.trim().split(" ")
    println("split(\" \") -> $words")

    // Raw strings (triple quotes) for multiline text:
    val multiLine = """
        Dear $name,
        Welcome to Kotlin.
        Your age next year: ${age + 1}
    """.trimIndent()
    println(multiLine)

    println()
}

/* ============================================================
   5) STRING FORMATTING
   ============================================================ */
// Beginner note:
// - Use formatting when you need “fixed” output like money or padding (e.g. 12.5 -> 12.50).
// - String.format(...) (Java-style) and "%05d".format(...) are both common.
fun lesson11StringFormatting() {
    println("=== Lesson 11.5) String formatting ===")

    val price = 12.5
    val quantity = 3
    val total = price * quantity

    // Kotlin's format extension delegates to Java's String.format:
    // Use Locale to avoid comma vs dot differences in different environments.
    val formatted = String.format(Locale.US, "Total: $%.2f (%d items)", total, quantity)
    println(formatted)

    // You can also do:
    val paddedNumber = "%05d".format(42) // 00042
    println("paddedNumber = $paddedNumber")

    // Another useful pattern:
    val percent = 0.87321
    println("As percent = ${String.format(Locale.US, "%.1f%%", percent * 100)}")

    println()
}

/* ============================================================
   MINI EXERCISE (Try it yourself)
   ============================================================ */
fun lesson11MiniExercise() {
    println("=== Lesson 11: Mini exercise (try it) ===")
    println(
        """
        1) Given val input = " 100 "
           - Parse it safely to Int? and print: "square = 10000" if valid.

        2) Given val any: Any = 123
           - Use is-checks to print whether it's Int/String/other.

        3) Given val filename = "photo.profile.jpg"
           - Print the extension using substringAfterLast(".")

        4) Format a Double money value to 2 decimals (e.g. 12.5 -> 12.50)
        """.trimIndent()
    )
    println()
}

