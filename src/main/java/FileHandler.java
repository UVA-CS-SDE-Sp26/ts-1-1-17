import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileHandler {
    private Path dataDir;
    private final CipherService cipherService;
    private final KeyLoader keyLoader;


    public FileHandler() {
        this(Paths.get("./data"), new CipherService(), new KeyLoader());
    }

    public FileHandler(Path dataDir, CipherService cipherService, KeyLoader keyLoader) {
        this.dataDir = dataDir;
        this.cipherService = cipherService;
        this.keyLoader = keyLoader;
    }

    public void terminalDataDir() {
        this.dataDir = Paths.get("../../../data");
    }

    public List<String> listFiles() {
        if (!Files.exists(dataDir) || !Files.isDirectory(dataDir)) {
            throw new IllegalStateException("Data directory not found: " + dataDir.toAbsolutePath());
        }

        try (Stream<Path> files = Files.list(dataDir)) {
            return files
                    .filter(Files::isRegularFile)
                    .map(path -> path.getFileName().toString())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error reading data directory", e);
        }
    }

    public String readFile(String filename) {
        return readFile(filename, null);
    }

    public String readFile(String filename, String keyPath) {
        try {
            Path filePath = dataDir.resolve(filename);
            String encryptedText = Files.readString(filePath);

            Path keyFile = (keyPath == null || keyPath.isBlank())
                    ? Paths.get("ciphers/key.txt")
                    : Paths.get(keyPath);

            CipherKey key = keyLoader.loadKey(keyFile.toString());
            return cipherService.decipher(encryptedText, key);

        } catch (IOException e) {
            throw new RuntimeException("Error reading/deciphering file: " + filename, e);
        }
    }

    public Path getDataDir() {
        return dataDir;
    }
}
