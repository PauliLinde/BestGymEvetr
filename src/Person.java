import java.time.LocalDate;

public class Person {
    private String name, personalId;
    private LocalDate memberDate;

    Person(String name, String personalId, LocalDate memberDate) {
        this.name = name;
        this.personalId = personalId;
        this.memberDate = memberDate;
    }
    Person(String name, String personalId) {
        this.name = name;
        this.personalId = personalId;
    }
    Person(){}

    public LocalDate getMemberDate() {
        return memberDate;
    }

    public void setMemberDate(LocalDate memberDate) {
        this.memberDate = memberDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }
}
