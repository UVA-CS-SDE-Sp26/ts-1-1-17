/**
 * Commmand Line Utility
 */
public class TopSecret {
    public static void main(String[] args) {
        CommandLineParser placeholderParser = new CommandLineParser(args);
        String selection = placeholderParser.placeholder;

        FileHandler fileHandler = new FileHandler();
        ProgramController programController = new ProgramController(fileHandler);
        UserRequest userRequest = new UserRequest(selection);

        programController.execute(userRequest);
    }
}
