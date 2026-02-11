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
