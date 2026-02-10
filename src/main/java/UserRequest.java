import java.util.Scanner;

public class UserRequest {
    private int selection;

    public UserRequest(String input) {
        if (input.length() == 0) {
            selection = 0;
            return;
        }
        try {
            selection = Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid input: " + input + " is not an integer.");
            selection = -1;
        }
    }

    public int getSelection() {
        return selection;
    }

    public void setSelection(int selection) {
        this.selection = selection;
    }
}
