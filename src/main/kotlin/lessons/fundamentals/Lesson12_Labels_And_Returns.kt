/**
 * LESSON 12: BREAK/CONTINUE, LABELS, AND RETURNS (ADVANCED CONTROL FLOW)
 * ============================================================
 *
 * This lesson completes Stage 1.2 pending item:
 * - Labels and returns
 *
 * Note:
 * - Break/continue basics already exist in `Lesson05_ControlFlow.kt`.
 * - Here we focus on labeled break/continue and how return works in lambdas.
 */

fun main() {
    lesson12LabeledBreakAndContinue()
    lesson12ReturnsInLambdas()
    lesson12MiniExercise()
}

/* ============================================================
   1) LABELED break / continue (nested loops)
   ============================================================ */
// Beginner note:
// - `break` normally exits only the *nearest* loop.
// - Labels let you control *which* loop you break/continue in nested loops.
// - You write a label like: outer@ for (...) { ... } and then use break@outer / continue@outer.
fun lesson12LabeledBreakAndContinue() {
    println("=== Lesson 12.1) Labeled break/continue ===")

    val grid = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
    )

    val target = 5
    var foundRow = -1
    var foundCol = -1

    // Without labels, `break` only exits the inner loop.
    // With a label, you can break out of the outer loop as well.
    search@ for (r in grid.indices) {
        for (c in grid[r].indices) {
            if (grid[r][c] == target) {
                foundRow = r
                foundCol = c
                break@search
            }
        }
    }

    println("Target $target found at row=$foundRow, col=$foundCol")

    // Labeled continue (skip to next outer iteration)
    println("Scanning grid but skipping row 1 entirely:")
    rowLoop@ for (r in grid.indices) {
        if (r == 1) continue@rowLoop
        for (c in grid[r].indices) {
            print("${grid[r][c]} ")
        }
        println()
    }

    println()
}

/* ============================================================
   2) RETURNS IN LAMBDAS: return vs return@label
   ============================================================ */
// Beginner note:
// - In lambdas (like forEach { ... }), you often want to “skip this iteration”.
// - `return@forEach` is a *local return*: it returns from the lambda, not from the outer function.
// - This is very common when filtering/validating inside forEach/map/let.
fun lesson12ReturnsInLambdas() {
    println("=== Lesson 12.2) Returns in lambdas ===")

    val items = listOf("a", "", "b", "  ", "c")

    // In a lambda, `return` is tricky:
    // - In many cases, you want a *local* return (skip current lambda iteration)
    // - Use return@forEach (or return@label) for that.
    println("Printing only non-blank items:")
    items.forEach { item ->
        if (item.isBlank()) return@forEach
        println("item='$item'")
    }

    // Another common pattern: label a lambda yourself
    println("Using a custom label inside a lambda:")
    items.forEach label@{ item ->
        if (item.isBlank()) return@label
        println("ok='$item'")
    }

    println()
}

/* ============================================================
   MINI EXERCISE (Try it yourself)
   ============================================================ */
fun lesson12MiniExercise() {
    println("=== Lesson 12: Mini exercise (try it) ===")
    println(
        """
        1) Given a 2D grid (array of int arrays), search for a target number.
           - Use a labeled break to exit both loops when found.

        2) Given a list of strings, print only strings with length >= 3.
           - Use forEach + return@forEach to skip short strings.
        """.trimIndent()
    )
    println()
}

