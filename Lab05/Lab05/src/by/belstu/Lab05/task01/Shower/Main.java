package by.belstu.Lab05.task01.Shower;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Shower shower = new Shower();
        List<Person> people = new ArrayList<>();
        people.add(new Person("Илья", Gender.Man, shower));
        people.add(new Person("Мария", Gender.Woman, shower));
        people.add(new Person("Антон", Gender.Man, shower));
        people.add(new Person("Владислав", Gender.Man, shower));
        people.add(new Person("Юлия", Gender.Woman, shower));
        people.add(new Person("Илона", Gender.Woman, shower));
        people.add(new Person("Константин", Gender.Man, shower));
        people.add(new Person("Андрей", Gender.Man, shower));
        people.add(new Person("Олег", Gender.Man, shower));
        people.add(new Person("Алина", Gender.Woman, shower));

        for (var person : people) {
            person.start();
        }
    }
}
