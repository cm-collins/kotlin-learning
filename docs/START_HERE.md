# 🚀 Start Here - Kotlin Learning Guide

Welcome to the Kotlin Learning Repository! This guide will help you get started and make the most of this learning resource.

---

## 📋 What You'll Learn

This repository is designed to take you from **Kotlin basics** to **production-ready Android and Kotlin Multiplatform (KMP)** development through hands-on practice.

**Current Focus**: Phase A — Kotlin Fundamentals (Console/JVM)

---

## ⚙️ Prerequisites

Before you start, make sure you have:

### Required

- **IntelliJ IDEA** or **Android Studio** (recommended for Android development later)
- **JDK 17+** (bundled with Android Studio, or download separately)
- **Git** (to clone this repository)

### Optional (for later phases)

- **macOS + Xcode** (only needed for Kotlin Multiplatform iOS development)

---

## 🏁 Getting Started

### Step 1: Clone the Repository

```bash
git clone <repository-url>
cd kotlin-tutorial
```

### Step 2: Open in IntelliJ IDEA / Android Studio

1. Open IntelliJ IDEA or Android Studio
2. Select **File → Open**
3. Navigate to the `kotlin-tutorial` directory
4. Click **Open**

The IDE will automatically detect the Gradle project and configure it.

### Step 3: Run Your First Lesson

1. Navigate to `src/main/kotlin/lessons/fundamentals/`
2. Open `Lesson01_Variables.kt`
3. Right-click anywhere in the file
4. Select **Run 'Lesson01_VariablesKt'**

You should see output in the console!

---

## 📚 Learning Path

### Phase A: Kotlin Fundamentals (Current)

Work through lessons in order:

1. **Lesson01_Variables.kt** — `val` vs `var`, immutability
2. **Lesson02_Types.kt** — Int, Double, Boolean, String, etc.
3. **Lesson03_Operators.kt** — Arithmetic, comparison, logical operators
4. **Lesson04_Functions.kt** — Function declaration, parameters, return types
5. **Lesson05_ControlFlow.kt** — if/else, while loops, break/continue
6. **Lesson06_NullSafety.kt** — Nullable types, safe calls, smart casts
7. **Lesson07_Arrays.kt** — Arrays, indexing, iteration, conversions
8. **Lesson08_Lists.kt** — Lists (immutable/mutable), iteration
9. **Lesson09_FunctionParameters.kt** — Default/named args, vararg, lambdas (parameter deep dive)
10. **Lesson10_Extension_Functions.kt** — Extension functions + scope functions (let/apply/run/also/with)
11. **Lesson11_TypeConversion_And_Strings.kt** — Type conversion, string templates, string formatting
12. **Lesson12_Labels_And_Returns.kt** — Labels and returns (labeled break/continue, return@label)
13. **Lesson13_Advanced_Functions.kt** — Single-expression, infix, local functions, tailrec
14. **Lesson14_Platform_Types_Java_Interop.kt** — Java interop: platform types (String!)
15. **Lesson15_Sets_And_Maps.kt** — Sets + maps
16. **Lesson16_Collection_Operations.kt** — map/filter/reduce/groupBy/partition/zip
17. **Lesson17_Sequences.kt** — Sequences (lazy evaluation)
18. **Lesson18_Collection_Builders.kt** — buildList/buildSet/buildMap
19. **Lesson19_Exception_Handling.kt** — try/catch/finally, throw, custom exceptions, Nothing, Java checked exceptions

**Location**: `src/main/kotlin/lessons/fundamentals/`

> Note: Lesson 14 also includes a small Java file in `src/main/java/interop/` used to demonstrate platform types.

### Optional (recommended before Stage 3)

20. **Lesson20_Lambdas.kt** — Lambda basics, function types, higher-order functions, closures

### Concurrency foundation (before Coroutines)

21. **thread.kt** — `thread { }`, offloading work, when/how threads are used (mobile, backend), **concurrency vs parallelism**  
**Location**: `src/main/kotlin/lessons/threads/thread.kt`

### Phase B: Object-Oriented Kotlin (Classes & Objects)

Work through class types in any order (they are self-contained):

**Location**: `src/main/kotlin/lessons/classes_objects/`

| # | File | What You'll Learn |
|---|------|-------------------|
| 1 | `Normal_classes.kt` | Class basics, primary constructors, properties, methods, equality (`==` vs `===`) |
| 2 | `data_classes.kt` | Data classes, `copy()`, destructuring, auto-generated `equals`/`hashCode`/`toString` |
| 3 | `enum_classes.kt` | Enum constants, properties, methods, `when` exhaustive matching, `entries`/`valueOf` |
| 4 | `sealed_classes.kt` | Sealed classes & interfaces, modeling state/results, exhaustive `when` |
| 5 | `abstract_classes.kt` | Abstract members, `open`/`override`, inheritance, polymorphism |
| 6 | `singleton-classes.kt` | `object`, `data object`, companion objects, object expressions |
| 7 | `anonymous_classes.kt` | Object expressions for callbacks, listeners, adapters, comparators |
| 8 | `inner_classes.kt` | Nested vs inner classes, accessing outer class members |
| 9 | `value_classes.kt` | `@JvmInline value class`, type-safe wrappers, zero-overhead abstractions |
| 10 | `annotation_classes.kt` | Custom annotations, `@Target`, `@Retention`, reading annotations via reflection |
| 11 | `interfaces_and_delegation.kt` | Interfaces, default methods, multiple interfaces, delegation (`by`) |

> **Tip**: Each file has a `main()` function — run it the same way as the fundamentals lessons.

#### Class Type Quick-Reference

