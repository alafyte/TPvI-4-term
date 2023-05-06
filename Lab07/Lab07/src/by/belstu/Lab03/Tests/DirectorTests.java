package by.belstu.Lab03.Tests;

import by.belstu.Lab03.Company.Company;
import by.belstu.Lab03.Staff.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class DirectorTests {
    private Company company;
    private Company.Director director;
    private Engineer engineer;
    private SysAdmin sysAdmin;
    private Programmer programmer1;
    private Programmer programmer2;
    private Programmer programmer3;
    private final int NUMBER_OF_WORKERS = 5;

    @BeforeTest
    public void Init() {
        company = new Company();
        director = company.new Director("Bill Gates");
        engineer = new Engineer("Симонов", "Андрей", 20, 5, 3);
        sysAdmin = new SysAdmin("Иванов", "Иван", 28, 3000, 6);
        programmer1 = new Programmer("Петров", "Петр", 27, 4000,
                7, ProgType.Middle);
        programmer2 = new Programmer("Васильев", "Василий", 30, 4500,
                10, ProgType.Senior);
        programmer3 = new Programmer("Данилевич", "Анастасия", 29, 4500,
                10, ProgType.Senior);
        company.addWorker(engineer);
        company.addWorker(sysAdmin);
        company.addWorker(programmer1);
        company.addWorker(programmer2);
        company.addWorker(programmer3);
    }
    @AfterTest
    public void Clear() {
        director = null;
        company = null;
    }
    @BeforeMethod
    public void BeforeMethod() {
        System.out.println("Тест метода");
    }

    @AfterMethod
    public void AfterMethod() {
        System.out.println("Тест метода окончен");
    }

    @BeforeSuite
    public void BeforeSuite() {
        System.out.println("Запуск тестов");
    }

    @AfterSuite
    public void AfterSuite() {
        System.out.println("Тесты окончены");
    }

    @BeforeClass
    public void BeforeClass() {
        System.out.println("Тест класса");
    }

    @AfterClass
    public void AfterClass() {
        System.out.println("Тест класса окончен");
    }

    @Test
    public void TestCountWorkers() {
        Assert.assertEquals(NUMBER_OF_WORKERS, director.countWorkers(company));
    }
    @Test
    public void TestSearchExp1() {
        ArrayList<Worker> expected = new ArrayList<>();
        expected.add(programmer2);
        expected.add(programmer3);

        ArrayList<Worker> actual = director.searchByExp(company, 10);
        Assert.assertEquals(expected, actual);
    }
    @Test(timeOut = 1000)
    public void TestSortBySalary() {
        ArrayList<Worker> expected = new ArrayList<>();
        expected.add(programmer2);
        expected.add(programmer3);
        expected.add(programmer1);
        expected.add(sysAdmin);
        expected.add(engineer);

        ArrayList<Worker> actual = director.sortBySalary(company);
        Assert.assertEquals(expected, actual);
    }

    @Ignore
    public void TestSearchExp2() {
        ArrayList<Worker> expected = new ArrayList<>();
        expected.add(sysAdmin);

        ArrayList<Worker> actual = director.searchByExp(company, 6);
        Assert.assertEquals(expected, actual);
    }

    @DataProvider(name = "testdata")
    public Object[][] createData1() {
        Company company1 = new Company();
        ArrayList<Worker> list1 = new ArrayList<>();
        list1.add(programmer3);
        list1.add(programmer2);
        company1.setStaff(list1);
        Company company2 = new Company();
        ArrayList<Worker> list2 = new ArrayList<>();
        list2.add(sysAdmin);
        list2.add(engineer);
        list2.add(programmer1);
        company2.setStaff(list2);
        Company company3 = new Company();
        ArrayList<Worker> list3 = new ArrayList<>();
        list3.add(sysAdmin);
        company3.setStaff(list3);
        return new Object[][] {
                { company1, 2 },
                { company2, 3 },
                { company3, 1 },
        };
    }
    @Test(dataProvider = "testdata")
    public void TestCount(Company company, int numberOfWorkersExpected) {
        Assert.assertEquals(numberOfWorkersExpected, director.countWorkers(company));
    }
}
