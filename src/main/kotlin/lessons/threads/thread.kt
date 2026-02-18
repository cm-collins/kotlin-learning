/**
 * THREADS — Basic concurrency with kotlin.concurrent.thread
 *
 * - thread { } starts a new JVM thread and runs the lambda inside it.
 * - The main thread does not wait for the thread to finish; it continues immediately.
 * - So you'll see "Finished blocking code" (main) before "Thread end" (worker).
 *
 * Use case: offload heavy or blocking work so the main thread stays responsive.
 *
 * ---------------------------------------------------------------------------
 * WHEN AND HOW THREADS ARE USED
 * ---------------------------------------------------------------------------
 *
 * WHEN to use threads:
 * - Work that takes noticeable time (CPU-heavy or I/O) and must not block the
 *   caller (e.g. UI, request handler).
 * - Running several tasks logically in parallel (multiple threads / thread pools).
 *
 * ---------------------------------------------------------------------------
 * MOBILE DEVELOPMENT (Android)
 * ---------------------------------------------------------------------------
 * - There is a single MAIN (UI) thread. Only it may touch views; blocking it
 *   causes freezes and "Application Not Responding" (ANR).
 * - Heavy work must run OFF the main thread: file/DB reads, network calls,
 *   image decoding, parsing, heavy computation.
 *
 * How it's used:
 * - thread { } or ExecutorService to run work in the background.
 * - Then post results BACK to the main thread to update UI, e.g.:
 *     runOnUiThread { textView.text = result }
 *     or Handler(Looper.getMainLooper()).post { ... }
 *
 * In modern Android/Kotlin, coroutines (with Dispatchers.Main / IO / Default)
 * are usually preferred over raw threads: less boilerplate, cancellation,
 * and structured concurrency. Threads are still the low-level building block.
 *
 * ---------------------------------------------------------------------------
 * OTHER NECESSARY AREAS
 * ---------------------------------------------------------------------------
 * - Backend / servers: handle each request on a thread (or from a pool) so
 *   one slow request doesn't block others; I/O and CPU work off the
 *   request thread.
 * - Desktop apps: same idea — keep UI thread free; do file/network work on
 *   worker threads, then update UI on the main thread.
 * - Games / media: one thread for rendering (e.g. 60 FPS), others for
 *   physics, loading assets, or audio.
 * - Any app doing I/O (disk, network): do the blocking I/O on a background
 *   thread so the rest of the app stays responsive.
 *
 * ---------------------------------------------------------------------------
 * PARALLELISM VS CONCURRENCY
 * ---------------------------------------------------------------------------
 *
 * CONCURRENCY
 * - Multiple tasks can make progress over a period of time; they may be
 *   interleaved (e.g. one thread runs, then another) rather than at the
 *   exact same instant.
 * - Goal: structure the program so that several logical tasks can advance
 *   without blocking each other (e.g. UI stays responsive while I/O runs).
 * - This lesson demonstrates CONCURRENCY: main thread and worker thread
 *   both make progress; the main thread doesn't wait for blockingCode() to
 *   finish before printing "Finished blocking code".
 *
 * PARALLELISM
 * - Multiple tasks actually execute at the same time (e.g. multiple CPU
 *   cores running different threads simultaneously).
 * - A subset of concurrency: you get parallelism when you have multiple
 *   threads/processes and enough CPU cores to run them at once.
 * - Example: splitting a huge list across 4 threads and each thread
 *   processes a chunk on its own core = parallel + concurrent.
 *
 * In this file we use one extra thread, so we have concurrency (two threads
 * making progress). On a multi-core machine the OS may run them in parallel;
 * on a single core they are concurrent (interleaved). For mobile/backend,
 * "don't block the main/request thread" is the main concurrency concern;
 * parallelism is an optimization when you have heavy CPU work to spread.
 */

import kotlin.concurrent.thread

fun main() {
    println("Starting blocking code")

    // Start a background thread. Main thread returns right after this.
    thread {
        println("Thread start")
        blockingCode()
        println("Thread end")
    }

    thread {
        println("Thread start")
        blockingCode()
        println("Thread end")
    }

    // This runs on the main thread, almost immediately (does not wait for the thread above).
    println("Finished blocking code")
}

/**
 * Simulates blocking / CPU-heavy work: map over 50M integers and square each.
 * "Blocking" here means it takes a long time; running it in a thread avoids
 * freezing the main thread (e.g. UI or server request handler).
 */
fun blockingCode() {
    (1..50_000_000).map { it * it }
    println("Finished blocking code")
}




