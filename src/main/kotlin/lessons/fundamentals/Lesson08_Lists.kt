/**
 * LESSON 8: LISTS
 * ============================================================
 *
 * Lists are one of the most common collection types in Kotlin.
 *
 * Kotlin has two main “flavors” of lists:
 * 1) List<T>         (read-only view)      -> created with listOf(...)
 * 2) MutableList<T>  (modifiable list)     -> created with mutableListOf(...)
 *
 * Important notes:
 * - `List` is read-only: you can read items, iterate, and use operations like map/filter,
 *   but you cannot add/remove elements through that reference.
 * - `MutableList` lets you add/remove/update elements.
 *
 * Lists vs Arrays (quick rule):
 * - Use List/MutableList for most everyday work (it’s the Kotlin default choice).
 * - Use Array when you need fixed-size storage or interop with Java APIs.
 */

fun main() {
    listsBasicsExample()
    listOperationsExample()
    backendDataMapExample()

    // Optional (interactive) example — uncomment when you want to practice input:
    // interactiveListExample()
}

/* ============================================================
   LIST BASICS (List vs MutableList)
   ============================================================ */
// Beginner note:
// - `List<T>` is read-only (you can read/iterate, but not add/remove through that reference).
// - `MutableList<T>` lets you add/remove/update elements.
// - Use `getOrNull(index)` when you’re not sure the index exists (prevents crashes).
fun listsBasicsExample() {
    // 1) Read-only list
    val fruits: List<String> = listOf("apple", "banana", "mango")
    println("Fruits (List): $fruits")
    println("First fruit: ${fruits[0]}")
    println("Size: ${fruits.size}")

    // fruits.add("orange") // ❌ won't compile: List is read-only

    // 2) Mutable list (can add/remove/update)
    val numbers: MutableList<Int> = mutableListOf(1, 2, 3)
    println("\nNumbers (MutableList): $numbers")

    numbers.add(4)
    numbers.removeAt(0) // removes the first element
    numbers[0] = 99     // update by index
    println("After add/remove/update: $numbers")

    // 3) Safe access to avoid IndexOutOfBoundsException
    val maybeValue = numbers.getOrNull(10)
    println("getOrNull(10): $maybeValue")

    // 4) Iteration
    println("\nIterate with forEachIndexed:")
    fruits.forEachIndexed { index, value ->
        println("Index $index -> $value")
    }
}

/* ============================================================
   COMMON LIST OPERATIONS (map / filter / etc.)
   ============================================================ */
// Beginner note:
// - Most collection operations return a NEW list (they don’t modify the original).
// - map = transform each element, filter = keep elements that match a condition.
fun listOperationsExample() {
    val values = listOf(1, 2, 3, 4, 5, 6)
    println("\nValues: $values")

    // map: transform each element (returns a NEW list)
    val doubled = values.map { it * 2 }
    println("Doubled (map): $doubled")

    // filter: keep only elements that match a condition (returns a NEW list)
    val evens = values.filter { it % 2 == 0 }
    println("Evens (filter): $evens")

    // any / all / count
    println("Any > 5? ${values.any { it > 5 }}")
    println("All > 0? ${values.all { it > 0 }}")
    println("Count even: ${values.count { it % 2 == 0 }}")

    // sum / maxOrNull / minOrNull
    println("Sum: ${values.sum()}")
    println("Max: ${values.maxOrNull()}")
    println("Min: ${values.minOrNull()}")

    // distinct / sorted
    val messy = listOf(3, 1, 2, 2, 3, 5)
    println("\nMessy: $messy")
    println("Distinct: ${messy.distinct()}")
    println("Sorted: ${messy.sorted()}")
}

/* ============================================================
   REAL-WORLD EXAMPLE: MAPPING BACKEND DATA (DTO -> UI/Domain)
   ============================================================ */
// Beginner note:
// - In real apps, you often transform network data (DTOs) into models used by your UI/domain layer.
// - This keeps your UI code clean and protects the rest of your app from API changes.
data class ApiUserDto(
    val id: String,
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val isActive: Boolean
)

data class User(
    val id: String,
    val displayName: String,
    val email: String
)

fun backendDataMapExample() {
    println("\n=== Real-world: map backend DTOs to app models ===")

    // Imagine this is the response we got from a backend API:
    val apiResponse: List<ApiUserDto> = listOf(
        ApiUserDto(id = "u1", firstName = "Alice", lastName = "Kamau", email = "alice@example.com", isActive = true),
        ApiUserDto(id = "u2", firstName = "Brian", lastName = null, email = "brian@example.com", isActive = true),
        ApiUserDto(id = "u3", firstName = null, lastName = "Otieno", email = "otieno@example.com", isActive = false),
        ApiUserDto(id = "u4", firstName = "Daisy", lastName = "Mwangi", email = null, isActive = true) // invalid (missing email)
    )

    println("Raw API response count: ${apiResponse.size}")

    // Step 1: Filter out users we can't use in the UI (inactive or missing email)
    val validDtos = apiResponse
        .filter { it.isActive }
        .filter { !it.email.isNullOrBlank() }

    // Step 2: Map DTOs into a clean app model (Domain/UI model)
    val users: List<User> = validDtos.map { dto ->
        val first = dto.firstName?.trim().orEmpty()
        val last = dto.lastName?.trim().orEmpty()

        val displayName = listOf(first, last)
            .filter { it.isNotBlank() }
            .joinToString(separator = " ")
            .ifBlank { "Unknown User" }

        User(
            id = dto.id,
            displayName = displayName,
            email = dto.email!!.trim() // safe because we filtered out null/blank email above
        )
    }

    println("Mapped users (ready for UI):")
    users.forEach { println(" - ${it.displayName} <${it.email}> (id=${it.id})") }

    // Common follow-ups:
    // - Extract just the emails:
    val emails = users.map { it.email }
    println("Emails: $emails")

    // - Build a lookup map by id (often useful in apps):
    val usersById: Map<String, User> = users.associateBy { it.id }
    println("User lookup (u2): ${usersById["u2"]}")
}

/* ============================================================
   OPTIONAL: INTERACTIVE EXAMPLE (USER INPUT + MutableList)
   ============================================================ */
fun interactiveListExample() {
    println("\n=== Interactive List Example ===")
    println("Enter integers. Type 'done' to stop.")

    val inputs = mutableListOf<Int>()

    while (true) {
        print("Enter a number (or 'done'): ")
        val line = readLine()?.trim()

        if (line.isNullOrEmpty()) {
            println("Please enter something.")
            continue
        }

        if (line.equals("done", ignoreCase = true)) {
            break
        }

        val value = line.toIntOrNull()
        if (value == null) {
            println("Not a valid integer: '$line'")
            continue
        }

        inputs.add(value)
        println("Current list: $inputs")
    }

    println("\nFinal list: $inputs")
    println("Count: ${inputs.size}")
    println("Sum: ${inputs.sum()}")
    println("Tripled (map): ${inputs.map { it * 3 }}")
}

/* ============================================================
   MINI EXERCISE (Try it yourself)
   ============================================================ */
// 1) Create a MutableList of 5 names.
// 2) Remove the 2nd name.
// 3) Add a new name to the end.
// 4) Print the names in uppercase using map().
// 5) Filter the names whose length is >= 5.
