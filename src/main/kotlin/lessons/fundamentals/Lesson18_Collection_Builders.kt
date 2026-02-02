/**
 * LESSON 18: COLLECTION BUILDERS
 * ============================================================
 *
 * This lesson completes Stage 1.5 pending item:
 * - Collection builders
 *
 * Builders help you create *immutable* collections using a mutable builder block.
 * Common builders:
 * - buildList { ... }
 * - buildSet { ... }
 * - buildMap { ... }
 */

fun main() {
    lesson18BuildList()
    lesson18BuildSet()
    lesson18BuildMap()
    lesson18MiniExercise()
}

fun lesson18BuildList() {
    println("=== Lesson 18.1) buildList ===")

    // Beginner note:
    // - Builders let you “build” using mutable operations, but the final result is immutable.
    // - This is a nice pattern: safe output (immutable) + convenient creation (mutable block).

    val list = buildList {
        add("kotlin")
        add("android")
        add("compose")
    }

    println("list (immutable) = $list")
    println()
}

fun lesson18BuildSet() {
    println("=== Lesson 18.2) buildSet ===")

    // Beginner note:
    // - buildSet is like buildList, but it guarantees uniqueness (no duplicates).

    val set = buildSet {
        add("kotlin")
        add("kotlin") // duplicates ignored
        add("kmp")
    }

    println("set (immutable) = $set")
    println()
}

fun lesson18BuildMap() {
    println("=== Lesson 18.3) buildMap ===")

    // Beginner note:
    // - buildMap helps you construct a Map in a clean way (put(...) inside the block).

    val map = buildMap {
        put("KE", "Kenya")
        put("UG", "Uganda")
        put("TZ", "Tanzania")
    }

    println("map (immutable) = $map")
    println()
}

fun lesson18MiniExercise() {
    println("=== Lesson 18: Mini exercise (try it) ===")
    println(
        """
        1) Use buildList to generate the squares of numbers 1..10.

        2) Use buildMap to create a map of monthNumber -> monthName for 1..3.

        3) Why use builders?
           - You can build using mutable operations, but return an immutable collection.
        """.trimIndent()
    )
    println()
}

