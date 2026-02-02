/**
 * LESSON 17: SEQUENCES (LAZY EVALUATION)
 * ============================================================
 *
 * This lesson completes Stage 1.5 pending item:
 * - Sequences for lazy evaluation
 *
 * Key idea:
 * - List operations (map/filter) are eager: they create intermediate lists.
 * - Sequence operations are lazy: they do work element-by-element as needed.
 * - You usually finish a sequence chain with a terminal op like toList(), first(), count().
 */

fun main() {
    lesson17EagerVsLazy()
    lesson17MiniExercise()
}

fun lesson17EagerVsLazy() {
    println("=== Lesson 17.1) Eager vs Lazy ===")

    // Beginner note:
    // - “Eager” means: do all operations immediately, building intermediate lists.
    // - “Lazy” means: do work only when needed, element-by-element.
    // - Sequences are most helpful when data is large or you only need a few results (take/first).

    val nums = (1..10).toList()

    println("EAGER (List):")
    val eager = nums
        .map {
            println("map: $it")
            it * 2
        }
        .filter {
            println("filter: $it")
            it % 3 == 0
        }
        .take(2)

    println("eager result = $eager")
    println()

    println("LAZY (Sequence):")
    val lazy = nums
        .asSequence()
        .map {
            println("map: $it")
            it * 2
        }
        .filter {
            println("filter: $it")
            it % 3 == 0
        }
        .take(2)
        .toList() // terminal op triggers evaluation

    println("lazy result = $lazy")
    println()
}

fun lesson17MiniExercise() {
    println("=== Lesson 17: Mini exercise (try it) ===")
    println(
        """
        1) Create a list of numbers 1..1000.
           - Use a sequence to map, filter, take(5) and convert toList().
           - Add println() inside map/filter to observe laziness.

        2) When would you prefer sequences?
           - Very large collections
           - Long chains of operations
           - When you only need a few results (take/first)
        """.trimIndent()
    )
    println()
}

