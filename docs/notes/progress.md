# Progress Tracker

> ✅ Mark items as you complete them.  
> Add links to the file(s) where you practiced each concept.

## Stage 1 — Kotlin Foundations (Language Core)

- [x] Variables: `val` vs `var` → [Lesson01_Variables.kt](../../src/main/kotlin/lessons/fundamentals/Lesson01_Variables.kt)
- [x] Types: Int/Long/Double/Float/Boolean/Char/String → [Lesson02_Types.kt](../../src/main/kotlin/lessons/fundamentals/Lesson02_Types.kt)
- [x] Strings: templates, common ops, formatting → [Lesson11_TypeConversion_And_Strings.kt](../../src/main/kotlin/lessons/fundamentals/Lesson11_TypeConversion_And_Strings.kt)
- [x] Operators: arithmetic, comparison, logical → [Lesson03_Operators.kt](../../src/main/kotlin/lessons/fundamentals/Lesson03_Operators.kt)
- [x] Control flow: if/else, when, while/do-while, break/continue → [Lesson05_ControlFlow.kt](../../src/main/kotlin/lessons/fundamentals/Lesson05_ControlFlow.kt)
- [x] Functions: params, returns, default args, named args → [Lesson04_Functions.kt](../../src/main/kotlin/lessons/fundamentals/Lesson04_Functions.kt)
- [x] Function parameters deep dive: defaults, named args, vararg, lambdas → [Lesson09_FunctionParameters.kt](../../src/main/kotlin/lessons/fundamentals/Lesson09_FunctionParameters.kt)
- [x] Scope functions: let/apply/run/also/with → [Lesson10_Extension_Functions.kt](../../src/main/kotlin/lessons/fundamentals/Lesson10_Extension_Functions.kt)
- [x] Arrays: `Array<T>`, `IntArray`, iteration, conversions → [Lesson07_Arrays.kt](../../src/main/kotlin/lessons/fundamentals/Lesson07_Arrays.kt)
- [x] Lists: `listOf`, `mutableListOf`, add/remove, iteration → [Lesson08_Lists.kt](../../src/main/kotlin/lessons/fundamentals/Lesson08_Lists.kt)
- [x] Collections: Set + Map (mutable vs immutable) → [Lesson15_Sets_And_Maps.kt](../../src/main/kotlin/lessons/fundamentals/Lesson15_Sets_And_Maps.kt)
- [x] Collection operations: map/filter/reduce/groupBy/partition/zip → [Lesson16_Collection_Operations.kt](../../src/main/kotlin/lessons/fundamentals/Lesson16_Collection_Operations.kt)
- [x] Sequences (lazy ops) → [Lesson17_Sequences.kt](../../src/main/kotlin/lessons/fundamentals/Lesson17_Sequences.kt)
- [x] Collection builders (buildList/buildSet/buildMap) → [Lesson18_Collection_Builders.kt](../../src/main/kotlin/lessons/fundamentals/Lesson18_Collection_Builders.kt)
- [x] Null safety: `?`, `?:`, safe calls, smart casts → [Lesson06_NullSafety.kt](../../src/main/kotlin/lessons/fundamentals/Lesson06_NullSafety.kt)
- [x] Exceptions: try/catch, custom errors → [Lesson19_Exception_Handling.kt](../../src/main/kotlin/lessons/fundamentals/Lesson19_Exception_Handling.kt)

## Stage 2 — Kotlin OOP + Modeling

- [x] Classes + constructors → [Normal_classes.kt](../../src/main/kotlin/lessons/classes_objects/Normal_classes.kt)
- [x] Data classes (copy, destructuring) → [data_classes.kt](../../src/main/kotlin/lessons/classes_objects/data_classes.kt)
- [x] Interfaces + composition → [interfaces_and_delegation.kt](../../src/main/kotlin/lessons/classes_objects/interfaces_and_delegation.kt)
- [x] Sealed classes for state/result modeling → [sealed_classes.kt](../../src/main/kotlin/lessons/classes_objects/sealed_classes.kt)
- [ ] Generics (basic)
- [x] Extension functions + properties → [Lesson10_Extension_Functions.kt](../../src/main/kotlin/lessons/kotlin-lessons/Lesson10_Extension_Functions.kt)
- [x] Object + companion object → [singleton-classes.kt](../../src/main/kotlin/lessons/classes_objects/singleton-classes.kt)
- [ ] Visibility modifiers + packages
- [x] Enum classes → [enum_classes.kt](../../src/main/kotlin/lessons/classes_objects/enum_classes.kt)
- [x] Abstract classes + inheritance → [abstract_classes.kt](../../src/main/kotlin/lessons/classes_objects/abstract_classes.kt)
- [x] Anonymous objects (callbacks, listeners) → [anonymous_classes.kt](../../src/main/kotlin/lessons/classes_objects/anonymous_classes.kt)
- [x] Nested + inner classes → [inner_classes.kt](../../src/main/kotlin/lessons/classes_objects/inner_classes.kt)
- [x] Value classes (inline classes) → [value_classes.kt](../../src/main/kotlin/lessons/classes_objects/value_classes.kt)
- [x] Annotation classes → [annotation_classes.kt](../../src/main/kotlin/lessons/classes_objects/annotation_classes.kt)

