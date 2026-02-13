import java.io.File;
import java.util.List;

public class ProgramController {
    private FileHandler fileHandler;
    private List<String> files;

    public ProgramController(FileHandler fh) {
        fileHandler = fh;
        files = fileHandler.listFiles();
    }

    public String execute(UserRequest request){
        String out = "";
        switch (request.getSelection()) {
            case (-1):
                System.out.println("Try running the program again.");
                System.exit(0);
                break;
            case (0):
                out = handleList();
                break;
            default:
                out = handleShow(request.getSelection());
        }
        return out;
    }

    public String handleList(){
        String ret = "";
        int idx = 1;
        for(String file : files){
            ret += String.format("%02d\t%s\n", idx, file);
            idx++;
        }
        return ret;
    }
    public String handleShow(int idx){
        String output = files.get(idx - 1);
        return fileHandler.readFile(output);
    }

    private void printError(){
        System.out.println("Error ig. idk lol.");
    }
}