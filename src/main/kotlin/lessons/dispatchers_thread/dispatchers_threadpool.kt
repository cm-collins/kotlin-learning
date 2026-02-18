/**
 * DISPATCHERS AND THREAD POOLS — Which thread runs your coroutine
 *
 * A dispatcher (CoroutineDispatcher) decides which thread or thread pool runs
 * a coroutine. Choosing the right one keeps the app responsive and efficient.
 *
 * ---------------------------------------------------------------------------
 * BUILT-IN DISPATCHERS (JVM)
 * ---------------------------------------------------------------------------
 *
 * Dispatchers.Default
 * - Shared pool of threads, sized to the number of CPU cores (typically).
 * - Use for: CPU-bound work (sorting, filtering, parsing, heavy computation).
 * - Why not more threads? Too many threads doing CPU work causes context-
 *   switching and hurts performance. One thread per core is the sweet spot.
 *
 * Dispatchers.IO
 * - Separate shared pool for blocking I/O. Default pool size is 64 (on JVM;
 *   configurable via JVM options). Threads are created on demand.
 * - Use for: file read/write, network calls, database queries — any work that
 *   blocks the thread while waiting for I/O.
 * - Why a separate pool? So I/O-bound work doesn't steal threads from
 *   Dispatchers.Default. Blocking an IO thread doesn't slow down CPU work.
 * - Note: delay() does NOT block the thread; use Default for pure delays.
 *   Use IO when you call blocking APIs (e.g. File.readBytes(), socket read).
 *
 * Dispatchers.Main
 * - Single-threaded; runs on the main/UI thread. Available on Android and
 *   with UI frameworks (e.g. Swing). Not available in a plain JVM console app.
 * - Use for: updating UI. Offload heavy work to Default or IO, then switch
 *   back to Main to update the screen.
 *
 * Dispatchers.Unconfined
 * - Starts in the caller thread; after the first suspension, resumes in
 *   whatever thread the suspending function uses. Rarely needed; avoid for
 *   general use. Useful for coroutines that don't use CPU or shared UI.
 *
 * ---------------------------------------------------------------------------
 * SWITCHING DISPATCHERS: withContext
 * ---------------------------------------------------------------------------
 * Use withContext(Dispatchers.XXX) { ... } to run a block on another
 * dispatcher and then return to the previous one. Common pattern:
 *
 *   withContext(Dispatchers.IO) { readFile(path) }  // block on IO thread
 *   withContext(Dispatchers.Main) { updateUi(result) }  // on Android
 *
 * ---------------------------------------------------------------------------
 * THREAD POOL VS DISPATCHER
 * ---------------------------------------------------------------------------
 * - A thread pool is a set of worker threads that execute tasks.
 * - A dispatcher uses one or more thread pools (or a single thread) to run
 *   coroutines. Default and IO each have their own shared pool; Main uses
 *   one thread. You don't create pools manually for normal use; you pick
 *   the right dispatcher.
 *
 * ---------------------------------------------------------------------------
 * CUSTOM LIMITS (MODERN API)
 * ---------------------------------------------------------------------------
 * To limit parallelism (e.g. cap IO work): use
 *   Dispatchers.IO.limitedParallelism(n)
 * This is preferred over creating your own fixed thread pool.
 *
 * ---------------------------------------------------------------------------
 * DEPENDENCY
 * ---------------------------------------------------------------------------
 * Requires: kotlinx-coroutines-core (see build.gradle.kts).
 * Dispatchers.IO is JVM-specific; on other platforms (JS, Native) the
 * expect/actual may differ.
 */

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() = runBlocking {
    println("Main runs on: ${Thread.currentThread().name}\n")

    // -----------------------------------------------------------------------
    // Example 1: Same logical work on Default vs IO — see which thread runs
    // -----------------------------------------------------------------------
    launch(Dispatchers.Default) {
        println("[Default] Running on: ${Thread.currentThread().name}")
        delay(100)
        println("[Default] Still on:    ${Thread.currentThread().name}\n")
    }

    launch(Dispatchers.IO) {
        println("[IO]      Running on: ${Thread.currentThread().name}")
        delay(100)
        println("[IO]      Still on:    ${Thread.currentThread().name}\n")
    }

    delay(250)  // wait for both

    // -----------------------------------------------------------------------
    // Example 2a: withContext(Dispatchers.IO) — switch to IO for "blocking" work
    // -----------------------------------------------------------------------
    val resultIo = withContext(Dispatchers.IO) {
        println("[withContext(IO)] Simulating I/O on: ${Thread.currentThread().name}")
        simulateBlockingIo()
        "data from IO"
    }
    println("[Back to caller] Result: $resultIo, thread: ${Thread.currentThread().name}\n")

    // -----------------------------------------------------------------------
    // Example 2b: withContext(Dispatchers.Default) — switch to Default for CPU work
    // -----------------------------------------------------------------------
    val resultCpu = withContext(Dispatchers.Default) {
        println("[withContext(Default)] CPU work on: ${Thread.currentThread().name}")
        (1..1000).map { it * it }.sum().toString()  // light CPU work
    }
    println("[Back to caller] Result: $resultCpu, thread: ${Thread.currentThread().name}\n")

    // -----------------------------------------------------------------------
    // Example 3: When to use which (conceptual)
    // -----------------------------------------------------------------------
    CoroutineScope(Dispatchers.Default).launch {
        // CPU-bound: sorting, parsing, math — use Default
        val sorted = (1..100).shuffled().sorted()
        println("[Default] CPU work done: sorted ${sorted.size} items on ${Thread.currentThread().name}")
    }

    CoroutineScope(Dispatchers.IO).launch {
        // I/O-bound: file, network, DB — use IO (here we simulate with blocking sleep)
        simulateBlockingIo()
        println("[IO] I/O work done on ${Thread.currentThread().name}")
    }

    delay(1500)
    println("\nMain end")
}

/**
 * Simulates blocking I/O (e.g. file read, network). In real code you'd use
 * suspend-friendly APIs (e.g. withContext(Dispatchers.IO) { File.readBytes() }).
 * We use Thread.sleep here only to simulate a blocking call on the IO dispatcher.
 */
private fun simulateBlockingIo() {
    Thread.sleep(200)
}
