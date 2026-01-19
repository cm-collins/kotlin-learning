/**
 * LESSON 5: CONTROL FLOW
 * ============================================================
 * 
 * Learn about conditional statements:
 * - if / else if / else
 * - Using conditions to control program flow
 */

fun main() {
    ifConditionsExample()
}

/* ============================================================
   IF CONDITIONS
   ============================================================ */
fun ifConditionsExample() {
    val x = 7
    val y = 7

    if (x < y) {
        println("$x is less than $y")
    } else if (x > y || x * y == 49) {
        println("At least one condition is true (x > y OR x*y == 49)")
    } else {
        println("$x is equal to $y")
    }

    println("This line always runs\n")
}
