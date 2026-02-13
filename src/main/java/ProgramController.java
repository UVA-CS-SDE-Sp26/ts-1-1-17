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

        try {
            String output = files.get(idx-1);
            return fileHandler.readFile(output);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Error: Index " + idx + " is out of bounds. Current list size is " + files.size() + ".");
            System.out.println("Try again please.");
            System.exit(0);
        }
        return "";

    }

    private void printError(){
        System.out.println("Error ig. idk lol.");
    }
}