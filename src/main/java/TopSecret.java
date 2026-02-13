import javax.crypto.Cipher;
import java.io.IOException;

/**
 * Commmand Line Utility
 */
public class TopSecret {
    public static void main(String[] args) throws IOException {
        CommandLineParser parser = new CommandLineParser(args);
        String selection = parser.placeholder;

        FileHandler fileHandler = new FileHandler();
        fileHandler.terminalDataDir();
        ProgramController programController = new ProgramController(fileHandler);
        UserRequest userRequest = new UserRequest(selection);
        String text = programController.execute(userRequest);

        if (args.length == 3) {
            KeyLoader keyLoader = new KeyLoader();
            CipherKey cipherKey = keyLoader.loadKey(args[3]);
            CipherService cipherService = new CipherService();
            text = cipherService.decipher(text, cipherKey);
        }
        System.out.println(text);
    }
}
