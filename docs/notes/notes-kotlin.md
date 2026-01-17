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
