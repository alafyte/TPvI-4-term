package by.belstu.Lab03.Staff;

public class Programmer extends Worker {
    private ProgType type;

    public Programmer() {
        super();
    }

    public Programmer(String surname, String name, int age, int salary, int experience, ProgType type) {
        super(surname, name, age, salary, experience);
        this.type = type;
    }

    public ProgType getType() {
        return type;
    }

    public void setType(ProgType type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "Programmer{" +
                "surname='" + super.getSurname() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", salary=" + super.getSalary()+
                ", experience=" + super.getExperience() + "}";
    }
}
