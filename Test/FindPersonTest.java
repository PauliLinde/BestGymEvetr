import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindPersonTest {

    Person person1 = new Person("9007161234", "Kalle Nilsson", LocalDate.now().minusMonths(3));
    Person person2 = new Person("8305271234", "Anna Svensson", LocalDate.parse("2022-07-12"));

    Path p = Paths.get("Test/gymvisit.txt");
    @Test
    public void checkMembershipTest() {
        boolean isTest = true;
        List<Person> memberTestList = new ArrayList<>();
        memberTestList.add(person1);
        memberTestList.add(person2);

        FindPerson fp = new FindPerson(memberTestList, p);

        boolean isMember1 = fp.checkMembership(isTest, "Kalle Nilsson");
        boolean isMember2 = fp.checkMembership(isTest, "8305271234");
        boolean isMember3 = fp.checkMembership(isTest, "Karin Lindemark");

        assertTrue(isMember1);
        assertTrue(isMember2);
        assertFalse(isMember3);
    }

}
