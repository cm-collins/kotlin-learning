# Kotlin Learning Notes

## Overview

This file contains notes, insights, and key learnings from studying Kotlin fundamentals.

---

## Session Log Template

### Session [Date]

- **Focus**:
- **Lessons touched**:
- **Exercises completed**:
- **Bugs/lessons learned**:
- **Next topics**:

---

## Key Concepts

### Variables and Types

- `val` = immutable (read-only)
- `var` = mutable (can be reassigned)
- Type inference: Kotlin can infer types from context
- Explicit types: `val name: String = "value"`

### Null Safety

- Kotlin's type system distinguishes nullable from non-nullable types
- `String?` = nullable String
- `String` = non-nullable String
- Safe call operator: `?.` - only executes if not null
- Smart casts: Kotlin automatically casts after null checks

### Functions

- Functions can return `Unit` (nothing) or a specific type
- Parameters can have default values
- Named arguments improve readability
- Useful parameter patterns you’ll use often:
  - Default arguments: `fun f(x: Int = 10) { ... }`
  - Named arguments: `f(x = 10)`
  - `vararg`: `fun sumAll(vararg xs: Int)`
  - Higher-order functions: `fun transform(items: List<Int>, mapper: (Int) -> Int)`
- Lesson reference: `src/main/kotlin/lessons/kotlin-lessons/Lesson09_FunctionParameters.kt`

### Control Flow (Loops + when)

- `while` repeats while a condition is true
  - **Always update the loop variable** (e.g., `count++` / `count--`) to avoid infinite loops
- `do-while` runs **at least once** (checks the condition after the first run)
- `break` exits the loop early; `continue` skips to the next iteration
- `when` is Kotlin’s powerful alternative to switch:
  - `when(value) { ... }` matches values, multiple options, and ranges (`in 1..5`)
  - `when { ... }` matches boolean conditions (like an if/else chain)
  - `when` can be an **expression** (return a value into a `val`)
- Lesson reference: `src/main/kotlin/lessons/kotlin-lessons/Lesson05_ControlFlow.kt`

### Arrays

- Arrays are **fixed-size** collections (can update elements, but can’t add/remove)
- Two main types:
  - `Array<T>` (e.g. `arrayOf("a", "b")`)
  - Primitive arrays like `IntArray` (e.g. `intArrayOf(1, 2, 3)`)
- Useful properties and helpers:
  - `size`, `indices`, `getOrNull(index)` for safe access
  - `joinToString()` for quick printing
- Conversions:
  - `array.toList()`
  - `list.toTypedArray()`
- Lesson reference: `src/main/kotlin/lessons/kotlin-lessons/Lesson07_Arrays.kt`

### Lists

- `List<T>` is a **read-only view** (created with `listOf(...)`)
  - You can read/iterate, but you can’t `add()`/`remove()` through that reference
- `MutableList<T>` is **modifiable** (created with `mutableListOf(...)`)
  - You can `add`, `removeAt`, and update by index (`list[0] = ...`)
- Common operations return **new lists** (don’t mutate the original):
  - `map`, `filter`, `distinct`, `sorted`
- Handy helpers:
  - `getOrNull(index)` for safe access
  - `any`, `all`, `count`, `sum`, `maxOrNull`, `minOrNull`
- Lesson reference: `src/main/kotlin/lessons/kotlin-lessons/Lesson08_Lists.kt`

### Extension Functions & Scope Functions

- **Extension functions** add new behaviour to existing types without modifying them:
  - `fun String.capitalizeFirst(): String { ... }`
  - Inside the body, `this` refers to the receiver object
- **Scope functions** run a block of code in the context of an object:

```
  Function  | Context | Returns           | Common use
  --------- | ------- | ----------------- | -----------------------------------
  let       | it      | lambda result     | Null-safe transforms, scoping
  run       | this    | lambda result     | Compute + configure together
  apply     | this    | context object    | Object configuration (builder-style)
  also      | it      | context object    | Side effects (logging, validation)
  with(obj) | this    | lambda result     | Multiple calls on the same object
```

- Lesson reference: `src/main/kotlin/lessons/kotlin-lessons/Lesson10_Extension_Functions.kt`

### Exception Handling

- Kotlin has **no checked exceptions** (unlike Java)
- `try` is an **expression** — it can return a value:
  - `val n = try { str.toInt() } catch (e: Exception) { 0 }`
- `throw` is also an expression with return type `Nothing`
- Useful stdlib helpers: `require()`, `check()`, `error()`
- Lesson reference: `src/main/kotlin/lessons/kotlin-lessons/Lesson19_Exception_Handling.kt`

---

## Classes & Objects (OOP)

### Class Types at a Glance

```
┌──────────────────────────────────────────────────────────────────────┐
│                     Kotlin Class Types                               │
├──────────────────┬───────────────────────────────────────────────────┤
│ class            │ Regular class — properties, methods, constructors │
│ data class       │ Data holder — auto equals/hashCode/toString/copy  │
│ enum class       │ Fixed set of named constants with shared type     │
│ sealed class     │ Closed hierarchy — exhaustive when matching       │
│ abstract class   │ Cannot instantiate — defines abstract members     │
│ object           │ Singleton — one instance, thread-safe, lazy init  │
│ companion object │ Static-like members inside a class                │
│ inner class      │ Nested class that accesses outer class members    │
│ value class      │ Type-safe wrapper around a single value (inline)  │
│ annotation class │ Metadata for classes/functions/properties         │
└──────────────────┴───────────────────────────────────────────────────┘
```

### Decision Flowchart (which class type?)

