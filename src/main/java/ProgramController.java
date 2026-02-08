import java.io.File;
import java.util.List;

public class ProgramController {
    private FileHandler fileHandler;
    private List<String> files;

    public ProgramController(FileHandler fh) {
        fileHandler = fh;
        files = fileHandler.listFiles();
    }

    public void execute(UserRequest request){
        switch (request.getSelection()) {
            case (-1):
                System.out.println("Try running the program again.");
                System.exit(0);
                break;
            case (0):
                handleList();
                break;
            default:
                handleShow(request.getSelection());

        }
    }

    public void handleList(){
        int idx = 1;
        for(String file : files){
            System.out.println(String.format("%02d\t%s", idx, file));
            idx++;
        }
    }
    private void handleShow(int idx){
        String output = files.get(idx-1);
        fileHandler.readFile(output);
    }
    private void printError(){
        System.out.println("Error ig. idk lol.");
    }
}