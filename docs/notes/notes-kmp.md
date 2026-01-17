# Kotlin Multiplatform (KMP) Notes

## Overview
This file contains notes, insights, and key learnings from studying Kotlin Multiplatform development.

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

### KMP Project Structure
- `commonMain` - Shared code for all platforms
- `androidMain` - Android-specific implementations
- `iosMain` - iOS-specific implementations
- `jvmMain`, `jsMain`, etc. - Other platform targets

### Shared Code Philosophy
- Business logic and data models in `commonMain`
- Platform-specific UI (Android Compose, iOS SwiftUI)
- Platform-specific APIs accessed through `expect/actual` mechanism

### Expect/Actual Pattern
```kotlin
// commonMain
expect class Platform() {
    val name: String
}

// androidMain
actual class Platform actual constructor() {
    actual val name: String = "Android"
}

// iosMain
actual class Platform actual constructor() {
    actual val name: String = "iOS"
}
```

### Networking
- Ktor Client - multiplatform HTTP client
- Shared API models and network logic
- Platform-specific certificate pinning/SSL

### Persistence
- SQLDelight - multiplatform SQL database
- DataStore (Android) / UserDefaults (iOS) for preferences
- Shared data models, platform-specific storage

### State Management
- Shared business logic and state
- UI layer remains platform-native
- Use Flows/StateFlow for reactive state

---

## Common Patterns

### TODO: Add patterns as you learn them

---

## Architecture Considerations

### Clean Architecture in KMP
- Domain layer: Pure Kotlin, platform-agnostic
- Data layer: Platform-specific implementations (networking, storage)
- Presentation: Platform-native (Compose, SwiftUI)

### Dependency Injection
- Koin - multiplatform DI framework
- Or manual dependency injection with expect/actual

---

## Resources
- [Kotlin Multiplatform Docs](https://kotlinlang.org/docs/multiplatform.html)
- [KMP Samples](https://github.com/Kotlin/kotlin-multiplatform-samples)
- [Ktor Client](https://ktor.io/docs/client.html)
- [SQLDelight](https://cashapp.github.io/sqldelight/)

---

## Learning Path

1. **Understand KMP Structure**
   - Set up a basic KMP project
   - Understand source sets and platform targets

2. **Shared Business Logic**
   - Move domain models to `commonMain`
   - Create shared use cases and business rules

3. **Platform-Specific Implementations**
   - Use `expect/actual` for platform APIs
   - Implement data layer per platform

4. **Networking**
   - Set up Ktor client in `commonMain`
   - Handle platform-specific networking concerns

5. **Persistence**
   - Choose persistence strategy (SQLDelight, etc.)
   - Implement shared data access layer

6. **State Management**
   - Use Flows for reactive state
   - Keep UI layer platform-native

7. **Testing**
   - Test shared code with common tests
   - Platform-specific test implementations
