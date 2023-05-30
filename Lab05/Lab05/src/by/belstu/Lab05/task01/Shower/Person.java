package by.belstu.Lab05.task01.Shower;

public class Person extends Thread {
    private String personName;
    private Gender gender;
    private Shower shower;
    public Person(String personName, Gender gender, Shower shower) {
        this.gender = gender;
        this.shower = shower;
        this.personName = personName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Shower getShower() {
        return shower;
    }

    public void setShower(Shower shower) {
        this.shower = shower;
    }

    @Override
    public void run() {
        shower.takeShower(this);
    }
}
