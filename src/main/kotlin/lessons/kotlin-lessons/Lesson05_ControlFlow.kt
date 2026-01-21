/**
 * LESSON 5: CONTROL FLOW ============================================================
 *
 * Learn about conditional statements:
 * - if / else if / else
 * - while loops
 * - do-while loops
 * - break / continue
 */
fun main() {
    // If statements (already covered earlier)
    // ifConditionsExample()

    // While loops (current focus)
    whileLoopsExample()
}

/* ============================================================
IF CONDITIONS
============================================================ */
fun ifConditionsExample() {
    val x = 7
    val y = 7

    if (x < y) {
        println("$x is less than $y")
    } else if (x > y || x * y == 49) {
        println("At least one condition is true (x > y OR x*y == 49)")
    } else {
        println("$x is equal to $y")
    }

    println("This line always runs\n")
}
/* ============================================================
WHILE LOOPS
============================================================ */
fun whileLoopsExample() {
    // 1) Basic while loop (runs while condition is true)
    var count = 1
    while (count <= 3) {
        println("count = $count")
        count++ // IMPORTANT: update the loop variable to avoid infinite loops (count++ or count--)
    }

    // 2) while loop with a condition that starts false (loop runs 0 times)
    var start = 5
    while (start < 3) {
        // This will not run because start < 3 is false
        println("This will not print")
        start++
    }
    println("while with false condition ran 0 times (as expected)\n")

    // 3) do-while loop (runs at least once)
    var value = 5
    do {
        println("do-while runs at least once. value = $value")
        value++
    } while (value < 3)
    println()

    // 4) break and continue
    println("break/continue example:")
    var n = 0
    while (n < 10) {
        n++
        if (n == 3) continue // skip 3
        if (n == 7) break // stop at 7
        print("$n ")
    }
    println("\n")

    // 5) A small practical example: sum numbers until a threshold
    val numbers = intArrayOf(2, 4, 6, 8, 10)
    var index = 0
    var sum = 0

    while (index < numbers.size && sum < 15) {
        sum += numbers[index]
        index++
    }

    println("Sum after while loop = $sum (stopped when sum >= 15 or array ended)")
}
