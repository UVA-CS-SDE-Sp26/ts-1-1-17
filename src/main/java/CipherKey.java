import java.util.HashMap;
import java.util.Map;

public class CipherKey {

    // cipherChar -> actualChar
    private final Map<Character, Character> decipherMap;

    public CipherKey() {
        this.decipherMap = new HashMap<>();
    }

    // cipherChar decrypts to actualChar
    public void addMapping(char cipherChar, char actualChar) {
        decipherMap.put(cipherChar, actualChar);
    }

    // return the decrypted character or null
    public Character get(char cipherChar) {
        return decipherMap.get(cipherChar);
    }
}
