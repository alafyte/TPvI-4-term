package Staff;

public class Engineer extends Worker {
    public Engineer() {
        super();
    }

    public Engineer(String surname, String name, int age, int salary, int experience) {
        super(surname, name, age, salary, experience);
    }

    @Override
    public String toString() {
        return "Engineer{" +
        "surname='" + super.getSurname() + '\'' +
        ", name='" + super.getName() + '\'' +
        ", age=" + super.getAge() +
        ", salary=" + super.getSalary()+
        ", experience=" + super.getExperience() + "}";
    }
}
