package Company;

// Интерфейс
public interface IDirector {
    int countWorkers(Company company);
    void sortBySalary(Company company);
    void searchByExp(Company company, int experience);
}
