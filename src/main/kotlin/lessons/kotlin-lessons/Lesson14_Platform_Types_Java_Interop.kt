/**
 * LESSON 14: PLATFORM TYPES (JAVA INTEROP)
 * ============================================================
 *
 * This lesson completes Stage 1.4 pending item:
 * - Platform types (Java interop)
 *
 * Platform types happen when Kotlin calls Java code without nullability annotations.
 * Example from Java:
 *   public static String getName() { ... }
 *
 * Kotlin sees it as: String!   (a platform type)
 * Meaning:
 * - It might be null, but Kotlin can't prove it.
 * - Kotlin lets you treat it as String OR String? at compile time.
 * - If it is actually null and you treat it as non-null, you can crash at runtime.
 */

import interop.Lesson14JavaPlatformApi

fun main() {
    lesson14PlatformTypeBasics()
    lesson14PlatformTypesInGenerics()
    lesson14MiniExercise()
}

fun lesson14PlatformTypeBasics() {
    println("=== Lesson 14.1) Platform type basics ===")

    // Beginner note:
    // - Java code may return null even when the type says "String".
    // - Kotlin calls that a platform type (String!) and cannot enforce null-safety for you.
    // - Treat values from Java as nullable unless you are 100% sure they can’t be null.

    // Java method returns String (no @Nullable/@NotNull)
    // Kotlin treats it as String! (platform type).
    val nickPlatform = Lesson14JavaPlatformApi.getPossiblyNullNickname(false)
    println("nickPlatform = $nickPlatform")

    // You can assign platform types to non-null variables:
    val nickNonNull: String = Lesson14JavaPlatformApi.getPossiblyNullNickname(false)
    println("nickNonNull length = ${nickNonNull.length}")

    // But if Java returns null, this will crash at runtime if treated as non-null.
    try {
        val canCrash: String = Lesson14JavaPlatformApi.getPossiblyNullNickname(true)
        println("This line may not run. length=${canCrash.length}")
    } catch (e: NullPointerException) {
        println("Caught NPE: Java returned null but Kotlin treated it as non-null.")
    }

    // Safer pattern: accept it as nullable and handle it safely.
    val nickNullable: String? = Lesson14JavaPlatformApi.getPossiblyNullNickname(true)
    val safeNick = nickNullable?.uppercase() ?: "(no nickname)"
    println("safeNick = $safeNick")

    println()
}

fun lesson14PlatformTypesInGenerics() {
    println("=== Lesson 14.2) Platform types in generics ===")

    // Beginner note:
    // - Platform types also appear inside generics: List<String!>!
    // - If the Java API is not annotated, be defensive when reading values.

    val tags = Lesson14JavaPlatformApi.getTags()
    println("tags = $tags")

    // Defensive coding when consuming Java collections:
    // - treat elements as possibly-null if the Java API isn't annotated
    val upper = tags.map { it.uppercase() }
    println("upper = $upper")

    println()
}

fun lesson14MiniExercise() {
    println("=== Lesson 14: Mini exercise (try it) ===")
    println(
        """
        1) Modify the Java API to sometimes return null for a List element.
           - In Kotlin, iterate safely and replace nulls with "(missing)".

        2) Create another Java method that returns Object.
           - In Kotlin, use is-checks + safe casts (as?) to handle it.
        """.trimIndent()
    )
    println()
}

