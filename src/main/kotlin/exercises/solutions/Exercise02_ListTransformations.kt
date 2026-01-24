/**
 * EXERCISE 2: LIST TRANSFORMATIONS - SOLUTION
 * ============================================================
 *
 * This is a reference solution.
 * Try solving the exercise first in:
 * - src/main/kotlin/exercises/Exercise02_ListTransformations.kt
 */

package exercises.solutions

fun main() {
    runExercise()
}

fun runExercise() {
    // 1) Create a MutableList of 5 names.
    val names = mutableListOf("Alice", "Brian", "Carol", "Daisy", "Eve")
    println("Step 1 - initial names: $names")

    // 2) Remove the 2nd name (index 1).
    val removed = names.removeAt(1)
    println("Step 2 - removed: $removed")
    println("Step 2 - names now: $names")

    // 3) Add a new name to the end.
    names.add("Frank")
    println("Step 3 - after adding 'Frank': $names")

    // 4) Create a NEW list of uppercase names using map.
    val uppercaseNames = names.map { it.uppercase() }
    println("Step 4 - uppercaseNames (new list): $uppercaseNames")

    // 5) Create a NEW list of names whose length is >= 5 using filter.
    val longNames = names.filter { it.length >= 5 }
    println("Step 5 - longNames (new list): $longNames")

    // Final note: names is still the original mutable list, uppercaseNames/longNames are derived lists.
    println("\nFinal summary:")
    println("Original mutable list: $names")
    println("Derived uppercase list: $uppercaseNames")
    println("Derived filtered list: $longNames")
}

