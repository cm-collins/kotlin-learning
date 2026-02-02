package interop;

import java.util.Arrays;
import java.util.List;

/**
 * LESSON 14 (Java side): PLATFORM TYPES DEMO
 *
 * This class intentionally does NOT use nullability annotations
 * (@Nullable/@NotNull).
 * Kotlin will treat many types coming from this class as "platform types" (e.g.
 * String!).
 *
 * Platform types mean:
 * - Kotlin doesn't know if the value can be null
 * - You can assign it to String OR String? in Kotlin
 * - If it is actually null and you treat it as non-null, you can crash at
 * runtime.
 */
public final class Lesson14JavaPlatformApi {
    private Lesson14JavaPlatformApi() {
    }

    public static String getPossiblyNullNickname(boolean returnNull) {
        // Returning null here is legal in Java, even though the return type is String.
        return returnNull ? null : "JavaNick";
    }

    public static List<String> getTags() {
        // Kotlin sees this as List<String!>! (platform types in generics too)
        return Arrays.asList("kotlin", "java", "interop");
    }
}
