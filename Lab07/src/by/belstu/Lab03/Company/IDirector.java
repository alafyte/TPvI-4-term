package by.belstu.Lab03.Company;

import by.belstu.Lab03.Staff.Worker;

import java.util.ArrayList;

// Интерфейс
public interface IDirector {
    int countWorkers(Company company);
    ArrayList<Worker> sortBySalary(Company company);
    ArrayList<Worker> searchByExp(Company company, int experience);
}
