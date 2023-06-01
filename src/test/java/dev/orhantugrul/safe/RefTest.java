package dev.orhantugrul.safe;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import dev.orhantugrul.safe.Maybe.Just;
import dev.orhantugrul.safe.Maybe.Nothing;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author orhan tugrul
 */
class RefTest {
  @Test
  @DisplayName("Should Ref.class primary constructor throw exception when try to invoke it")
  void shouldThrowException_WhenTryInvokeRefConstructor() throws Exception {
    final var getConstructor = Ref.class.getDeclaredConstructor();
    getConstructor.setAccessible(true);

    assertThatThrownBy(getConstructor::newInstance)
        .isInstanceOf(InvocationTargetException.class);
  }

  @Test
  @DisplayName("Should Ref#from return Just when supplied non-null reference")
  void shouldRefFromReturnJust_WhenSuppliedNonNullReference() {
    assertThat(Ref.from(() -> "λ")).isEqualTo(new Just<>("λ"));
  }

  @Test
  @DisplayName("Should Ref#from return Nothing when supplied null reference")
  void shouldRefFromReturnNothing_WhenSuppliedNullReference() {
    assertThat(Ref.from(() -> null)).isEqualTo(new Nothing<>());
    assertThat(Ref.from(null)).isEqualTo(new Nothing<>());
  }
}
