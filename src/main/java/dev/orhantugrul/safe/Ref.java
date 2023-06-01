package dev.orhantugrul.safe;

import dev.orhantugrul.safe.Maybe.Just;
import dev.orhantugrul.safe.Maybe.Nothing;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * The {@code Ref} class provides utility methods for creating instances of {@link Maybe} objects.
 * <p>{@code Ref} is a final utility class with a private constructor to prevent instantiation, as
 * it only contains static methods.</p>
 *
 * @author orhan tugrul
 */
public final class Ref {
  /**
   * This class should not be instantiated.
   *
   * @throws UnsupportedOperationException if an attempt is made to instantiate the class.
   */
  private Ref() {
    throw new UnsupportedOperationException();
  }

  /**
   * Creates a {@link Maybe} object from a {@link Supplier}.
   * <p>The {@code from} method takes a {@link Supplier} as input and returns a {@link Maybe}
   * object. It first checks if the supplier is not null using {@link Optional#ofNullable(Object)}.
   * If the supplier is not null, it invokes the supplier's {@link Supplier#get()} method to obtain
   * a value. Then, it creates a {@link Just} instance with the obtained value using
   * {@link Just#Just(Object)}. If the supplier is null or the obtained value is null, it creates a
   * {@link Nothing} instance using {@link Nothing#Nothing()}.</p>
   *
   * @param supplier the supplier to obtain the value from.
   * @param <T>      the type of the value.
   * @return a {@link Maybe} object that may contain a value or be empty.
   */
  public static <T> Maybe<T> from(final Supplier<T> supplier) {
    return Optional.ofNullable(supplier)
        .map(Supplier::get)
        .<Maybe<T>>map(Just::new)
        .orElseGet(Nothing::new);
  }
}
