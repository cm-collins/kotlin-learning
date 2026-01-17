/**
 * EXERCISE 1: PALINDROME CHECKER - SOLUTION
 * ============================================================
 * 
 * This is a reference solution. Try solving the exercise yourself first!
 * 
 * Problem: Write a function that checks if a word or phrase is a palindrome.
 * A palindrome reads the same forwards and backwards (ignoring case and spaces).
 */

fun main() {
    palindromeExample()
}

fun palindromeExample() {
    val word: String = "madam"

    val cleaned = word.lowercase().replace(" ", "")
    val reversed = cleaned.reversed()

    if (cleaned == reversed) {
        println("\"$word\" is a palindrome ✅")
    } else {
        println("\"$word\" is NOT a palindrome ❌")
    }

    // Try more examples:
    println("\nMore examples:")
    println("\"Race car\" is a palindrome: ${isPalindrome("Race car")}") // true
    println("\"Hello\" is a palindrome: ${isPalindrome("Hello")}")    // false
    println("\"A man a plan a canal Panama\" is a palindrome: ${isPalindrome("A man a plan a canal Panama")}") // true
}

/**
 * Checks if a string is a palindrome.
 * 
 * Solution approach:
 * 1. Convert input to lowercase for case-insensitive comparison
 * 2. Remove spaces to handle phrases
 * 3. Compare the cleaned string with its reverse
 * 
 * @param input The string to check
 * @return true if the string is a palindrome, false otherwise
 */
fun isPalindrome(input: String): Boolean {
    val cleaned = input.lowercase().replace(" ", "")
    return cleaned == cleaned.reversed()
}
