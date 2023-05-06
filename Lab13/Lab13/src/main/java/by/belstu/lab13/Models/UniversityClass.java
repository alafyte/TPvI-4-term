package by.belstu.lab13.Models;

public class UniversityClass {
    private int classId;
    private String className;
    private String classDay;
    private String classHours;

    public UniversityClass() { }

    public UniversityClass(int classId, String className, String classDay, String classHours) {
        this.classId = classId;
        this.className = className;
        this.classDay = classDay;
        this.classHours = classHours;
    }

    public UniversityClass(String className, String classDay, String classHours) {
        this.className = className;
        this.classDay = classDay;
        this.classHours = classHours;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassDay() {
        return classDay;
    }

    public void setClassDay(String classDay) {
        this.classDay = classDay;
    }

    public String getClassHours() {
        return classHours;
    }

    public void setClassHours(String classHours) {
        this.classHours = classHours;
    }

    @Override
    public boolean equals(Object obj) {
        UniversityClass uc = (UniversityClass) obj;
        return uc.getClassDay() == this.getClassDay() && uc.getClassId() == this.getClassId()
                && uc.getClassHours() == this.getClassHours() && uc.getClassName() == this.getClassName();
    }
}
