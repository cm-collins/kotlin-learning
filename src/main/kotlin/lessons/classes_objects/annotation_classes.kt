/**
 * ANNOTATION CLASSES (BEGINNER FRIENDLY)
 * ============================================================
 *
 * An annotation is "metadata" you attach to code.
 *
 * You’ve already seen built-in annotations like:
 * - `@Deprecated`
 * - `@JvmInline`
 *
 * Why annotations matter:
 * - Tooling: lint rules, code generation, IDE hints
 * - Runtime behavior: frameworks can read annotations (e.g., DI, JSON parsing)
 * - Documentation: communicate intent (e.g., “don’t use this API”)
 *
 * Important meta-annotations (annotations on annotations):
 * - `@Target(...)`    -> where this annotation is allowed (class, function, property, constructor, etc.)
 * - `@Retention(...)` -> how long it is kept (SOURCE, BINARY, RUNTIME)
 * - `@MustBeDocumented` -> included in generated docs (KDoc)
 */

fun main() {
    lessonAnnotationBasicsDemo()
    lessonAnnotationReadingDemo()
    lessonAnnotationMiniExercise()
}

/* ============================================================
   1) DEFINING + USING A CUSTOM ANNOTATION
   ============================================================ */
// Beginner note:
// - Annotation classes are defined with: `annotation class Name(...)`
// - They can have constructor parameters (usually val-like settings).
// - Most useful annotations are small and descriptive.
fun lessonAnnotationBasicsDemo() {
    println("=== Annotation basics ===")

    // Use annotated API:
    val service = LegacyPaymentService()
    service.pay(amount = 100)

    println()
}

/* ============================================================
   2) TARGET + RETENTION (WHAT THEY MEAN)
   ============================================================ */
// Beginner note:
// - Retention is very important:
//   - SOURCE: only in source code, not in compiled output
//   - BINARY: in compiled .class files, but not visible at runtime reflection
//   - RUNTIME: visible at runtime via reflection (frameworks need this)
@MustBeDocumented
@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.CONSTRUCTOR,
    AnnotationTarget.FUNCTION
)
@Retention(AnnotationRetention.RUNTIME)
annotation class CustomerDeprecated(
    val message: String,
    val replaceWith: String = ""
)

@CustomerDeprecated(
    message = "Use NewPaymentService instead (this will be removed soon).",
    replaceWith = "NewPaymentService"
)
class LegacyPaymentService {
    @CustomerDeprecated(
        message = "Use payNew(...) which validates inputs better.",
        replaceWith = "payNew"
    )
    fun pay(amount: Int) {
        println("Legacy payment of $amount")
    }
}

class NewPaymentService {
    fun payNew(amount: Int) {
        require(amount > 0) { "amount must be > 0" }
        println("New payment of $amount")
    }
}

/* ============================================================
   3) READING ANNOTATIONS (RUNTIME REFLECTION)
   ============================================================ */
// Beginner note:
// - Because we used RUNTIME retention, we can read this annotation at runtime.
// - We’ll use Java reflection (no extra dependencies needed).
fun lessonAnnotationReadingDemo() {
    println("=== Reading annotations at runtime ===")

    val clazz = LegacyPaymentService::class.java
    val classAnnotation = clazz.getAnnotation(CustomerDeprecated::class.java)

    println("Class annotated? ${classAnnotation != null}")
    if (classAnnotation != null) {
        println("Class message: ${classAnnotation.message}")
        println("Suggested replacement: ${classAnnotation.replaceWith}")
    }

    val method = clazz.getDeclaredMethod("pay", Int::class.javaPrimitiveType)
    val methodAnnotation = method.getAnnotation(CustomerDeprecated::class.java)

    println("Method annotated? ${methodAnnotation != null}")
    if (methodAnnotation != null) {
        println("Method message: ${methodAnnotation.message}")
        println("Suggested replacement: ${methodAnnotation.replaceWith}")
    }

    println()
}

/* ============================================================
   MINI EXERCISE
   ============================================================ */
fun lessonAnnotationMiniExercise() {
    println("=== Mini exercise (try it) ===")
    println(
        """
        1) Create an annotation @FeatureFlag(name: String)
           - Target: FUNCTION
           - Retention: RUNTIME

        2) Annotate two functions with different flag names.

        3) Use reflection to list which functions have @FeatureFlag and print their names.
        """.trimIndent()
    )
    println()
}