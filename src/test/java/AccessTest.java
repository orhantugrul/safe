import dev.orhantugrul.safe.SafeAccess;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author orhan tugrul
 */
public class AccessTest {
    @Test
    @DisplayName("Get should get other value when supplier is null")
    public void Get_Should_GetOtherValue_When_SupplierIsNull() {
        final String foo = SafeAccess.get(() -> null, "🎉");
        assertEquals("🎉", foo);
    }

    @Test
    @DisplayName("GetOrElse should get second supplier when first supplier is null")
    public void GetOrElse_Should_GetSecondSupplier_When_FirstSupplierIsNull() {
        final String bar = SafeAccess.getOrElse(() -> null, () -> "🐊");
        assertEquals("🐊", bar);
    }

    @Test
    @DisplayName("GetOrElseThrow should throw exception when supplier is null")
    public void GetOrElseThrow_Should_ThrowException_When_SupplierIsNull() {
        final Executable executable = () ->
            SafeAccess.getOrThrow(() -> null, IllegalArgumentException::new);

        assertThrows(IllegalArgumentException.class, executable);
    }
}
