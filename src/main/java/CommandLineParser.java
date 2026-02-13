// used stack overflow for the "//D" regex so it can check file for it only has numbers
public class CommandLineParser {
    public String placeholder;

    public CommandLineParser(String[] args) {
        if (args == null || args.length == 0) {
            placeholder = "";  // emptyy place holder
            return;
        }

        if (args.length > 2) {
            printUsage();
            placeholder = "-1";
            return;
        }

        String fileArg = args[0]; //number check

        if (!fileArg.matches("\\d+")) {
            printUsage();
            placeholder = "-1";
            return;
        }

        placeholder = fileArg;
    }

    private static void printUsage() {  // prints to termnal status of
        System.out.println("Usage:");
        System.out.println("  java topsecret");
        System.out.println("  java topsecret <fileNumber>");
        System.out.println("  java topsecret <fileNumber> <keyFile>");
    }
}


