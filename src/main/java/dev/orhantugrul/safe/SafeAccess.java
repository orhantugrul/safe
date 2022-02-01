package dev.orhantugrul.safe;

import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

import static java.util.Optional.ofNullable;

/**
 * @author orhan tugrul
 */
public class SafeAccess {
    private SafeAccess() {}

    public static <T> T get(
        final @NotNull Supplier<T> supplier,
        final @NotNull T other
    ) {
        return ofNullable(supplier.get()).orElse(other);
    }

    public static <T> T getOrElse(
        final @NotNull Supplier<T> supplier,
        final @NotNull Supplier<T> orElse
    ) {
        return ofNullable(supplier.get()).orElseGet(orElse);
    }

    public static <T, E extends Throwable> T getOrThrow(
        final @NotNull Supplier<T> supplier,
        final @NotNull Supplier<? extends E> exception
    ) throws E {
        return ofNullable(supplier.get()).orElseThrow(exception);
    }
}

