import java.io.File

/**
 * NORMAL CLASSES (CLASSES + OBJECTS BASICS)
 * ============================================================
 *
 * This file introduces Kotlin "normal classes" (not data classes yet).
 *
 * You will learn:
 * - How to create (instantiate) objects from classes
 * - Primary constructor + properties
 * - Methods + internal state (mutable data inside an object)
 * - The difference between `==` and `===`
 * - Why normal classes compare by reference unless you override equals/hashCode
 */

fun main() {
    classAndObjectBasicsDemo()
    equalityDemo()
}

/* ============================================================
   1) CLASS + OBJECT BASICS
   ============================================================ */
// Beginner note:
// - A class is a blueprint (a definition).
// - An object is an instance you create from that class: SessionStorage(...)
// - Objects can hold state (properties) and behavior (methods).
fun classAndObjectBasicsDemo() {
    println("=== Class + object basics ===")

    val sessionFile = File("build/tmp/session.txt").apply {
        parentFile?.mkdirs()
    }

    val storage = SessionStorage(sessionFile)

    println("Initial counter = ${storage.counter}")
    storage.counter = 3
    storage.save()

    storage.counter = 0 // reset in memory
    println("After reset (in memory) counter = ${storage.counter}")

    storage.load()
    println("After load() counter = ${storage.counter}")

    println()
}

/* ============================================================
   2) `==` VS `===` (EQUALITY)
   ============================================================ */
// Beginner note:
// - `==` means "structural equality" (it calls equals()).
// - `===` means "referential equality" (same object in memory).
//
// For a normal class (like SessionStorage), if you DON'T override equals(),
// then equals() behaves like reference equality (so two different objects are not equal).
fun equalityDemo() {
    println("=== == vs === (equality) ===")

    val file1 = File("build/tmp/session-a.txt").apply { parentFile?.mkdirs() }
    val file2 = File("build/tmp/session-a.txt") // same path, but still different File instance

    val sessionStorage1 = SessionStorage(file1)
    val sessionStorage2 = SessionStorage(file2)
    val sessionStorage3 = sessionStorage1

    println("sessionStorage1 = $sessionStorage1")
    println("sessionStorage2 = $sessionStorage2")

    // Different objects → not equal (because SessionStorage doesn't override equals)
    println("sessionStorage1 == sessionStorage2  -> ${sessionStorage1 == sessionStorage2}")
    println("sessionStorage1 === sessionStorage2 -> ${sessionStorage1 === sessionStorage2}")

    // Same reference → equal and identical
    println("sessionStorage1 == sessionStorage3  -> ${sessionStorage1 == sessionStorage3}")
    println("sessionStorage1 === sessionStorage3 -> ${sessionStorage1 === sessionStorage3}")

    println()
}

/* ============================================================
   CLASS: SessionStorage
   ============================================================ */
// Beginner note:
// - This is a "normal class": it has a primary constructor and internal state.
// - Primary constructor parameters can be stored as properties by using val/var.
// - Here, `file` is private: only the class can access it.
class SessionStorage(
    private val file: File
) {
    // Internal state (property):
    // - var means it can change.
    var counter: Int = 0

    // Method:
    // - A function inside a class is called a "member function" or "method".
    fun save() {
        file.writeText(counter.toString())
    }

    fun load() {
        counter = file.readText().toIntOrNull() ?: 0
    }

    override fun toString(): String {
        // Nice debugging output when you print the object
        return "SessionStorage(file='${file.path}', counter=$counter)"
    }
}
