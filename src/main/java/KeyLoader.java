import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class KeyLoader {

    // loads a key file and builds CipherKey for deciphering
    public CipherKey loadKey(String keyPath) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(keyPath));

        //line 1 = actual, line 2 = ciphered char
        String actual = reader.readLine();
        String cipher = reader.readLine();

        reader.close();

        // validation check: 2 lines, null/empty, length,
        if (actual == null || cipher == null) {
            throw new IllegalArgumentException("Key file must contain exactly 2 lines.");
        }

        if (actual.length() == 0) {
            throw new IllegalArgumentException("Key file lines cannot be empty.");
        }

        if (actual.length() != cipher.length()) {
            throw new IllegalArgumentException("Key file lines must be the same length.");
        }

        // cipherChar -> actualChar
        CipherKey key = new CipherKey();
        for (int i = 0; i < actual.length(); i++) {
            key.addMapping(cipher.charAt(i), actual.charAt(i));
        }

        return key;
    }
}
