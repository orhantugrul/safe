package dev.orhantugrul.safe;

import java.util.stream.IntStream;

import static java.util.Optional.ofNullable;

/**
 * @author orhan tugrul
 */
public class SafeString {
    private SafeString() {}

    public static String trim(final String string) {
        return trim(string, "");
    }

    public static String trim(final String string, final String orElse) {
        return ofNullable(string).map(String::trim).orElse(orElse);
    }

    public static Integer length(final String string) {
        return length(string, 0);
    }

    public static Integer length(final String string, final Integer orElse) {
        return ofNullable(string).map(String::length).orElse(orElse);
    }

    public static String substring(final String string, final Integer start) {
        return ofNullable(string)
            .map((value) -> value.substring(start))
            .orElse("");
    }

    public static String substring(
        final String string,
        final Integer start,
        final Integer end
    ) {
        return ofNullable(string)
            .map((value) -> value.substring(start, end))
            .orElse("");
    }

    public static String upperCase(final String string) {
        return ofNullable(string).map(String::toUpperCase).orElse("");
    }

    public static String lowerCase(final String string) {
        return ofNullable(string)
            .map(String::toLowerCase)
            .orElse("");
    }

    public static char[] charArray(final String string) {
        return ofNullable(string).map(String::toCharArray).orElse(new char[]{});
    }

    public static IntStream chars(final String string) {
        return ofNullable(string).map(String::chars).orElse(IntStream.empty());
    }
}