```
Which class type should I use?
──────────────────────────────
Need a plain object with behavior?        → class (Normal_classes.kt)
Need a data holder (DTO, model)?          → data class (data_classes.kt)
Need a fixed set of constants?            → enum class (enum_classes.kt)
Need a closed set of subtypes?            → sealed class / sealed interface (sealed_classes.kt)
Need a base with abstract members?        → abstract class (abstract_classes.kt)
Need exactly ONE global instance?         → object declaration (singleton_classes.kt)
Need one-off interface implementation?    → object expression (anonymous_classes.kt)
Need to access outer class from nested?   → inner class (inner_classes.kt)
Need type-safe wrapper (zero-cost)?       → @JvmInline value class (value_classes.kt)
Need metadata / compile-time markers?     → annotation class (annotation_classes.kt)
```

### How to Run Lessons

Each lesson file has a `main()` function. To run any lesson:

1. Open the lesson file in IntelliJ
2. Right-click in the editor
3. Select **Run 'LessonXX\_...'**

Alternatively, click the green play button (▶️) next to `fun main()`.

---

## 💪 Exercises

After completing lessons, practice with exercises to solidify your understanding.

### Exercise Structure

- **Problem files**: `src/main/kotlin/exercises/Exercise##_*.kt`
  - Contains only the problem statement and requirements
  - Implement your solution here

- **Solution files**: `src/main/kotlin/exercises/solutions/Exercise##_*.kt`
  - Reference solutions (look at these AFTER attempting the exercise)

### Current Exercises

1. **Exercise01_Palindrome.kt** — Check if a string is a palindrome

### How to Work on Exercises

1. Open the exercise file (e.g., `Exercise01_Palindrome.kt`)
2. Read the problem statement carefully
3. Implement your solution
4. Run it to test
5. Compare with the solution file if needed

---

## 📊 Track Your Progress

Use `docs/notes/progress.md` to track what you've learned:

- Mark items as complete: `- [x]`
- Add links to files where you practiced concepts
- Keep notes on what you learned

---

## 📖 Resources in This Repo

### Documentation

- **[README.md](../README.md)** — Complete repository overview and roadmap
- **[docs/notes/progress.md](notes/progress.md)** — Progress tracker with all topics
- **[docs/BestPractices/kotlin-best-practices.md](BestPractices/kotlin-best-practices.md)** — Comprehensive Kotlin best practices guide

### Notes

- **[docs/notes/notes-kotlin.md](notes/notes-kotlin.md)** — Your Kotlin learning notes
- **[docs/notes/notes-android.md](notes/notes-android.md)** — Android development notes (for later)
- **[docs/notes/notes-compose.md](notes/notes-compose.md)** — Jetpack Compose notes (for later)
- **[docs/notes/notes-testing.md](notes/notes-testing.md)** — Testing notes (for later)
- **[docs/notes/notes-kmp.md](notes/notes-kmp.md)** — Kotlin Multiplatform notes (for later)

---

## 🎯 Learning Tips

### 1. Practice Daily

- Spend 30-60 minutes daily on lessons/exercises
- Consistency beats intensity

### 2. Type the Code

- Don't just read — type out the examples yourself
- Experiment by changing values and re-running

### 3. Solve Exercises Without Looking

- Try exercises on your own first
- Only check solutions after attempting

### 4. Take Notes

- Use `docs/notes/notes-kotlin.md` for insights
- Write down things that confused you and how you understood them

### 5. Follow Best Practices

- Refer to `docs/BestPractices/kotlin-best-practices.md` regularly
- Write clean code from day one

### 6. Ask Questions

- If something is unclear, look it up in the Kotlin docs
- Experiment in the code to understand behavior

---

## 🔍 Troubleshooting

### Can't run a lesson file?

**Problem**: "No main class found" or similar error

**Solution**:

- Make sure the file has a `fun main()` function
- Right-click inside the file (not on the filename)
- Select **Run** from the context menu

### Gradle sync issues?

**Problem**: "Gradle sync failed"

**Solution**:

1. Go to **File → Invalidate Caches / Restart**
2. Select **Invalidate and Restart**
3. Wait for Gradle to re-sync

### Build errors?

**Problem**: Compilation errors

**Solution**:

1. Check the error message in the Build tab
2. Make sure you're using JDK 17 or higher
3. Run `./gradlew clean build` from terminal

---

## 🚀 Next Steps

Once you complete Kotlin Fundamentals (Lessons 01-19) and Classes & Objects:

1. **Review** `docs/notes/progress.md` and mark all completed items
2. **Continue** Stage 2 — remaining items: lateinit, lazy, visibility, Generics
3. **Concurrency foundation**: Complete `threads/thread.kt` (threads, concurrency vs parallelism)
4. **Move to Stage 3**: Functional Programming in Kotlin
5. **Eventually**: Coroutines, Android, and Kotlin Multiplatform

---

## 📞 Need Help?

- **Official Kotlin Docs**: [kotlinlang.org/docs](https://kotlinlang.org/docs/home.html)
- **Kotlin Playground**: [play.kotlinlang.org](https://play.kotlinlang.org/) (practice online)
- **Best Practices Guide**: `docs/BestPractices/kotlin-best-practices.md`

---

## ✅ Quick Checklist

Before starting:

- [ ] IntelliJ IDEA or Android Studio installed
- [ ] JDK 17+ available
- [ ] Repository cloned and opened in IDE
- [ ] Able to run `Lesson01_Variables.kt` successfully

If all checked, you're ready to start learning! 🎉

---

**Happy Learning!** 🚀

Start with `Lesson01_Variables.kt` and work your way through. Remember: the goal isn't to rush—it's to build solid foundations.
