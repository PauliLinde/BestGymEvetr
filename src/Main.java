import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    Main(){
        String input = new String();
        String fileName = "src/allmembers.txt";
        String out = "src/activemembers.txt";
        Path personalTrainer = Paths.get("src/gymvisit.txt");
        ReadInMembers ri = new ReadInMembers();

        List<Person> memberList = new ArrayList<>();
        memberList = ri.readIn(fileName);
        FindPerson findPerson = new FindPerson(memberList, personalTrainer);
        ri.createActiveList(memberList, out);

        while(true){
            if(input==null || input==""){
                break;
            }
            input = JOptionPane.showInputDialog(null, "Enter name or personalId to check membership");
            findPerson.checkMembership(input);
        }


    }


    public static void main(String[] args) {
       Main main = new Main();

    }
}