```
Start
  │
  ├─ Need a simple object with state + behaviour?
  │    └─ class  (Normal_classes.kt)
  │
  ├─ Mainly carrying data (DTO, model, API response)?
  │    └─ data class  (data_classes.kt)
  │
  ├─ Fixed, enumerable set of options (e.g. status codes)?
  │    └─ enum class  (enum_classes.kt)
  │
  ├─ Closed set of related subtypes (e.g. Result, UiState)?
  │    └─ sealed class / sealed interface  (sealed_classes.kt)
  │
  ├─ Want to define a contract with some shared behaviour?
  │    ├─ Only ONE parent needed → abstract class  (abstract_classes.kt)
  │    └─ Multiple parents needed → interface  (coming soon)
  │
  ├─ Need exactly ONE instance in the whole app?
  │    └─ object declaration  (singleton_classes.kt)
  │
  ├─ Need a one-off implementation (callback, listener)?
  │    └─ object expression  (anonymous_classes.kt)
  │
  ├─ Nested class needs to reference the outer instance?
  │    └─ inner class  (inner_classes.kt)
  │
  ├─ Wrapping a primitive for type safety (zero allocation)?
  │    └─ @JvmInline value class  (value_classes.kt)
  │
  └─ Attaching metadata / markers to code?
       └─ annotation class  (annotation_classes.kt)
```

### Equality in Kotlin

- `==` checks **structural equality** (calls `equals()` under the hood)
- `===` checks **referential equality** (same object in memory)
- `data class` auto-generates `equals()` based on constructor properties
- Regular `class` uses `Any.equals()` by default (same as `===`)

### Key OOP Concepts

| Concept | Keyword | Meaning |
|---------|---------|---------|
| Inheritance | `open`, `:` | A class can extend another open/abstract class |
| Override | `override` | Subclass provides its own implementation |
| Abstract | `abstract` | Member has no body; subclass **must** implement it |
| Polymorphism | — | Treating different subclasses through a common parent type |
| Encapsulation | `private`, `internal` | Hiding internal details behind a public API |

- Lesson files: `src/main/kotlin/lessons/classes_objects/`

---

## Concurrency & Parallelism

- **Concurrency**: Multiple tasks make progress over time; they may be interleaved (e.g. one thread runs, then another). Goal: keep the program responsive (e.g. UI thread free while I/O runs).
- **Parallelism**: Multiple tasks actually execute at the same time (multiple CPU cores). A form of concurrency when you have enough cores to run threads simultaneously.
- In Kotlin/JVM, `thread { }` starts a new thread so work runs off the caller; that gives **concurrency**. On a multi-core machine the OS may run threads in **parallel**.
- For mobile/backend, the main concern is *don’t block the main/request thread* (concurrency); parallelism is an optimization for heavy CPU work.
- Lesson (with full notes and examples): `src/main/kotlin/lessons/threads/thread.kt`

---

## Coroutines basics

- **Coroutines** = lightweight concurrency: many coroutines can run on a few threads; code can suspend (pause) without blocking the thread.
- **suspend fun**: Can only be called from a coroutine or another suspend function. Use for work that can pause (e.g. `delay`, I/O).
- **runBlocking**: Blocks the current thread and runs the block as a coroutine. Use in `main()` or tests so the program waits; on Android use `lifecycleScope` / `viewModelScope` instead.
- **launch**: Starts a new coroutine; returns a `Job`. Use `job.join()` to wait for it.
- **CoroutineScope(Dispatchers.XXX).launch { }**: Starts a coroutine on the given dispatcher. On **JVM console** use `Dispatchers.Default` (Dispatchers.Main is for Android/UI). On **Android**: `Dispatchers.Main` (UI), `Dispatchers.IO` (disk/network), `Dispatchers.Default` (CPU).
- **Sequential**: One coroutine, steps one after the other (total time = sum of steps).
- **Concurrent**: Multiple coroutines at once (e.g. two `launch { }` in the same scope); total time ≈ longest task. Use `job.join()` so the caller waits for all children.
- **delay(ms)**: Suspends the coroutine without blocking the thread.
- Lesson (full KDoc + sequential vs concurrent cooking demo): `src/main/kotlin/lessons/coroutines/coroutines.kt`

---

## Dispatchers & withContext

- **Dispatcher** = decides which thread (or thread pool) runs a coroutine. Default and IO use **separate** shared pools.
- **Dispatchers.Default**: CPU-bound work (sorting, parsing, math). Pool size ≈ CPU cores.
- **Dispatchers.IO**: Blocking I/O (file, network, DB). Pool size 64 by default (JVM). Use for blocking calls; `delay()` does not block, so use Default for pure delays.
- **Dispatchers.Main**: UI thread (Android/Swing); not in plain JVM console.
- **withContext(Dispatchers.XXX) { }**: Run a block on another dispatcher and return to the caller with a result. Pattern: `withContext(Dispatchers.IO) { readFile() }` then use result on current context.
- Lesson (Default vs IO, thread names, withContext examples): `src/main/kotlin/lessons/dispatchers_thread/dispatchers_threadpool.kt`

---

## Common Patterns

### Null Handling

```kotlin
val input = readLine()
if (input != null) {
    // Smart cast: input is now String (not String?)
    println(input.uppercase())
}
```

### String Operations

```kotlin
val cleaned = word.lowercase().replace(" ", "")
val reversed = cleaned.reversed()
```

---

## Resources

- [Official Kotlin Docs](https://kotlinlang.org/docs/home.html)
- [Kotlin Playground](https://play.kotlinlang.org/)
