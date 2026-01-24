/**
 * EXERCISE 2: LIST TRANSFORMATIONS (List + MutableList)
 * ============================================================
 *
 * Goal:
 * Practice common list operations you’ll use in real apps: add/remove/update,
 * `map`, and `filter`.
 *
 * TASKS
 * 1) Create a MutableList of 5 names.
 * 2) Remove the 2nd name (index 1).
 * 3) Add a new name to the end.
 * 4) Create a NEW list of the names in uppercase using `map`.
 * 5) Create a NEW list of names whose length is >= 5 using `filter`.
 *
 * Requirements
 * - Use `mutableListOf(...)` for the original list.
 * - Use `removeAt(1)` to remove the 2nd item.
 * - Do NOT modify the original list when creating uppercase / filtered lists.
 *   (`map` and `filter` should return new lists.)
 *
 * Expected learning outcomes
 * - Understand the difference between the original mutable list vs derived lists.
 * - Understand that `map` transforms items, and `filter` selects items.
 *
 * How to run
 * - Implement `runExercise()` below
 * - Run this file (it has a `main()` function)
 *
 * Reference solution
 * - See: src/main/kotlin/exercises/solutions/Exercise02_ListTransformations.kt
 */

package exercises

fun main() {
    println("Exercise02: List Transformations")
    println("Implement runExercise() and run again.\n")

    // Uncomment after implementing:
    // runExercise()
}

/**
 * Implement the tasks from the header.
 *
 * Tip: Print intermediate results after each step so you can see what changed.
 */
fun runExercise() {
    // TODO 1: Create a MutableList of 5 names.
    // val names = mutableListOf("Alice", "Brian", "Carol", "Daisy", "Eve")

    // TODO 2: Remove the 2nd name (index 1).
    // names.removeAt(1)

    // TODO 3: Add a new name to the end.
    // names.add("Frank")

    // TODO 4: Create a NEW list of uppercase names using map.
    // val uppercaseNames = names.map { it.uppercase() }

    // TODO 5: Create a NEW list of names whose length is >= 5 using filter.
    // val longNames = names.filter { it.length >= 5 }

    // TODO: Print the results
    // println("Original names: $names")
    // println("Uppercase names: $uppercaseNames")
    // println("Names length >= 5: $longNames")
}

