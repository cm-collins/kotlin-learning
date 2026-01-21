# kotlin-learning

A structured Kotlin + Mobile Development learning codebase you can grow into a **production-grade Android + Kotlin Multiplatform (KMP)** portfolio.

This repo is built like a **learning notebook + project playground**:
- You practice Kotlin fundamentals in small, focused files.
- You keep exercises + solutions in the repo.
- You track progress using checklists.
- You gradually evolve from Kotlin basics → Android → Jetpack Compose → Testing → KMP → CI/CD → Publishing.

---

## Goals

- Master Kotlin language features deeply (not “just enough”).
- Build modern Android apps with **Jetpack Compose**, strong architecture, and testing.
- Build cross-platform apps with **Kotlin Multiplatform** (Android + iOS) using shared business/data layers.
- Build production-ready apps: CI/CD, quality gates, releases, monitoring mindset.

---

## How This Repo Is Organized

This repo is intended to evolve in phases:

### Phase A: Kotlin Fundamentals (Console / JVM)
You write Kotlin in small runnable files and practice language mastery.

### Phase B: Android Apps (Android module)
You build Android projects (Compose-first), using best practices.

### Phase C: KMP Apps (shared module + Android app + iOS client)
You reuse business logic across Android + iOS.

---

## Prerequisites

### Required
- Android Studio (recommended) or IntelliJ IDEA
- JDK 17+ (Android Studio bundles a JDK)
- Git

### Optional but useful later
- macOS + Xcode (required for running iOS apps when doing KMP)

---

## Running the Code

### If this is currently a Kotlin/JVM project
- Open the repo in IntelliJ IDEA / Android Studio.
- Run the `main()` function in the Kotlin file(s).

### If/when Android module exists
- Open the project in Android Studio.
- Select `app` run configuration.
- Run on emulator/device.

---

## Repository Structure

```
kotlin-learning/
├── README.md
├── build.gradle.kts
├── settings.gradle.kts
├── docs/
│   ├── BestPractices/
│   │   └── kotlin-best-practices.md    # ⭐ Best practices guide
│   └── notes/
│       ├── progress.md
│       ├── notes-kotlin.md
│       ├── notes-android.md
│       ├── notes-compose.md
│       ├── notes-testing.md
│       └── notes-kmp.md
├── src/
│   ├── main/
│   │   ├── kotlin/
│   │   │   ├── lessons/                   # Kotlin fundamentals (Phase A)
│   │   │   │   └── kotlin-lessons/
│   │   │   │       ├── Lesson01_Variables.kt
│   │   │   │       ├── Lesson02_Types.kt
│   │   │   │       ├── Lesson03_Operators.kt
│   │   │   │       ├── Lesson04_Functions.kt
│   │   │   │       ├── Lesson05_ControlFlow.kt
│   │   │   │       ├── Lesson06_NullSafety.kt
│   │   │   │       ├── Lesson07_Arrays.kt
│   │   │   │       └── ... (more lessons as you progress)
│   │   │   └── exercises/
│   │   │       ├── Exercise01_Palindrome.kt
│   │   │       ├── Exercise02_Anagrams.kt
│   │   │       ├── Exercise03_BasicAuthModel.kt
│   │   │       └── solutions/
│   │   └── resources/
│   └── test/
│       └── kotlin/
├── android-apps/                 # Android module(s) (Phase B) - Future
│   ├── compose-starter/
│   ├── offline-first-notes/
│   └── ...
├── kmp-apps/                    # KMP projects (Phase C) - Future
│   ├── shared-core/             # shared module (commonMain)
│   ├── androidApp/
│   └── iosApp/
└── tools/                        # Future
    ├── scripts/
    └── ci/
```

> **Note**: This structure evolves as you progress. Currently focused on Kotlin fundamentals in `src/main/kotlin/`. Android and KMP modules will be added in later phases.


---

## Coding Standards for This Repo

> 📖 **See [docs/BestPractices/kotlin-best-practices.md](docs/BestPractices/kotlin-best-practices.md) for the Kotlin best practices guide.**

