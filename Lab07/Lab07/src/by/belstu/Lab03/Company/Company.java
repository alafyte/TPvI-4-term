package by.belstu.Lab03.Company;
import by.belstu.Lab03.Staff.Worker;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Company {
    private static final Logger LOG = Logger.getLogger(Company.class);

    private String companyName;
    ArrayList<Worker> staff = new ArrayList<>();
    public Company() {
    }

    public Company(String companyName) {
        this.companyName = companyName;
    }

    // Вложенный класс
    public class Director implements IDirector {
        private String name;

        public String getName() {
            return name;
        }

        public Director(String name) {
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int countWorkers(Company com) {
            ArrayList<Worker> arr = com.getStaff();
            LOG.info("Пересчет сотрудников");
            return arr.size();
        }

        @Override
        public ArrayList<Worker> sortBySalary(Company com) {
            ArrayList<Worker> arr = com.getStaff();
            if(arr.size() == 0) {
                LOG.error("Список сотрудников пуст");
                throw new NullPointerException("Null pointer");
            }
            arr.sort((o1, o2) -> o1.getSalary() > o2.getSalary() ? -1
                        : o1.getSalary() < o1.getSalary() ? 1 : 0);
            LOG.info("Сортировка по зарплате");
            return arr;
        }

        @Override
        public ArrayList<Worker> searchByExp(Company com, int exp) {
            if(com == null) {
                LOG.error("Компания не существует");
                throw new NullPointerException("Null pointer");
            }
            ArrayList<Worker> arr = com.getStaff();
            ArrayList<Worker> result = new ArrayList<Worker>();
            if(arr.size() == 0) {
                LOG.error("Список сотрудников пуст");
                throw new NullPointerException("Null pointer");
            }
            for (Worker worker: arr) {
                if(worker.getExperience() == exp)
                    result.add(worker);
            }
            LOG.info("Поиск по опыту работы");
            return result;
        }
    }
    public ArrayList<Worker> getStaff() {
        return staff;
    }
    public void addWorker(Worker worker) {
        if (worker == null) {
            LOG.error("Сотрудник не существует");
            throw new NullPointerException("Null pointer");
        }
        this.staff.add(worker);
        LOG.info("Добавлен сотрудник");
    }
    public void setStaff(ArrayList<Worker> staff) {
        if(staff.size() == 0) {
            LOG.error("Список сотрудников пуст");
            throw new NullPointerException("Null pointer");
        }
        this.staff = staff;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", staff=" + staff +
                '}';
    }
}
