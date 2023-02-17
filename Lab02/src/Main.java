import by.belstu.it.Prename.TextFunction;

/**
 * @author author
 * @version 1.1
 * */
public class Main {
    /**
     * @param args - аргументы
     * */
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // TODO Add new method
        TextFunction testFunction = new TextFunction();
        sayHello();
        for (int i = 0; i < 9; i++) {
            if (i == 6) continue;
            System.out.println(i);
        }

        for (int counter = 0; counter < 10; counter++) {
            System.out.println("Counter " + counter);
        }

    }

    private static void sayHello() {
        String str = "Hello, Java";
        System.out.println(str);
    }
}