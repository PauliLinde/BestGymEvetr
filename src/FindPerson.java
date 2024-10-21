import javax.swing.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

public class FindPerson {
    ReadInMembers rim = new ReadInMembers();
    GymVisit gv = new GymVisit();
    LocalDate visit = LocalDate.now();
    Path p;
    String input = new String();

    private List<Person> memberList;

    public FindPerson(List<Person> memberList, Path p) {
        this.memberList = memberList;
        this.p = p;
    }

//Här lade jag till för att välja om det är test eller inte, om det är test skrivs inte informationen ut
    public boolean checkMembership(boolean isTest, String input) {
        boolean isMember = false;
        for (Person member : memberList) {
            if ((member.getName().equalsIgnoreCase(input) || member.getPersonalId().equalsIgnoreCase(input))) {
                boolean isActive = rim.checkActiveMembership(member);
                if (isActive) {
                    if(!isTest) {
                        JOptionPane.showMessageDialog(null, "Active member");
                    }
                    gv.addNewGymVisit(member, visit, p);
                } else if(!isActive) {
                    if(!isTest) {
                        JOptionPane.showMessageDialog(null, "Inactive member");
                    }
                }
                isMember = true;
                break;
            }
        }
        if (!isMember) {
            if(!isTest) {
                JOptionPane.showMessageDialog(null, "Member does not exist");
            }
        }
        return isMember;
    }
}