## Concurrency foundation (threads, before Coroutines)

- [x] `thread { }` and offloading work → [thread.kt](../../src/main/kotlin/lessons/threads/thread.kt)
- [x] When/how threads are used (mobile, backend, desktop) → [thread.kt](../../src/main/kotlin/lessons/threads/thread.kt)
- [x] Concurrency vs parallelism (definitions; this lesson = concurrent; parallelism = multiple cores) → [thread.kt](../../src/main/kotlin/lessons/threads/thread.kt)

## Stage 3 — Coroutines + Flow (Mobile-critical)

- [x] suspend functions + runBlocking, launch → [coroutines.kt](../../src/main/kotlin/lessons/coroutines/coroutines.kt)
- [x] CoroutineScope + Dispatchers.Default (JVM); note Main/IO on Android → [coroutines.kt](../../src/main/kotlin/lessons/coroutines/coroutines.kt)
- [x] Sequential vs concurrent (one coroutine vs multiple launch) → [coroutines.kt](../../src/main/kotlin/lessons/coroutines/coroutines.kt)
- [x] Dispatchers.Default vs IO (thread pools, when to use) → [dispatchers_threadpool.kt](../../src/main/kotlin/lessons/dispatchers_thread/dispatchers_threadpool.kt)
- [x] withContext(Dispatchers.IO / Default) for switching → [dispatchers_threadpool.kt](../../src/main/kotlin/lessons/dispatchers_thread/dispatchers_threadpool.kt)
- [ ] Structured concurrency, cancellation + timeouts
- [ ] Exception handling in coroutines
- [ ] Flow basics (cold stream)
- [ ] Operators: map/filter/debounce/distinctUntilChanged
- [ ] StateFlow vs SharedFlow
- [ ] Testing coroutines + Flow

## Stage 4 — Android Fundamentals

- [ ] Android project structure + Gradle basics
- [ ] Activities/Fragments (know lifecycle basics)
- [ ] Permissions, intents, deep links
- [ ] Networking: Retrofit/OkHttp basics
- [ ] Persistence: Room + DataStore
- [ ] Background work: WorkManager
- [ ] Dependency Injection: Hilt basics

## Stage 5 — Jetpack Compose (Modern UI)

- [ ] Composables + recomposition understanding
- [ ] State hoisting patterns
- [ ] Side effects: LaunchedEffect / DisposableEffect
- [ ] Navigation Compose
- [ ] Theming (Material 3)
- [ ] Lists + performance (LazyColumn)
- [ ] UI testing basics (Compose tests)

## Stage 6 — Architecture + Testing + Quality

- [ ] MVVM + clean boundaries
- [ ] Repository pattern + use cases
- [ ] Unit tests (domain + data)
- [ ] ViewModel tests
- [ ] Integration tests (db/network fakes)
- [ ] Static analysis: ktlint/detekt
- [ ] Profiling + performance basics

## Stage 7 — Kotlin Multiplatform (Android + iOS)

- [ ] KMP project structure: commonMain/androidMain/iosMain
- [ ] Shared models + business logic
- [ ] Shared networking (Ktor client or shared layer)
- [ ] Shared persistence approach (e.g. SQLDelight or strategy)
- [ ] Swift interop basics (consuming shared framework)
- [ ] Shared state management design (UI stays native)

## Stage 8 — Production Readiness

- [ ] CI pipeline for Android (build + test)
- [ ] Signing configs (debug/release)
- [ ] Release builds (R8/Proguard basics)
- [ ] Versioning strategy
- [ ] Crash reporting + analytics integration approach
- [ ] Play Store publishing checklist

---

## Exercises Completed

- [x] Exercise 1: Palindrome Checker → [Exercise01_Palindrome.kt](../src/main/kotlin/exercises/Exercise01_Palindrome.kt)
