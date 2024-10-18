import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadInMembers {
    boolean isActive = false;

    protected List<Person> memberList = new ArrayList<>();
    String firstLine = new String();
    String secondLine = new String();
    String[] splitLine = new String[2];

    public ReadInMembers(List<Person> memberList) {
        this.memberList = memberList;
    }
    public ReadInMembers() {    }

    public List<Person> readIn(String fileName){

        try(Scanner sc = new Scanner(new FileReader(fileName))) {
            while(sc.hasNext()){
                Person medlem = new Person();
                firstLine = sc.nextLine();
                splitLine = firstLine.split(",");
                medlem.setPersonalId(splitLine[0].trim());
                medlem.setName(splitLine[1].trim());
                if(sc.hasNext()){
                    secondLine = sc.nextLine();
                    medlem.setMemberDate(LocalDate.parse(secondLine));

                }
                memberList.add(medlem);
            }
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return memberList;
    }


    public void createActiveList(List<Person> memberList, String out){
        Path p = Paths.get(out);

        try(PrintWriter pw = new PrintWriter(Files.newBufferedWriter(p))){
            for(Person member : memberList){
                if(member.getMemberDate().isAfter(LocalDate.now().minusDays(365))){
                    pw.write(member.getPersonalId() + ", " + member.getName() +
                            "\n" + member.getMemberDate() + "\n");
                }
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }


    public boolean checkActiveMembership(Person person) {
        if(person.getMemberDate().isAfter(LocalDate.now().minusDays(365))) {
            isActive = true;
        }
        else{
            isActive = false;
        }

        return isActive;
    }

}
