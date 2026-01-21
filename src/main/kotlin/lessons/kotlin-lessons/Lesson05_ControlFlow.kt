/**
 * LESSON 5: CONTROL FLOW ============================================================
 *
 * Learn about conditional statements and loops:
 * - if / else if / else
 * - while loops
 * - do-while loops
 * - break / continue
 */
fun main() {
    // If statements (already covered earlier)
     ifConditionsExample()

    // While loops (current focus)
     whileLoopsExample()

    // Interactive example: while loop with user input
    interactiveWhileExample()

    //guess the number exxamle
    guessTheNumber()
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

/* ============================================================
INTERACTIVE EXAMPLE: USER INPUT WITH WHILE LOOP
============================================================ */
fun interactiveWhileExample() {
    println("=== Simple Calculator ===")
    println("Enter numbers to add them up.")
    println("Type 'done' when finished.\n")

    var total = 0.0
    var keepGoing = true

    while (keepGoing) {
        print("Enter a number (or 'done' to finish): ")
        val input = readLine()

        when {
            input == null || input.trim().isEmpty() -> {
                println("Please enter something!")
            }
            input.trim().lowercase() == "done" -> {
                keepGoing = false
                println("\n✅ Calculation finished!")
            }
            else -> {
                // Try to convert input to a number
                val number = input.toDoubleOrNull()
                if (number != null) {
                    total += number
                    println("   Added $number. Current total: $total")
                } else {
                    println("   ❌ '$input' is not a valid number. Try again.")
                }
            }
        }
    }

    println("Final total: $total")

    // Alternative example: Simple number guessing game (commented out)
    // guessTheNumber()
}

/* ============================================================
BONUS: NUMBER GUESSING GAME
============================================================ */
fun guessTheNumber() {
    println("\n=== Guess the Number Game ===")
    println("I'm thinking of a number between 1 and 10.")

    val secretNumber = (1..10).random() // Random number between 1 and 10
    var attempts = 0
    var guessed = false

    while (!guessed) {
        print("Your guess: ")
        val input = readLine()
        val guess = input?.toIntOrNull()

        if (guess == null) {
            println("Please enter a valid number!")
            continue
        }

        attempts++

        when {
            guess < secretNumber -> println("Too low! Try again.")
            guess > secretNumber -> println("Too high! Try again.")
            else -> {
                guessed = true
                println("🎉 Correct! You guessed it in $attempts attempts!")
            }
        }
    }
}
