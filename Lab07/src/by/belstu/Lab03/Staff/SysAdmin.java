package by.belstu.Lab03.Staff;

public class SysAdmin extends Worker {
    public SysAdmin() {
        super();
    }

    public SysAdmin(String surname, String name, int age, int salary, int experience) {
        super(surname, name, age, salary, experience);
    }
    @Override
    public String toString() {
        return "SysAdmin{" +
                "surname='" + super.getSurname() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", salary=" + super.getSalary()+
                ", experience=" + super.getExperience() + "}";
    }
}
