/**
 * LESSON 16: COLLECTION OPERATIONS
 * ============================================================
 *
 * This lesson completes Stage 1.5 pending items:
 * - Collection operations: map, filter, reduce
 * - Collection operations: groupBy, partition, zip
 */

fun main() {
    lesson16MapFilterReduce()
    lesson16GroupByPartitionZip()
    lesson16MiniExercise()
}

data class Lesson16User(val name: String, val age: Int)

fun lesson16MapFilterReduce() {
    println("=== Lesson 16.1) map / filter / reduce / fold ===")

    // Beginner note:
    // - map: transform each element (same size list)
    // - filter: keep elements that match a condition (size may shrink)
    // - reduce/fold: combine elements into ONE value (sum, product, etc.)

    val nums = listOf(1, 2, 3, 4, 5)

    val squared = nums.map { it * it }
    println("squared = $squared")

    val evens = nums.filter { it % 2 == 0 }
    println("evens = $evens")

    val sum = nums.reduce { acc, n -> acc + n }
    println("sum (reduce) = $sum")

    val sumFold = nums.fold(initial = 0) { acc, n -> acc + n }
    println("sum (fold) = $sumFold")

    val users = listOf(
        Lesson16User("Amina", 19),
        Lesson16User("Brian", 16),
        Lesson16User("Caro", 24),
        Lesson16User("Dan", 24),
    )

    val adultNames = users
        .filter { it.age >= 18 }
        .map { it.name }
    println("adultNames = $adultNames")

    println()
}

fun lesson16GroupByPartitionZip() {
    println("=== Lesson 16.2) groupBy / partition / zip ===")

    // Beginner note:
    // - groupBy: put items into buckets (Map<key, List<items>>)
    // - partition: split into exactly two lists (trueList, falseList)
    // - zip: combine two lists element-by-element into pairs

    val users = listOf(
        Lesson16User("Amina", 19),
        Lesson16User("Brian", 16),
        Lesson16User("Caro", 24),
        Lesson16User("Dan", 24),
        Lesson16User("Eve", 16),
    )

    // groupBy:
    val byAge = users.groupBy { it.age }
    println("groupBy age = $byAge")

    // partition (splits into two lists based on predicate):
    val (adults, minors) = users.partition { it.age >= 18 }
    println("adults = $adults")
    println("minors = $minors")

    // zip:
    val names = listOf("A", "B", "C")
    val scores = listOf(10, 20, 30)
    val paired = names.zip(scores) // List<Pair<String, Int>>
    println("zipped = $paired")

    println()
}

fun lesson16MiniExercise() {
    println("=== Lesson 16: Mini exercise (try it) ===")
    println(
        """
        1) Given a list of Ints, filter out odd numbers and then double the remaining values.

        2) Given a list of names, group them by first letter.

        3) Given two lists (ids and emails), zip them into pairs and print them.
        """.trimIndent()
    )
    println()
}

