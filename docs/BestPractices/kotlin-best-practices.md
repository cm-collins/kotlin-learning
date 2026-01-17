# Kotlin Best Practices Guide

This guide outlines best practices for writing clean, idiomatic Kotlin code. Follow these guidelines as you learn to ensure you're building good habits from the start.

---

## 1. Code Style & Formatting

### Naming Conventions

```kotlin
// ✅ GOOD: PascalCase for classes, objects, interfaces
class UserRepository
object DatabaseHelper
interface DataSource

// ✅ GOOD: camelCase for functions, variables, parameters
fun calculateTotal(price: Double, tax: Double): Double
val userName = "John"
var itemCount = 0

// ✅ GOOD: UPPER_SNAKE_CASE for constants
const val MAX_RETRY_ATTEMPTS = 3
const val API_BASE_URL = "https://api.example.com"

// ❌ BAD: Hungarian notation or unclear names
var strName: String  // Don't prefix with type
var data: Any  // Too generic
```

### File Organization

```kotlin
// ✅ GOOD: One class/object per file, file name matches class name
// File: UserService.kt
class UserService { }

// ✅ GOOD: Top-level functions in appropriately named files
// File: StringUtils.kt
fun String.isEmail(): Boolean { }
```

---

## 1.1. File & Folder Naming Best Practices

### Kotlin Source Files (.kt)

```kotlin
// ✅ GOOD: PascalCase matching class name
// File: UserRepository.kt
class UserRepository { }

// File: DataSource.kt
interface DataSource { }

// ✅ GOOD: Descriptive names for utility files
// File: StringExtensions.kt
fun String.isEmail(): Boolean { }

// File: DateUtils.kt
fun formatDate(date: Date): String { }

// ✅ GOOD: Multiple related top-level functions in one file
// File: ValidationUtils.kt
fun isValidEmail(email: String): Boolean { }
fun isValidPhone(phone: String): Boolean { }

// ❌ BAD: Generic or unclear names
// File: Utils.kt  // Too generic
// File: Helper.kt  // Unclear purpose
// File: Stuff.kt  // Meaningless
```

### Test Files

```kotlin
// ✅ GOOD: Test file matches source file with Test suffix
// Source: UserService.kt
// Test: UserServiceTest.kt

// ✅ GOOD: Descriptive test class names
class UserServiceTest { }

// ✅ GOOD: Integration tests clearly marked
// File: UserRepositoryIntegrationTest.kt

// ❌ BAD: Unclear test file names
// File: Test1.kt
// File: UserTest.kt  // Which User class?
```

### Folder/Directory Naming

```
// ✅ GOOD: lowercase with hyphens or camelCase (project-dependent)
src/main/kotlin/
  ├── domain/           # Business logic
  ├── data/             # Data layer
  ├── ui/               # UI components
  ├── utils/            # Utility functions
  └── di/               # Dependency injection

// ✅ GOOD: Descriptive folder names
src/main/kotlin/
  ├── auth/
  ├── user/
  ├── payment/
  └── common/

// ✅ GOOD: Feature-based organization (Android)
src/main/kotlin/
  ├── feature/
  │   ├── login/
  │   ├── profile/
  │   └── settings/

// ❌ BAD: Unclear or generic folder names
src/main/kotlin/
  ├── stuff/      # Too vague
  ├── temp/       # Temporary code shouldn't be committed
  ├── old/        # Old code should be removed
  └── misc/       # Everything goes here
```

### Resource Files

```
// ✅ GOOD: lowercase with underscores for resources
res/
  ├── drawable/
  │   ├── ic_user_avatar.png
  │   └── bg_login_screen.png
  ├── layout/
  │   ├── activity_main.xml
  │   └── item_user_list.xml
  └── values/
      ├── strings.xml
      └── colors.xml

// ✅ GOOD: Descriptive resource names
ic_user_profile_24dp.png
btn_submit_primary.xml
tv_welcome_message

// ❌ BAD: Unclear resource names
image1.png
button1.xml
text1
```

### Documentation Files

