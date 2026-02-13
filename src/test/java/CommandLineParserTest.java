import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommandLineParserTest {

    @Test
    void noArgs_setsListMode() {
        CommandLineParser parser = new CommandLineParser(new String[]{});
        assertEquals("", parser.placeholder);
    }

    @Test
    void validNumber_keptAsPlaceholder() {
        CommandLineParser parser =
                new CommandLineParser(new String[]{"01"});
        assertEquals("01", parser.placeholder);
    }

    @Test
    void invalidNonNumeric_setsError() {
        CommandLineParser parser =
                new CommandLineParser(new String[]{"abc"});
        assertEquals("-1", parser.placeholder);
    }

    @Test
    void tooManyArgs_setsError() {
        CommandLineParser parser =
                new CommandLineParser(new String[]{"01","key","extra"});
        assertEquals("-1", parser.placeholder);
    }

    @Test
    void twoArgs_validStillAccepted() {
        CommandLineParser parser =
                new CommandLineParser(new String[]{"02","key.txt"});
        assertEquals("02", parser.placeholder);
    }
}
