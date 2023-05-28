package by.belstu.Lab05.task01.University;

public class Student extends Thread {
    University university;
    String studentName;
    boolean isLeaving;
    int initialDoor;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String name) {
        this.studentName = name;
    }

    public boolean isLeaving() {
        return isLeaving;
    }

    public void setLeaving(boolean leaving) {
        isLeaving = leaving;
    }

    public int getInitialDoor() {
        return initialDoor;
    }

    public void setInitialDoor(int initialDoor) {
        if (initialDoor != 1 && initialDoor != 2) {
            throw new IllegalArgumentException();
        }
        else {
            this.initialDoor = initialDoor;
        }
    }

    public Student(String name, boolean isLeaving, int initialDoor, University university) {
        this.studentName = name;
        this.isLeaving = isLeaving;
        this.initialDoor = initialDoor;
        this.university = university;
    }

    public void run() {
        university.useDoor(this);
    }
}
