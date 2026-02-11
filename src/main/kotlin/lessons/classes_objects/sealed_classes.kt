/**
 * SEALED CLASSES (BEGINNER FRIENDLY)
 * ============================================================
 *
 * A sealed class represents a CLOSED set of possible types.
 *
 * Why it matters:
 * - Perfect for modeling "state" or "results" like:
 *   Success / Error / Loading / Empty
 * - Works amazingly with `when` because Kotlin can ensure you handled ALL cases.
 *
 * Key rule:
 * - All subclasses of a sealed class must be defined in the same file (or same module, depending on Kotlin version),
 *   so the compiler can know the complete set.
 *
 * Sealed class vs sealed interface:
 * - sealed class: can hold state + constructors, and you can inherit from only one class
 * - sealed interface: no constructor; a class can implement multiple interfaces
 */

fun main() {
    sealedClassBasicsDemo()
    exhaustiveWhenDemo()
    sealedInterfaceDemo()
    sealedMiniExercise()
}

/* ============================================================
   1) SEALED CLASS BASICS: MODELING RESULTS
   ============================================================ */
// Beginner note:
// - Instead of returning null or throwing exceptions, you can return a Result type:
//   Success(data) or Error(reason) or Empty.
fun sealedClassBasicsDemo() {
    println("=== Sealed class basics ===")

    val a: LessonSealedNetworkResult = LessonSealedNetworkResult.Success("Data A")
    val b: LessonSealedNetworkResult = LessonSealedNetworkResult.Error(Throwable("Error B"))
    val c: LessonSealedNetworkResult = LessonSealedNetworkResult.Empty

    println("a -> ${describe(a)}")
    println("b -> ${describe(b)}")
    println("c -> ${describe(c)}")

    println()
}

// Sealed class with 3 possible results:
sealed class LessonSealedNetworkResult {
    data class Success(val data: String) : LessonSealedNetworkResult()
    data class Error(val throwable: Throwable) : LessonSealedNetworkResult()

    // data object = singleton + nicer toString() than plain object
    data object Empty : LessonSealedNetworkResult()
}

fun describe(result: LessonSealedNetworkResult): String =
    when (result) {
        is LessonSealedNetworkResult.Success -> "Success(data='${result.data}')"
        is LessonSealedNetworkResult.Error -> "Error(message='${result.throwable.message}')"
        LessonSealedNetworkResult.Empty -> "Empty"
    }

/* ============================================================
   2) EXHAUSTIVE `when` (NO else NEEDED)
   ============================================================ */
// Beginner note:
// - With sealed types, if you cover all cases, you don't need an `else`.
// - If you later add a new case (e.g., Loading), the compiler forces you to update your when.
fun exhaustiveWhenDemo() {
    println("=== Exhaustive when demo ===")

    val result: LessonSealedNetworkResult = LessonSealedNetworkResult.Success("Hello")

    val uiText = when (result) {
        is LessonSealedNetworkResult.Success -> "Show: ${result.data}"
        is LessonSealedNetworkResult.Error -> "Show error: ${result.throwable.message}"
        LessonSealedNetworkResult.Empty -> "Show empty state"
    }

    println("uiText = $uiText")
    println()
}

/* ============================================================
   3) SEALED INTERFACE (ALTERNATIVE)
   ============================================================ */
// Beginner note:
// - A sealed interface is also a closed set of implementations.
// - Useful when you want classes to implement multiple interfaces.
fun sealedInterfaceDemo() {
    println("=== Sealed interface demo ===")

    val state: LessonSealedUiState = LessonSealedUiState.Loading
    val message = when (state) {
        LessonSealedUiState.Loading -> "Loading..."
        is LessonSealedUiState.Content -> "Content items=${state.items.size}"
        is LessonSealedUiState.Failure -> "Failure: ${state.message}"
    }

    println(message)
    println()
}

sealed interface LessonSealedUiState {
    data object Loading : LessonSealedUiState
    data class Content(val items: List<String>) : LessonSealedUiState
    data class Failure(val message: String) : LessonSealedUiState
}

/* ============================================================
   MINI EXERCISE
   ============================================================ */
fun sealedMiniExercise() {
    println("=== Mini exercise (try it) ===")
    println(
        """
        1) Create a sealed class PaymentResult with:
           - Success(receiptId: String)
           - Declined(reason: String)
           - NetworkError

        2) Write a function that takes PaymentResult and returns a user-friendly message using `when`.

        3) Add a new case (e.g., Pending) and see how Kotlin forces you to update the `when`.
        """.trimIndent()
    )
    println()
}