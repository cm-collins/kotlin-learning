/**
 * LESSON 15: SETS + MAPS (IMMUTABLE VS MUTABLE)
 * ============================================================
 *
 * This lesson completes Stage 1.5 pending items:
 * - Sets (immutable and mutable)
 * - Maps (immutable and mutable)
 */

fun main() {
    lesson15Sets()
    lesson15Maps()
    lesson15MiniExercise()
}

/* ============================================================
   1) SETS
   ============================================================ */
// Beginner note:
// - A Set stores unique values (no duplicates).
// - Use a set when “membership” matters: “have I seen this before?” / “is this value allowed?”.
fun lesson15Sets() {
    println("=== Lesson 15.1) Sets ===")

    // Immutable set:
    val uniqueIds = setOf(1, 2, 2, 3, 3, 3)
    println("uniqueIds (duplicates removed) = $uniqueIds")

    println("contains(2) = ${uniqueIds.contains(2)}")
    println("size = ${uniqueIds.size}")

    // Mutable set:
    val tags = mutableSetOf("kotlin", "android")
    tags.add("kmp")
    tags.add("kotlin") // no change (already exists)
    println("tags = $tags")

    // Common set operations:
    val a = setOf(1, 2, 3)
    val b = setOf(3, 4, 5)
    println("a union b = ${a union b}")
    println("a intersect b = ${a intersect b}")
    println("a subtract b = ${a subtract b}")

    println()
}

/* ============================================================
   2) MAPS
   ============================================================ */
// Beginner note:
// - A Map stores key -> value pairs (like a dictionary).
// - Use a map when you need fast lookup by key (e.g., id -> user, code -> country).
fun lesson15Maps() {
    println("=== Lesson 15.2) Maps ===")

    // Immutable map:
    val countryCodes = mapOf(
        "KE" to "Kenya",
        "UG" to "Uganda",
        "TZ" to "Tanzania",
    )
    println("countryCodes = $countryCodes")
    println("KE -> ${countryCodes["KE"]}")
    println("XX -> ${countryCodes["XX"]}") // null if missing

    // getOrElse / getOrDefault:
    val safeName = countryCodes.getOrElse("XX") { "(unknown)" }
    println("getOrElse(XX) = $safeName")

    // Mutable map:
    val scores = mutableMapOf(
        "Alice" to 10,
        "Brian" to 7,
    )
    scores["Alice"] = 12 // update
    scores["Caro"] = 9 // add
    println("scores = $scores")

    // Iteration:
    for ((name, score) in scores) {
        println("$name -> $score")
    }

    println()
}

fun lesson15MiniExercise() {
    println("=== Lesson 15: Mini exercise (try it) ===")
    println(
        """
        1) Create a set of emails with duplicates and print the unique emails only.

        2) Create a map of productName -> price.
           - Print each entry as: "product: KES price"
           - Then compute and print the total cost of all products.
        """.trimIndent()
    )
    println()
}