```
// ✅ GOOD: lowercase with hyphens for markdown files
docs/
  ├── getting-started.md
  ├── api-reference.md
  ├── kotlin-best-practices.md
  └── notes/
      ├── notes-kotlin.md
      └── progress.md

// ✅ GOOD: Clear, descriptive names
README.md
CHANGELOG.md
CONTRIBUTING.md
LICENSE

// ❌ BAD: Unclear documentation names
doc1.md
notes.txt
readme.txt  // Should be README.md
```

### Learning/Educational Files

```
// ✅ GOOD: Consistent naming pattern for lessons
lessons/
  ├── Lesson01_Variables.kt
  ├── Lesson02_Types.kt
  ├── Lesson03_Operators.kt

// ✅ GOOD: Clear exercise naming
exercises/
  ├── Exercise01_Palindrome.kt
  ├── Exercise02_Anagrams.kt
  └── solutions/
      └── Exercise01_Palindrome.kt

// ✅ GOOD: Numbered for ordering, descriptive topic name
Lesson##_TopicName.kt
Exercise##_Name.kt
```

### Package Structure

```kotlin
// ✅ GOOD: Reverse domain notation for packages
package com.example.app.domain
package com.example.app.data.repository
package com.example.app.ui.component

// ✅ GOOD: Feature-based packages
package com.example.feature.auth
package com.example.feature.profile

// ✅ GOOD: Clear package hierarchy
com.example.app/
  ├── domain/
  │   ├── model/
  │   └── usecase/
  ├── data/
  │   ├── repository/
  │   └── datasource/
  └── ui/
      ├── screen/
      └── component/

// ❌ BAD: Default package or unclear structure
// (no package)  // Avoid default package
package app  // Too generic
package myapp  // Not following conventions
```

### Special Cases

#### Android Projects

```
// ✅ GOOD: Android standard structure
app/src/main/
  ├── java/  or  kotlin/
  │   └── com/example/app/
  │       ├── MainActivity.kt
  │       ├── ui/
  │       └── data/
  └── res/
      ├── layout/
      ├── drawable/
      └── values/

// ✅ GOOD: Activity/Fragment naming
MainActivity.kt
UserProfileFragment.kt
LoginActivity.kt

// ✅ GOOD: ViewModel naming
UserViewModel.kt
LoginViewModel.kt
```

#### Kotlin Multiplatform (KMP)

```
// ✅ GOOD: Source set organization
commonMain/kotlin/
  └── com/example/shared/
      ├── domain/
      └── data/

androidMain/kotlin/
  └── com/example/android/

iosMain/kotlin/
  └── com/example/ios/
```

### Naming Rules Summary

| Type | Convention | Example |
|------|------------|---------|
| **Kotlin files** | PascalCase | `UserService.kt` |
| **Test files** | PascalCase + Test | `UserServiceTest.kt` |
| **Folders** | lowercase or camelCase | `domain/`, `userProfile/` |
| **Resources** | lowercase_with_underscores | `ic_user_avatar.png` |
| **Documentation** | lowercase-with-hyphens | `getting-started.md` |
| **Lessons** | `Lesson##_Topic.kt` | `Lesson01_Variables.kt` |
| **Exercises** | `Exercise##_Name.kt` | `Exercise01_Palindrome.kt` |
| **Packages** | reverse.domain | `com.example.app` |

### General Principles

1. **Be Descriptive**: Names should clearly indicate purpose
   - ✅ `UserRepository.kt`
   - ❌ `Repo.kt`

2. **Be Consistent**: Follow the same pattern throughout the project
   - ✅ All lessons: `Lesson##_Topic.kt`
   - ❌ Mixed: `Lesson1_Variables.kt`, `lesson-2-types.kt`

3. **Avoid Abbreviations**: Unless widely understood
   - ✅ `UserRepository.kt`
   - ❌ `UsrRepo.kt`

4. **Use Standard Extensions**: 
   - `.kt` for Kotlin source files
   - `.md` for markdown documentation
   - `.xml` for Android layouts/resources

5. **Avoid Special Characters**: 
   - ✅ Use hyphens or underscores
   - ❌ Avoid spaces, special chars: `my file.kt`

6. **Keep It Short But Clear**:
   - ✅ `PaymentService.kt`
   - ❌ `PaymentProcessingServiceForECommercePlatform.kt`

