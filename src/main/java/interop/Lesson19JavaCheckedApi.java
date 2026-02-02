package interop;

import java.io.IOException;

/**
 * LESSON 19 (Java side): CHECKED EXCEPTION DEMO
 *
 * Java has checked exceptions (e.g., IOException) that must be declared.
 * Kotlin does not force you to catch or declare them.
 */
public final class Lesson19JavaCheckedApi {
    private Lesson19JavaCheckedApi() {
    }

    public static String alwaysThrowsIOException() throws IOException {
        throw new IOException("Simulated IO failure from Java");
    }
}
