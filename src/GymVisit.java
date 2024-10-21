import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GymVisit {
    Person person;
    LocalDate visit;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void addNewGymVisit(Person person, LocalDate visit, Path p) {
        this.person = person;
        this.visit = visit;
        String visitFormatted = dtf.format(visit);

        try(FileWriter fw = new FileWriter(String.valueOf(p), true)){
            fw.write(person.getPersonalId() + ", " + person.getName() +
                    "\n" + visitFormatted + "\n");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