---

## 2. Variables & Immutability

### Prefer `val` over `var`

```kotlin
// ✅ GOOD: Use val for immutable references
val userName = "John"
val items = listOf("apple", "banana")

// ⚠️ Use var only when reassignment is necessary
var counter = 0
counter++  // Only if you really need to mutate

// ❌ BAD: Unnecessary mutation
var result = calculateValue()
result = processResult(result)  // Could use val with expression
```

### Type Inference

```kotlin
// ✅ GOOD: Let Kotlin infer types when obvious
val name = "Kotlin"  // String
val count = 42  // Int
val items = listOf(1, 2, 3)  // List<Int>

// ✅ GOOD: Explicit types for clarity or when needed
val user: User? = getUser()
val numbers: MutableList<Int> = mutableListOf()
```

---

## 3. Null Safety

### Safe Calls & Elvis Operator

```kotlin
// ✅ GOOD: Use safe call operator
val length = user?.name?.length

// ✅ GOOD: Use Elvis operator for defaults
val userName = user?.name ?: "Guest"
val count = items?.size ?: 0

// ✅ GOOD: Explicit null checks with smart casts
if (user != null) {
    println(user.name)  // Smart cast: user is now non-null
}

// ❌ BAD: Using !! (null assertion) - only use when absolutely certain
val name = user!!.name  // Avoid unless you're 100% sure
```

### Nullable vs Non-Nullable

```kotlin
// ✅ GOOD: Make types nullable only when necessary
fun processUser(user: User) { }  // Non-nullable
fun findUser(id: Int): User? { }  // Nullable when result might not exist

// ❌ BAD: Making everything nullable "just in case"
fun processUser(user: User?) { }  // Only if user can actually be null
```

---

## 4. Functions

### Function Design

```kotlin
// ✅ GOOD: Single responsibility, clear names
fun calculateTotalPrice(items: List<Item>): Double {
    return items.sumOf { it.price }
}

// ✅ GOOD: Default parameters instead of overloads
fun greet(name: String, greeting: String = "Hello") {
    println("$greeting, $name!")
}

// ✅ GOOD: Named parameters for clarity
greet(name = "John", greeting = "Hi")

// ❌ BAD: Too many responsibilities
fun processAndValidateAndSave(data: String) { }  // Split into smaller functions
```

### Expression Bodies

```kotlin
// ✅ GOOD: Use expression body for simple functions
fun isEven(number: Int): Boolean = number % 2 == 0
fun max(a: Int, b: Int): Int = if (a > b) a else b

// ✅ GOOD: Regular body for complex logic
fun processData(data: String): Result {
    // Multiple lines of logic
    val cleaned = data.trim()
    val validated = validate(cleaned)
    return Result(validated)
}
```

---

## 5. Collections

### Immutable by Default

```kotlin
// ✅ GOOD: Prefer immutable collections
val items = listOf("a", "b", "c")  // Immutable List
val map = mapOf("key" to "value")  // Immutable Map

// ✅ GOOD: Use mutable collections only when needed
val mutableList = mutableListOf<String>()
mutableList.add("item")

// ❌ BAD: Unnecessary mutability
var items = mutableListOf<String>()  // Use val with mutableListOf if needed
```

### Collection Operations

```kotlin
// ✅ GOOD: Use functional operations
val evenNumbers = numbers.filter { it % 2 == 0 }
val doubled = numbers.map { it * 2 }
val sum = numbers.sum()

// ✅ GOOD: Chain operations for readability
val result = numbers
    .filter { it > 0 }
    .map { it * 2 }
    .sum()

// ❌ BAD: Manual loops when functional operations exist
var sum = 0
for (num in numbers) {
    sum += num * 2
}
// Better: numbers.map { it * 2 }.sum()
```

---

## 6. Control Flow

### When Expression

```kotlin
// ✅ GOOD: Use when instead of if-else chains
val description = when {
    count == 0 -> "empty"
    count == 1 -> "one"
    count < 10 -> "few"
    else -> "many"
}

// ✅ GOOD: When with sealed classes
sealed class Result
data class Success(val data: String) : Result()
data class Error(val message: String) : Result()

when (result) {
    is Success -> println(result.data)
    is Error -> println(result.message)
}

// ❌ BAD: Long if-else chains
if (x == 1) { }
else if (x == 2) { }
else if (x == 3) { }
// Better: use when
```

