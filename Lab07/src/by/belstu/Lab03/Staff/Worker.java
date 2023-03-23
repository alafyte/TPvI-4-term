package by.belstu.Lab03.Staff;

// Абстрактный класс
public abstract class Worker {
    private String surname;
    private String name;
    private int age;
    private int salary;
    private int experience;

    public Worker() {
    }

    public Worker(String surname, String name, int age, int salary, int experience) {
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.experience = experience;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", experience=" + experience +
                '}';
    }
}
