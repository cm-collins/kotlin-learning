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

### Control Flow (Loops)

- `while` repeats while a condition is true
  - **Always update the loop variable** (e.g., `count++` / `count--`) to avoid infinite loops
- `do-while` runs **at least once** (checks the condition after the first run)
- `break` exits the loop early; `continue` skips to the next iteration
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
