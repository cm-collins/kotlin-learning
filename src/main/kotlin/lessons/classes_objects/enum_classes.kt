fun main() {
    enumBasicsDemo()
    enumWhenDemo()
    enumLookupDemo()
    enumMiniExercise()

}


/* ============================================================
   ENUM CLASSES (BEGINNER FRIENDLY)
   ============================================================ */
// Beginner note:
// - An enum is a type with a fixed set of known values.
// - Use enums for things like statuses, roles, directions, and categories.
// - Enums can have:
//   - constructor parameters (properties)
//   - functions
// - Each enum value is a singleton instance.

/* ============================================================
   1) ENUM BASICS: VALUES + PROPERTIES + FUNCTIONS
   ============================================================ */
fun enumBasicsDemo() {
    println("=== Enum basics ===")

    val status = LessonEnumHttpStatus.NOT_FOUND
    println("status = $status")
    println("status.code = ${status.code}")
    println("status.message = ${status.message}")
    println("toResponseString() = ${status.toResponseString()}")
    println()
}

// Enums can have a constructor (and therefore properties):
enum class LessonEnumHttpStatus(val code: Int, val message: String) {
    OK(200, "OK"),
    CREATED(201, "Created"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    BAD_GATEWAY(502, "Bad Gateway"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable"),
    GATEWAY_TIMEOUT(504, "Gateway Timeout");

    fun toResponseString(): String = "HTTP $code - $message"
}

/* ============================================================
   2) USING ENUMS WITH `when`
   ============================================================ */
// Beginner note:
// - `when` works great with enums.
// - If you handle all enum values, Kotlin can warn you when you miss a case.
fun enumWhenDemo() {
    println("=== Enum + when ===")

    val status = LessonEnumHttpStatus.UNAUTHORIZED
    val category = when (status) {
        LessonEnumHttpStatus.OK, LessonEnumHttpStatus.CREATED -> "Success"
        LessonEnumHttpStatus.BAD_REQUEST -> "Client Error (400)"
        LessonEnumHttpStatus.UNAUTHORIZED, LessonEnumHttpStatus.FORBIDDEN -> "Auth Error"
        LessonEnumHttpStatus.NOT_FOUND -> "Not Found"
        LessonEnumHttpStatus.INTERNAL_SERVER_ERROR,
        LessonEnumHttpStatus.BAD_GATEWAY,
        LessonEnumHttpStatus.SERVICE_UNAVAILABLE,
        LessonEnumHttpStatus.GATEWAY_TIMEOUT,
        -> "Server Error (5xx)"
    }

    println("$status -> $category")
    println()
}

/* ============================================================
   3) LOOKUPS: entries, name, valueOf
   ============================================================ */
// Beginner note:
// - Every enum value has a `name` (the constant name) and `ordinal` (index).
// - Prefer `entries` to iterate over all possible values.
// - `valueOf("OK")` converts a String to an enum value but throws if invalid.
fun enumLookupDemo() {
    println("=== Enum lookups ===")

    // Iterate all values:
    println("All statuses:")
    for (s in LessonEnumHttpStatus.entries) {
        println("- ${s.name} (${s.code})")
    }

    // String -> enum (unsafe if input can be invalid):
    val parsed = LessonEnumHttpStatus.valueOf("OK")
    println("valueOf(\"OK\") = $parsed")

    // Safe parsing pattern:
    val input = "NOT_A_STATUS"
    val safeParsed = LessonEnumHttpStatus.entries.firstOrNull { it.name == input }
    println("safe parse '$input' -> $safeParsed")

    println()
}

/* ============================================================
   MINI EXERCISE
   ============================================================ */
fun enumMiniExercise() {
    println("=== Mini exercise (try it) ===")
    println(
        """
        1) Create an enum class UserRole with: ADMIN, EDITOR, VIEWER
           - Add a property `canDelete: Boolean`

        2) Use when(role) to print what each role is allowed to do.

        3) Iterate through UserRole.entries and print each role.
        """.trimIndent()
    )
    println()
}

