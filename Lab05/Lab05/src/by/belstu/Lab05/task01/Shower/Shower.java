package by.belstu.Lab05.task01.Shower;

import java.util.Random;

public class Shower {
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    private static final int SHOWER_CAPACITY = 3;
    private int currentPeopleNumber = 0;
    private Gender currentGender;
    public void takeShower(Person person) {
        System.out.println(person.getPersonName() + " в очереди в душ");
        synchronized (this) {

            checkCurrentGender(person.getGender());

            while (currentPeopleNumber >= SHOWER_CAPACITY || currentGender != person.getGender()) {
                try {
                    if (currentPeopleNumber == 0) {
                        break;
                    }
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            checkCurrentGender(person.getGender());
            currentPeopleNumber++;
            System.out.println(GREEN + person.getPersonName() + " зашел(а) в душ. " +
                    "Кол-во людей в душе: " + currentPeopleNumber + ", текущий пол: " + currentGender.getGender() + RESET);
        }

        // Время у каждого разное
        long timeForPerson = (long) 1000 * (new Random().nextInt(1, 6) + 1);
        try {
            Thread.sleep(timeForPerson);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        synchronized (this) {
            person.interrupt();
            currentPeopleNumber--;
            System.out.println(BLUE + person.getPersonName() + " закончил(а) принимать душ. Кол-во людей в душе: "
                    + currentPeopleNumber + RESET);
            notifyAll();
        }
    }
    private void checkCurrentGender(Gender gender) {
        if (currentPeopleNumber == 0) {
            currentGender = gender;
        }
    }
}
