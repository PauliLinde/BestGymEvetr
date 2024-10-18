import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GymVisitTest {
    Person p1 = new Person("Paulina Linderborg", "9211131234");
    Visit v1 = new Visit(LocalDate.parse("2024-09-17"));
    Visit v2 = new Visit(LocalDate.parse("2024-09-29"));
    GymVisit gv1 = new GymVisit();
    GymVisit gv2 = new GymVisit();
    Path p = Paths.get("Test/gymvisit.txt");

    @Test
    public void addNewGymVisitTest() throws IOException {
        gv1.addNewGymVisit(p1, v1, p);
        gv2.addNewGymVisit(p1, v2, p);

        String testInput = Files.readString(p);
        assertTrue(testInput.contains("Paulina Linderborg"));
        assertTrue(testInput.contains("2024-09-17"));

    }


}
