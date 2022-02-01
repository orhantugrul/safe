import dev.orhantugrul.safe.SafeString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author orhan tugrul
 */
public class SafeStringTest {
    @Test
    @DisplayName("Trim should return trimmed string")
    public void Trim_Should_ReturnTrimmedGivenString() {
        final String actual = SafeString.trim("   Gravy Train 🚂   ");
        assertEquals("Gravy Train 🚂", actual);
    }

    @Test
    @DisplayName("Trim should return empty string if given string is null")
    public void Trim_Should_ReturnEmptyString_When_GivenStringIsNull() {
        final String actual = SafeString.trim(null);
        assertEquals("", actual);
    }

    @Test
    @DisplayName("Trim should return default string if given string is null")
    public void Trim_Should_ReturnDefaultValue_When_GivenStringIsNull() {
        final String actual = SafeString.trim(null, "💪🏻");
        assertEquals("💪🏻", actual);
    }

    @Test
    @DisplayName("Length should return length of given string")
    public void Length_Should_ReturnLengthOfGivenString() {
        final Integer actual = SafeString.length("Gravy Train");
        assertEquals(11, actual);
    }

    @Test
    @DisplayName("Length should return zero(0) if given string is null")
    public void Length_Should_ReturnZero_When_GivenStringIsNull() {
        final Integer actual = SafeString.length(null, 0);
        assertEquals(0, actual);
    }

    @Test
    @DisplayName("Length should return default value if given string is null")
    public void Length_Should_ReturnDefaultValue_When_GivenStringIsNull() {
        final Integer actual = SafeString.length(null, Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, actual);
    }

    @Test
    @DisplayName("Substring should return substring of given string")
    public void Substring_Should_ReturnSubstringOfGivenString() {
        String actual = SafeString.substring("Gravy Train 🚂", 12);
        assertEquals("🚂", actual);
    }

    @Test
    @DisplayName("Substring should return empty string if given string is null")
    public void Substring_Should_ReturnEmptyString_When_GivenStringIsNull() {
        String actual = SafeString.substring(null, 1234545);
        assertEquals("", actual);
    }

    @Test
    @DisplayName("Substring should return substring of given string and range")
    public void Substring_Should_ReturnSubstringOfGivenStringAndRange() {
        final String actual = SafeString.substring("Gravy Train 🚂", 0, 5);
        assertEquals("Gravy", actual);
    }

    @Test
    @DisplayName("UpperCase should return upper case version of given string")
    public void UpperCase_Should_ReturnUpperCaseVersionOfGivenString() {
        final String actual = SafeString.upperCase("I'M thE ConTroLleR 🎮");
        assertEquals("I'M THE CONTROLLER 🎮", actual);
    }

    @Test
    @DisplayName("UpperCase should return empty string if given string is null")
    public void UpperCase_Should_ReturnGivenStringIfGivenStringIsNull() {
        final String actual = SafeString.upperCase(null);
        assertEquals("", actual);
    }

    @Test
    @DisplayName("LowerCase should return lowercase version of given string")
    public void LowerCase_Should_ReturnLowerCaseVersionOfGivenString() {
        final String actual = SafeString.lowerCase("I'M thE ConTroLleR 🎮");
        assertEquals("i'm the controller 🎮", actual);
    }

    @Test
    @DisplayName("LowerCase should return empty string if given string is null")
    public void LowerCase_Should_ReturnGivenStringIfGivenStringIsNull() {
        final String actual = SafeString.upperCase(null);
        assertEquals("", actual);
    }

    @Test
    @DisplayName("CharArray should return char array of given string")
    public void CharArray_Should_ReturnCharArrayOfGivenString() {
        final char[] expected = new char[]{'B', 'a', 'r', 'k', ' ', '\uD83D', '\uDC15'};
        final char[] actual = SafeString.charArray("Bark 🐕");

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("CharArray should return empty char array if given string is null")
    public void CharArray_Should_ReturnEmptyCharArrayIfGivenStringIsNull() {
        final char[] actual = SafeString.charArray(null);
        assertArrayEquals(new char[]{}, actual);
    }

    @Test
    @DisplayName("Chars should return char stream of given string")
    public void Chars_Should_ReturnCharStreamOfGivenString() {
        final long actual = SafeString.chars("Bark 🐕")
            .filter(Character::isAlphabetic)
            .count();

        assertEquals(4, actual);
    }
}
