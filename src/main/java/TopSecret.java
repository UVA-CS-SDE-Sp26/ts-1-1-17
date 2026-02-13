/**
 * Commmand Line Utility
 */
public class TopSecret {
    public static void main(String[] args) {
        CommandLineParser parser = new CommandLineParser(args);
        String selection = parser.placeholder;

        FileHandler fileHandler = new FileHandler();
        fileHandler.terminalDataDir();
        ProgramController programController = new ProgramController(fileHandler);
        UserRequest userRequest = new UserRequest(selection);

        System.out.println(programController.execute(userRequest));
    }
}
