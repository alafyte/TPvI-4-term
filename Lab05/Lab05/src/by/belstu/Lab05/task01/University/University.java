package by.belstu.Lab05.task01.University;

import static java.lang.Thread.currentThread;

public class University {
    private boolean firstDoor = true;
    private boolean secondDoor = true;

    public void useDoor(Student student) {
        long start = System.currentTimeMillis();
        long end = start + 7000;
        System.out.println("Студент " + student.getStudentName() + " подошел(а) к двери " + student.getInitialDoor());

        synchronized(this) {
            int currentDoor = student.getInitialDoor();
            switch (currentDoor) {
                case 1 -> {
                    while (!firstDoor) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    try {
                        while (System.currentTimeMillis() < end) {
                            try {
                                firstDoor = false;
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            firstDoor = true;
                            notify();
                            currentThread().interrupt();
                            throw new InterruptedException();
                        }
                        if (System.currentTimeMillis() > end) {
                            System.out.println("Студент " + student.getStudentName() + " поменял(а) дверь");
                            student.setInitialDoor(2);
                            useDoor(student);
                        }
                    }
                    catch(InterruptedException e) {
                        String action = student.isLeaving() ? "вышел(а)" : "зашел(а)";
                        System.out.println("Студент " + student.getStudentName() + " " + action + " через дверь 1");
                    }
                }
                case 2 -> {
                    while (!secondDoor) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    try {
                        while (System.currentTimeMillis() < end) {
                            try {
                                secondDoor = false;
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            secondDoor = true;
                            notify();
                            currentThread().interrupt();
                            throw new InterruptedException();
                        }
                        if (System.currentTimeMillis() > end) {
                            System.out.println("Студент " + student.getStudentName() + " поменял(а) дверь");
                            student.setInitialDoor(1);
                            useDoor(student);
                        }
                    }
                    catch(InterruptedException e) {
                        String action = student.isLeaving() ? "вышел(а)" : "зашел(а)";
                        System.out.println("Студент " + student.getStudentName() + " " + action + " через дверь 2");
                    }
                }
            }
        }
    }
}
