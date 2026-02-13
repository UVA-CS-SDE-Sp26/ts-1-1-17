import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramControllerTest {

    @Test
    void execute() {
        String expected = """
                01\tObjectOriented.txt
                02\tTJQuote.txt
                03\tQuickBrown.txt
                04\tinput1\n""";
        FileHandler fh = new FileHandler();
        ProgramController pc = new ProgramController(fh);
        String args = "";
        UserRequest ur = new UserRequest(args);
        String actual = pc.execute(ur);
        assertEquals(expected, actual);
        System.out.println(actual);
    }

    @Test
    void handleList() {
        String expected = """
                01\tObjectOriented.txt
                02\tTJQuote.txt
                03\tQuickBrown.txt
                04\tinput1\n""";
        FileHandler fh = new FileHandler();
        ProgramController pc = new ProgramController(fh);
        assertEquals(expected.replaceAll("\\s+", " "),pc.handleList().replaceAll("\\s+", " "));
        System.out.println(pc.handleList());
    }

    @Test
    void handleShow() {
        String expected = "The quick brown fox jumps over the lazy dog";
        FileHandler fh = new FileHandler();
        ProgramController pc = new ProgramController(fh);
        assertEquals(expected, pc.handleShow(3));
        System.out.println(pc.handleShow(3));
    }
}