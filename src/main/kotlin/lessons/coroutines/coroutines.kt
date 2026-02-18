/**
 * COROUTINES — Structured concurrency with suspend functions and launch
 *
 * ---------------------------------------------------------------------------
 * WHAT ARE COROUTINES?
 * ---------------------------------------------------------------------------
 * - Lightweight concurrency: many coroutines can run on a few threads.
 * - You write sequential-looking code that can suspend (pause) without blocking
 *   the thread, then resume later.
 * - Built on top of the same threading model you saw in thread.kt; coroutines
 *   are a higher-level, more manageable way to do async work.
 *
 * ---------------------------------------------------------------------------
 * WHY COROUTINES INSTEAD OF RAW THREADS?
 * ---------------------------------------------------------------------------
 * - Less overhead: thousands of coroutines are cheap; thousands of threads are not.
 * - Structured concurrency: child coroutines are tied to a scope; when the scope
 *   is cancelled or finishes, children are cancelled too — no orphan work.
 * - Cancellation: built-in cooperative cancellation (job.cancel()).
 * - Simpler code: suspend instead of block; no callbacks or manual thread sync.
 * - On Android: lifecycleScope and viewModelScope automatically cancel when
 *   the Activity/ViewModel is destroyed, so you don't leak work.
 *
 * ---------------------------------------------------------------------------
 * KEY BUILDING BLOCKS IN THIS FILE
 * ---------------------------------------------------------------------------
 *
 * - suspend fun: A function that can suspend (e.g. delay, or call another
 *   suspend function). Only callable from a coroutine or another suspend function.
 *
 * - runBlocking: Blocks the current thread and runs the block as a coroutine.
 *   Use in main() or tests so the program waits for coroutines. On Android
 *   you typically don't use runBlocking in production UI code (you use
 *   lifecycleScope, viewModelScope, etc.).
 *
 * - CoroutineScope + launch: Starts a new coroutine that runs concurrently.
 *   launch { } returns a Job; you can call job.join() to wait for it.
 *
 * - async + await: async { } starts a coroutine and returns a Deferred<T> (like
 *   a "future" result). await() (or .await()) gets the value and suspends until
 *   it's ready. Use when you need a result back; use launch when you don't.
 *
 * - Dispatchers: Which thread(s) the coroutine uses.
 *   - Dispatchers.Default: CPU-bound work (shared pool). Use in this JVM
 *     console app because Dispatchers.Main is not available without a UI
 *     framework (e.g. Android or Swing).
 *   - On Android: Dispatchers.Main (UI), Dispatchers.IO (disk/network),
 *     Dispatchers.Default (CPU work).
 *
 * - withContext(Dispatchers.XXX) { }: Switches the current coroutine to another
 *   dispatcher for the block, then switches back. Common pattern: withContext(Dispatchers.IO) { readFile() }.
 *
 * - delay(ms): Suspends the coroutine for the given time without blocking
 *   the thread. Used here to simulate slow work (e.g. cooking).
 *
 * ---------------------------------------------------------------------------
 * STRUCTURED CONCURRENCY
 * ---------------------------------------------------------------------------
 * - A scope (e.g. CoroutineScope(Dispatchers.Default)) has a lifecycle. When
 *   you launch { } inside it, the child is bound to that scope.
 * - If the scope is cancelled (or the block finishes and the scope is not
 *   globalScope), child coroutines are cancelled. That prevents leaking work.
 * - In Example 2, the two inner launch { } are children of the same parent;
 *   concurrentJob.join() waits for the parent, which waits for all children.
 *
 * ---------------------------------------------------------------------------
 * SEQUENTIAL VS CONCURRENT VS ASYNC/AWAIT
 * ---------------------------------------------------------------------------
 *
 * Example 1 — Sequential: One coroutine does rice, then chicken. Total time
 * is roughly 3s + 4s = 7s.
 *
 * Example 2 — Concurrent (launch): Two child coroutines run at the same time
 * (rice and chicken in parallel). Total time is roughly max(3s, 4s) = 4s.
 * We use job.join() so main waits for both before printing "Main end".
 *
 * Example 3 — Concurrent (async/await): Same idea as Example 2, but we use
 * async { } when we want to run work and get a result back. Here we "return"
 * a string when each task is done; we await both and then continue. Total
 * time again ~4s. Use async when you need the result; use launch when you
 * only need to run and wait.
 *
 * ---------------------------------------------------------------------------
 * CANCELLATION (BRIEF)
 * ---------------------------------------------------------------------------
 * - job.cancel() cancels the job and its children (cooperative: the coroutine
 *   must check cancellation or call suspend functions that throw on cancel).
 * - delay() is cancellable; a tight loop without suspend is not. See official
 *   docs for "Cancellation and cooperative cancellation".
 *
 * ---------------------------------------------------------------------------
 * DEPENDENCY
 * ---------------------------------------------------------------------------
 * Requires: org.jetbrains.kotlinx:kotlinx-coroutines-core (see build.gradle.kts)
 */

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("Main start")

    // -----------------------------------------------------------------------
    // Example 1: SEQUENTIAL — one coroutine, steps one after the other
    // -----------------------------------------------------------------------
    val sequentialJob = CoroutineScope(Dispatchers.Default).launch {
        println("  [Sequential] Starting rice")
        cookRice()
        println("  [Sequential] Rice done")
        println("  [Sequential] Starting chicken")
        cookChicken()
        println("  [Sequential] Chicken done")
    }
    sequentialJob.join()  // wait for this coroutine to finish (~7 seconds total)

    // -----------------------------------------------------------------------
    // Example 2: CONCURRENT — two coroutines at the same time
    // -----------------------------------------------------------------------
    val concurrentJob = CoroutineScope(Dispatchers.Default).launch {
        launch {
            println("  [Concurrent] Starting rice")
            cookRice()
            println("  [Concurrent] Rice done")
        }
        launch {
            println("  [Concurrent] Starting chicken")
            cookChicken()
            println("  [Concurrent] Chicken done")
        }
    }
    concurrentJob.join()  // wait for both child coroutines (~4 seconds total)

    // -----------------------------------------------------------------------
    // Example 3: CONCURRENT with async/await — when you need results back
    // -----------------------------------------------------------------------
    val scope = CoroutineScope(Dispatchers.Default)
    val riceDeferred = scope.async {
        cookRice()
        "Rice"
    }
    val chickenDeferred = scope.async {
        cookChicken()
        "Chicken"
    }
    val results = awaitAll(riceDeferred, chickenDeferred)  // suspends until both done (~4s)
    println("  [Async] Done: $results")

    println("Main end")
}

/** Simulates slow work (e.g. cooking). Suspends without blocking the thread. */
suspend fun cookRice() {
    delay(3000)
}

/** Simulates slow work. Only call from a coroutine or another suspend function. */
suspend fun cookChicken() {
    delay(4000)
}