### Early Returns

```kotlin
// ✅ GOOD: Early returns for guard clauses
fun processUser(user: User?): String {
    if (user == null) return "No user"
    if (user.name.isEmpty()) return "Empty name"
    
    return "Processing ${user.name}"
}

// ❌ BAD: Deep nesting
fun processUser(user: User?): String {
    if (user != null) {
        if (user.name.isNotEmpty()) {
            return "Processing ${user.name}"
        } else {
            return "Empty name"
        }
    } else {
        return "No user"
    }
}
```

---

## 7. Data Classes

### When to Use Data Classes

```kotlin
// ✅ GOOD: Data classes for data holders
data class User(
    val id: Int,
    val name: String,
    val email: String
)

// ✅ GOOD: Data classes get equals(), hashCode(), toString(), copy() automatically
val user1 = User(1, "John", "john@example.com")
val user2 = user1.copy(name = "Jane")

// ❌ BAD: Regular class when data class would be better
class User(val id: Int, val name: String)  // Use data class if it's just data
```

---

## 8. String Templates & Formatting

```kotlin
// ✅ GOOD: String templates
val message = "Hello, $name! You have $count items."

// ✅ GOOD: Expressions in templates
val result = "Total: ${price * quantity}"

// ✅ GOOD: Multiline strings
val text = """
    This is a
    multiline string
""".trimIndent()

// ❌ BAD: String concatenation
val message = "Hello, " + name + "!"  // Use templates instead
```

---

## 9. Extension Functions

```kotlin
// ✅ GOOD: Extension functions for utility operations
fun String.isEmail(): Boolean {
    return this.contains("@") && this.contains(".")
}

// Usage
if (email.isEmail()) { }

// ✅ GOOD: Extension properties
val String.wordCount: Int
    get() = this.split(" ").size

// ❌ BAD: Overusing extensions or making them too complex
// Keep extensions simple and focused
```

---

## 10. Error Handling

### Exceptions

```kotlin
// ✅ GOOD: Catch specific exceptions
try {
    val result = riskyOperation()
} catch (e: IllegalArgumentException) {
    // Handle specific error
} catch (e: Exception) {
    // Handle general error
}

// ✅ GOOD: Don't swallow exceptions silently
try {
    processData()
} catch (e: Exception) {
    logger.error("Error processing data", e)  // At least log it
    // Handle appropriately
}

// ❌ BAD: Empty catch blocks
try {
    riskyOperation()
} catch (e: Exception) {
    // Silent failure - very bad!
}
```

### Result Types

```kotlin
// ✅ GOOD: Use Result type for operations that can fail
fun divide(a: Int, b: Int): Result<Int> {
    return if (b == 0) {
        Result.failure(IllegalArgumentException("Division by zero"))
    } else {
        Result.success(a / b)
    }
}

// Usage
divide(10, 2)
    .onSuccess { println("Result: $it") }
    .onFailure { println("Error: ${it.message}") }
```

---

## 11. Comments & Documentation

### KDoc Comments

```kotlin
// ✅ GOOD: KDoc for public APIs
/**
 * Calculates the total price including tax.
 *
 * @param items List of items to calculate total for
 * @param taxRate Tax rate as a decimal (e.g., 0.1 for 10%)
 * @return Total price including tax
 * @throws IllegalArgumentException if taxRate is negative
 */
fun calculateTotalWithTax(items: List<Item>, taxRate: Double): Double {
    require(taxRate >= 0) { "Tax rate cannot be negative" }
    val subtotal = items.sumOf { it.price }
    return subtotal * (1 + taxRate)
}

// ✅ GOOD: Inline comments explain "why", not "what"
// Using binary search for O(log n) performance
val index = binarySearch(sortedList, target)

// ❌ BAD: Comments that just repeat the code
// Increment counter by 1
counter++  // Obvious from code
```

---

## 12. Performance Considerations

### Lazy Evaluation

