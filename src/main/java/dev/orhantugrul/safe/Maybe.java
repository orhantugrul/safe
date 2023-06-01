package dev.orhantugrul.safe;


/**
 * The {@code Maybe} interface represents a sealed hierarchy of classes. It provides two
 * implementations: {@link Just} and {@link Nothing}.
 * <p>{@code Maybe} is serves as a container for holding either a non-null value (represented by
 * {@link Just}) or no value (represented by {@link Nothing}).</p>
 *
 * @param <T> the type of the value.
 * @author orhan tugrul
 */
public sealed interface Maybe<T> {
  /**
   * The {@code Just} class represents a {@link Maybe} object that contains a non-null value.
   *
   * @param <T> the type of the value.
   */
  record Just<T>(T value) implements Maybe<T> {}

  /**
   * The {@code Nothing} class represents a {@link Maybe} object that does not contain a value.
   *
   * @param <T> the type of the value.
   */
  record Nothing<T>() implements Maybe<T> {}
}
