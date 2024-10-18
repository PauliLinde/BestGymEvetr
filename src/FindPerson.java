import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class FindPerson {
    ReadInMembers rim = new ReadInMembers();
    GymVisit gv = new GymVisit();
    Visit visit = new Visit(LocalDate.now());
    Path p;

    String input = new String();


    private List<Person> memberList;

    public FindPerson(List<Person> memberList, Path p) {
        this.memberList = memberList;
        this.p = p;
    }


    public boolean checkMembership(String input) {
        boolean isMember = false;
        for (Person member : memberList) {
            if ((member.getName().equalsIgnoreCase(input) || member.getPersonalId().equalsIgnoreCase(input))) {
                boolean isActive = rim.checkActiveMembership(member);
                if (isActive) {
                    JOptionPane.showMessageDialog(null, "Active member");
                    gv.addNewGymVisit(member, visit, p);
                } else if(!isActive) {
                    JOptionPane.showMessageDialog(null, "Inactive member");
                }
                isMember = true;
                break;
            }
        }
        if (!isMember) {
            JOptionPane.showMessageDialog(null, "Member does not exist");
        }
        return isMember;
    }
}
