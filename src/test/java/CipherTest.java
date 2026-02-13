import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CipherTest {

    @Test
    void loadKey() throws IOException {
        // check loading key w/ a new string and a temp file
        String keyData = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890\n" +
                "qwertyuiopasdfghjklzxcvbnm1234567890";

        KeyLoader loader = new KeyLoader();
        //added io exception to fix error
        CipherKey key = loader.loadKey(keyData);

        // a b and numeric 0
        assertEquals('q', key.get('a'));
        assertEquals('w', key.get('b'));
        assertEquals('1', key.get('0'));
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