```kotlin
// ✅ GOOD: Use sequences for large collections
val largeList = (1..1_000_000).toList()
val result = largeList
    .asSequence()  // Lazy evaluation
    .filter { it % 2 == 0 }
    .map { it * 2 }
    .take(10)  // Only processes first 10
    .toList()

// ❌ BAD: Eager evaluation on large collections
val result = largeList
    .filter { it % 2 == 0 }  // Processes all 1M items
    .map { it * 2 }
    .take(10)
```

### Avoid Unnecessary Allocations

```kotlin
// ✅ GOOD: Reuse objects when possible
val formatter = SimpleDateFormat("yyyy-MM-dd")

// ❌ BAD: Creating new objects in loops
for (date in dates) {
    val formatter = SimpleDateFormat("yyyy-MM-dd")  // Created every iteration
    formatter.format(date)
}
```

---

## 13. Common Pitfalls to Avoid

### ❌ Don't Use `!!` Unnecessarily

```kotlin
// ❌ BAD
val name = user!!.name

// ✅ GOOD
val name = user?.name ?: "Unknown"
```

### ❌ Don't Ignore Null Safety

```kotlin
// ❌ BAD: Assuming non-null without checking
fun process(user: User?) {
    println(user.name)  // Could crash if user is null
}

// ✅ GOOD
fun process(user: User?) {
    user?.let { println(it.name) }
}
```

### ❌ Don't Use Mutable Collections Unnecessarily

```kotlin
// ❌ BAD
var items = mutableListOf<String>()

// ✅ GOOD
val items = listOf<String>()  // If you don't need to modify
```

### ❌ Don't Write Java-Style Code

```kotlin
// ❌ BAD: Java style
fun getFullName(firstName: String, lastName: String): String {
    val result: String
    if (firstName != null && lastName != null) {
        result = "$firstName $lastName"
    } else {
        result = ""
    }
    return result
}

// ✅ GOOD: Kotlin style
fun getFullName(firstName: String?, lastName: String?): String {
    return "$firstName $lastName".trim()
}
```

---

## 14. Code Organization

### Package Structure

```kotlin
// ✅ GOOD: Logical package organization
package com.example.data.repository
package com.example.domain.model
package com.example.ui.component

// ❌ BAD: Everything in default package
// (no package declaration)
```

### File Organization

```kotlin
// ✅ GOOD: Within a file, organize like this:
// 1. Package declaration
// 2. Imports
// 3. Top-level declarations (functions, properties)
// 4. Classes, objects, interfaces

package com.example

import kotlin.collections.List

// Top-level constants
const val MAX_SIZE = 100

// Top-level functions
fun utilityFunction() { }

// Classes
class MyClass { }
```

---

## 15. Testing Best Practices

```kotlin
// ✅ GOOD: Clear test names
@Test
fun `calculateTotal should return sum of all prices`() {
    val items = listOf(Item(10.0), Item(20.0))
    val total = calculateTotal(items)
    assertEquals(30.0, total)
}

// ✅ GOOD: Test edge cases
@Test
fun `calculateTotal should return zero for empty list`() {
    val total = calculateTotal(emptyList())
    assertEquals(0.0, total)
}

// ✅ GOOD: One assertion per test (when possible)
```

---

## Quick Reference Checklist

When writing Kotlin code, ask yourself:

- [ ] Am I using `val` instead of `var` when possible?
- [ ] Am I handling nulls safely (no unnecessary `!!`)?
- [ ] Are my function names clear and descriptive?
- [ ] Am I using immutable collections by default?
- [ ] Am I using `when` instead of long if-else chains?
- [ ] Are my functions doing one thing (single responsibility)?
- [ ] Am I using data classes for data holders?
- [ ] Am I avoiding Java-style code patterns?
- [ ] Are my comments explaining "why" not "what"?
- [ ] Am I using extension functions appropriately?

---

## Resources

- [Official Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html)
- [Kotlin Style Guide](https://developer.android.com/kotlin/style-guide)
- [Effective Kotlin](https://kt.academy/book/effectivekotlin)

---

**Remember**: Best practices are guidelines, not strict rules. Use your judgment and adapt based on your specific context. The goal is readable, maintainable, and idiomatic Kotlin code.
