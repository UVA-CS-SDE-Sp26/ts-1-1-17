import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileHandler {
    private final Path dataDir;

    public FileHandler(){
        this.dataDir = Paths.get("../../../data"); // there's gotta be a better way :(
    }

    public List<String> listFiles(){ // found format for this on https://www.baeldung.com/java-list-directory-files
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

    public String readFile(String filename){
        String fileOut="";
        File reading= new File(filename); //format for this found on https://www.w3schools.com/java/java_files_read.asp
        try (Scanner scan = new Scanner(reading)){
            while(scan.hasNextLine()){
                fileOut+=scan.nextLine();
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found.");
            e.printStackTrace();
        }
        return fileOut;
    }

    public Path getDataDir() {
        return dataDir;
    }
}
