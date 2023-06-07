package model;

public class Table {
    private int year;
    private int sum;
    public Table() {

    }
    public Table(int year, int sum) {
        this.year = year;
        this.sum = sum;
    }
    // getters and setters
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getSum() {
        return sum;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }
}
