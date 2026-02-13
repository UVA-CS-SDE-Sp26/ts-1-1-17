//import jdk.internal.org.jline.utils.StyleResolver
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class CipherTest {
    @TempDir
    Path tempDir;

    @Test
    void loadKey() throws Exception {


        // check loading key w/ a new string and a temp file
        String keyData = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890\n" +
                "bcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890a";
        Path keyFile = tempDir.resolve("key.txt");
        Files.writeString(keyFile, keyData);
        KeyLoader loader = new KeyLoader();
        //added io exception to fix error
        CipherKey key = loader.loadKey(keyFile.toString());

        // a b and numeric 0
        assertEquals('0', key.get('a'));
        assertEquals('a', key.get('b'));
        assertEquals('9', key.get('0'));
    }

    @Test
    void decipher() {
        // dummy cipher key obj (abc) -> (qwe)
        CipherKey key = new CipherKey();
        key.addMapping('a', 'q');
        key.addMapping('b', 'w');
        key.addMapping('c', 'e');

        CipherService service = new CipherService();

        String result = service.decipher("abc", key);
        assertEquals("qwe", result);
    }

    @Test
    void addMapping() {
        CipherKey key = new CipherKey();

        key.addMapping('a', 'q');
        key.addMapping('b', 'w');
        key.addMapping('c', 'e');

        assertEquals('q', key.get('a'));
        assertEquals('w', key.get('b'));
        assertEquals('e', key.get('c'));
    }

    @Test
    void get() {
        CipherKey key = new CipherKey();

        key.addMapping('a', 'q');
        key.addMapping('b', 'w');

        assertEquals('q', key.get('a'));
        assertEquals('w', key.get('b'));

        // check if return for null with unmapped values
        assertNull(key.get('c'));
    }
}