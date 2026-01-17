/**
 * EXERCISE 1: PALINDROME CHECKER
 * ============================================================
 * 
 * TASK: Write a function that checks if a word or phrase is a palindrome.
 * 
 * What is a palindrome?
 * A palindrome reads the same forwards and backwards (ignoring case and spaces).
 * 
 * Examples:
 * - "madam" -> true
 * - "Race car" -> true
 * - "Hello" -> false
 * - "A man a plan a canal Panama" -> true
 * - "level" -> true
 * - "kotlin" -> false
 * 
 * Requirements:
 * 1. Create a function called `isPalindrome(input: String): Boolean`
 * 2. The function should ignore case (uppercase/lowercase)
 * 3. The function should ignore spaces
 * 4. Return true if the string is a palindrome, false otherwise
 * 
 * Edge Cases to Consider:
 * - Empty string: "" -> true (empty string is a palindrome)
 * - Single character: "a" -> true
 * - String with only spaces: "   " -> true
 * - Mixed case: "RaCeCaR" -> true
 * - Phrases with spaces: "race car" -> true
 * 
 * Hints:
 * - Use `lowercase()` to convert to lowercase
 * - Use `replace(" ", "")` to remove spaces
 * - Use `reversed()` to reverse a string
 * - Compare the cleaned string with its reverse
 * 
 * Testing:
 * Test your solution with the examples above. You can create a main() function
 * to test your implementation.
 * 
 * Solution:
 * Check solutions/Exercise01_Palindrome.kt for a reference solution after
 * you've attempted the exercise yourself.
 */
