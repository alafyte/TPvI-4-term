package by.belstu.Lab05.task01.University;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        University university = new University();
        List<Student> students = new ArrayList<>();
        students.add(new Student("Мария", true, 1, university));
        students.add(new Student("Игорь", false, 2, university));
        students.add(new Student("Владислав", true, 2, university));
        students.add(new Student("Кирилл", true, 1, university));
        students.add(new Student("Юлия", false, 2, university));
        students.add(new Student("Дарья", false, 1, university));
        students.add(new Student("Антон", true, 1, university));
        students.add(new Student("Илья", false, 2, university));
        students.add(new Student("Олег", false, 1, university));

        for (Student student : students) {
            student.start();
        }
    }
}
