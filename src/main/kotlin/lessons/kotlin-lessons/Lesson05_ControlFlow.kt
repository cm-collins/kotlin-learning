/**
 * LESSON 5: CONTROL FLOW
 * ============================================================
 * 
 * Learn about conditional statements and control flow:
 * - if / else if / else
 * - when (as a statement + as an expression)
 * - while loops
 * - do-while loops
 * - break / continue
 */
fun main() {
    // ============================================================
    // Current focus: WHEN
    // ============================================================
    whenExamples()

    // Optional (interactive) — uncomment when you want to type input:
    interactiveWhenExample()

    // ============================================================
    // Other control-flow examples (available, but not the focus right now)
    // ============================================================
    ifConditionsExample()
    whileLoopsExample()
    interactiveWhileExample()
    guessTheNumber()
}

/* ============================================================
   WHEN (Kotlin’s powerful switch-like expression)
   ============================================================ */
fun whenExamples() {
    // 1) when with a value (similar to switch-case)
    val dayNumber = 3
    val dayName = when (dayNumber) {
        1 -> "Monday"
        2 -> "Tuesday"
        3 -> "Wednesday"
        4 -> "Thursday"
        5 -> "Friday"
        6, 7 -> "Weekend"
        else -> "Invalid day"
    }
    println("Day $dayNumber -> $dayName")

    // 2) when as an expression (returns a value)
    val statusCode = 404
    val message = when (statusCode) {
        200 -> "OK"
        201 -> "Created"
        400 -> "Bad Request"
        401, 403 -> "Unauthorized/Forbidden"
        404 -> "Not Found"
        in 500..599 -> "Server Error"
        else -> "Unknown"
    }
    println("HTTP $statusCode -> $message")

    // 3) when with ranges (great for grading / categories)
    val score = 86
    val grade = when (score) {
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        in 60..69 -> "D"
        in 0..59 -> "F"
        else -> "Invalid score"
    }
    println("Score $score -> Grade $grade")

    // 4) when without an argument (use boolean conditions)
    val temperature = 29
    val weather = when {
        temperature < 0 -> "Freezing"
        temperature in 0..15 -> "Cold"
        temperature in 16..25 -> "Warm"
        else -> "Hot"
    }
    println("Temp $temperature°C -> $weather")

    // 5) when with type checks (smart casts)
    val anyValue: Any = "Kotlin"
    val description = when (anyValue) {
        is String -> "String of length ${anyValue.length}"
        is Int -> "Int doubled = ${anyValue * 2}"
        else -> "Unknown type"
    }
    println("anyValue -> $description\n")
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

/* ============================================================
   OPTIONAL: INTERACTIVE WHEN EXAMPLE (USER INPUT)
   ============================================================ */
fun interactiveWhenExample() {
    println("=== Grade Calculator (when + ranges) ===")
    print("Enter your score (0-100): ")

    val input = readLine()?.trim()
    val score = input?.toIntOrNull()

    val grade = when {
        score == null -> "Invalid input (not a number)"
        score !in 0..100 -> "Invalid score (must be 0-100)"
        score in 90..100 -> "A"
        score in 80..89 -> "B"
        score in 70..79 -> "C"
        score in 60..69 -> "D"
        else -> "F"
    }

    println("Result: $grade")
}
