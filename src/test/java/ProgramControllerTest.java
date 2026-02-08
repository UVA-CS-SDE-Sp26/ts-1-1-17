import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramControllerTest {

    @Test
    void execute() {

    }

    @Test
    void handleList() {
        FileHandler fh = new FileHandler();
        ProgramController pc = new ProgramController(fh);
        pc.handleList();
    }

    @Test
    void handleShow() {
        FileHandler fh = new FileHandler();
        ProgramController pc = new ProgramController(fh);
        pc.handleShow(3);
    }
}