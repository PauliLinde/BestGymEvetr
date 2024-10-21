import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReadInMembersTest {
    Person person1 = new Person("9007161234", "Kalle Nilsson", LocalDate.now().minusMonths(3));
    Person person2 = new Person("8305271234", "Anna Svensson", LocalDate.parse("2022-07-12"));

    Path p = Paths.get("Test/allactivememberstest.txt");


    @Test
    public void readInMembersTest(){
        ReadInMembers rim = new ReadInMembers();
        rim.readIn("Test/allmemberstest.txt");

        assertEquals(rim.memberList.size(), 2);
        assertEquals("Anna Andersson", rim.memberList.get(0).getName());
        assertEquals(rim.memberList.get(1).getPersonalId(), "8505132345");
        assertTrue(rim.memberList.get(0).getMemberDate().isEqual(LocalDate.parse("2023-05-03")));
    }

   @Test
    public void createActiveListTest() throws IOException {
       List<Person> memberTestList = new ArrayList<>();
       memberTestList.add(person1);
       memberTestList.add(person2);

       ReadInMembers r = new ReadInMembers(memberTestList);
        r.createActiveList(memberTestList, String.valueOf(p));

        String testInput = Files.readString(p);

        assertTrue(testInput.contains("Kalle Nilsson"));
        assertFalse(testInput.contains("Diamanda Djedi"));
    }

    @Test
    public void checkActiveMembershipTest() throws IOException {
        ReadInMembers rr = new ReadInMembers();

        boolean isActive1 = rr.checkActiveMembership(person1);
        boolean isActive2 = rr.checkActiveMembership(person2);

        assertTrue(isActive1);
        assertFalse(isActive2);
    }
}
