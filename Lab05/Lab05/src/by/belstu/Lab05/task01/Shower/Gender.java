package by.belstu.Lab05.task01.Shower;

public enum Gender {
    Woman("Женский"),
    Man("Мужской");

    private String gender;
    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