### File conventions
- Lessons: `Lesson##_TopicName.kt`
- Exercises: `Exercise##_Name.kt`
- If you keep solutions: store them under `solutions/` (don't mix with exercises).

### Code style
- Prefer clarity > cleverness.
- Avoid `!!` except in controlled experiments (and label them).
- Use `sealed class` for state/result modeling.
- Use pure functions for logic whenever possible.
- Follow Kotlin best practices: prefer `val` over `var`, use null safety properly, prefer immutable collections.

---

## How to Learn Using This Repo

### 1) Lessons
Each lesson should include:
- A short comment header describing what you’re learning.
- 2–5 examples max (small, focused).
- A mini exercise at the end.

### 2) Exercises
Exercises are where mastery happens. For each exercise:
- Write the problem statement at the top.
- Implement solution(s).
- Add edge cases.
- Add tests (later stages).

### 3) Tracking progress
Use the progress checklist below (copy to `docs/notes/progress.md`).

---

## Progress Tracker (Copy/Paste Friendly)

> ✅ Mark items as you complete them.  
> Add links to the file(s) where you practiced each concept.

### Stage 1 — Kotlin Foundations (Language Core)
- [ ] Variables: `val` vs `var`
- [ ] Types: Int/Long/Double/Float/Boolean/Char/String
- [ ] Strings: templates, common ops, formatting
- [ ] Operators: arithmetic, comparison, logical
- [ ] Control flow: if/else, when, loops, ranges
- [ ] Functions: params, returns, default args, named args
- [ ] Scope functions: let/apply/run/also/with
- [ ] Collections: List/Set/Map (mutable vs immutable)
- [ ] Collections ops: map/filter/reduce/groupBy
- [ ] Null safety: `?`, `?:`, safe calls, smart casts
- [ ] Exceptions: try/catch, custom errors

### Stage 2 — Kotlin OOP + Modeling
- [ ] Classes + constructors
- [ ] Data classes (copy, destructuring)
- [ ] Interfaces + composition
- [ ] Sealed classes for state/result modeling
- [ ] Generics (basic)
- [ ] Extension functions + properties
- [ ] Object + companion object
- [ ] Visibility modifiers + packages

### Stage 3 — Coroutines + Flow (Mobile-critical)
- [ ] suspend functions + structured concurrency
- [ ] Dispatchers + threading model
- [ ] Cancellation + timeouts
- [ ] Exception handling in coroutines
- [ ] Flow basics (cold stream)
- [ ] Operators: map/filter/debounce/distinctUntilChanged
- [ ] StateFlow vs SharedFlow
- [ ] Testing coroutines + Flow

### Stage 4 — Android Fundamentals
- [ ] Android project structure + Gradle basics
- [ ] Activities/Fragments (know lifecycle basics)
- [ ] Permissions, intents, deep links
- [ ] Networking: Retrofit/OkHttp basics
- [ ] Persistence: Room + DataStore
- [ ] Background work: WorkManager
- [ ] Dependency Injection: Hilt basics

### Stage 5 — Jetpack Compose (Modern UI)
- [ ] Composables + recomposition understanding
- [ ] State hoisting patterns
- [ ] Side effects: LaunchedEffect / DisposableEffect
- [ ] Navigation Compose
- [ ] Theming (Material 3)
- [ ] Lists + performance (LazyColumn)
- [ ] UI testing basics (Compose tests)

### Stage 6 — Architecture + Testing + Quality
- [ ] MVVM + clean boundaries
- [ ] Repository pattern + use cases
- [ ] Unit tests (domain + data)
- [ ] ViewModel tests
- [ ] Integration tests (db/network fakes)
- [ ] Static analysis: ktlint/detekt
- [ ] Profiling + performance basics

### Stage 7 — Kotlin Multiplatform (Android + iOS)
- [ ] KMP project structure: commonMain/androidMain/iosMain
- [ ] Shared models + business logic
- [ ] Shared networking (Ktor client or shared layer)
- [ ] Shared persistence approach (e.g. SQLDelight or strategy)
- [ ] Swift interop basics (consuming shared framework)
- [ ] Shared state management design (UI stays native)

### Stage 8 — Production Readiness
- [ ] CI pipeline for Android (build + test)
- [ ] Signing configs (debug/release)
- [ ] Release builds (R8/Proguard basics)
- [ ] Versioning strategy
- [ ] Crash reporting + analytics integration approach
- [ ] Play Store publishing checklist

---

## Suggested Projects (Portfolio-Grade)

These aren’t “toy apps” — each forces real-world skill.

### Android (Compose)
- [ ] Offline-first Notes app (Room + sync strategy)
- [ ] Search app (Flow debounce + pagination + caching)
- [ ] Auth app (token handling + secure storage)

### Kotlin Multiplatform
- [ ] Shared core module (domain + data) used by:
    - [ ] Android app (Compose)
    - [ ] iOS app (SwiftUI)
- [ ] KMP “API + Cache + State” demo (clean boundaries)

---

## Commit Message Convention (Recommended)

Use Conventional Commits:
- `feat:` new functionality
- `fix:` bug fix
- `refactor:` restructure without behavior change
- `docs:` documentation only
- `test:` add/modify tests
- `chore:` tooling/build tasks

Examples:
- `docs: add staged Kotlin learning roadmap and progress tracker`
- `feat: add Lesson03 operators and Exercise01 palindrome checker`
- `refactor: split learning notebook into lesson files`

---

## Daily / Session Log Template (Optional)

Copy into `docs/notes/progress.md` or `docs/notes/notes-kotlin.md`:

### Session
- Focus:
- Lessons touched:
- Exercises completed:
- Bugs/lessons learned:
- Next topics:

---

## Current Lesson Notebook (Template)

If you keep a single “notebook” file, use this pattern:

- Only run ONE lesson in `main()`.
- Keep each topic in its own function.
- Keep extra examples commented and labeled.

---

## Next Steps For This Repo (Recommended Order)

1. Create `docs/notes/progress.md` and paste the Progress Tracker.
2. Create the `kotlin-fundamentals` module and split lessons into files.
3. Add exercises + (later) add tests.
4. Add your first Android Compose app module when Kotlin fundamentals are stable.
5. Add KMP only after you’re confident in coroutines/Flow and Compose basics.

---

## Notes

- This README is designed for long-term tracking.
- Keep it clean: add links to lesson files as you create them.
- The goal is not to “finish Kotlin,” but to build production-level instincts.

---

## License
MIT (or your preferred license)
