package by.belstu.it.Prename.basejava;
import java.util.Random;

/* Использовать пакеты by.belstu.it.фамилия.basejava. Создайте в нем класс
JavaTest c методом main. В дальнейшем запускайте main*/

/**
 * @author author
 * @version 1.1
 * */
public class JavaTest {
    static int sint;  // выведите значение без инициализации
    /**The value of this constant is {@value}*/
    public static final double PI = 3.14;
    public final int constantValue = 295;
    /**
     * @param args - аргументы
     * */
    public static void main(String[] args) {
        //3b. Определить переменные типа char, int, short, byte, long, boolean.
        System.out.println("\t\t3b");
        char charVar = 'F';
        int intVar = 139;
        short shortVar = 27;
        byte byteVar = 78;
        long longVar = 346674L;
        boolean booleanVar = true;
        String stringVar = "Hello ";
        double doubleVar = 386.25;

        System.out.println("String + int: " + (stringVar + intVar));
        System.out.println("String + char: " + (stringVar + charVar));
        System.out.println("String + double: " + (stringVar + doubleVar));

        byte byteSum = (byte) (byteVar + intVar);
        System.out.println("byte + int: " + byteSum);
        int IntSum = (int) (doubleVar + longVar);
        System.out.println("double + long: " + IntSum);
        long longSum = (long) intVar + 2147483647;
        System.out.println("int + 2147483647: " + longSum);
        System.out.println("static int: " + sint);

        boolean booleanAnd = booleanVar && !booleanVar;
        System.out.println("boolean(true) && boolean(false): " + booleanAnd);
        boolean booleanOr = booleanVar ^ !booleanVar;
        System.out.println("boolean(true) ^ boolean(false): " + booleanOr);
        // ошибка: нельзя складывать булевые значения
        // boolean booleanSum = booleanVar + !booleanVar;

        long var1 = 9223372036854775807L;
        long var2 = 0x7fff_ffff_ffffL;

        char charVar1 = 'a', charVar2 = '\u0061', charVar3 = 97;
        System.out.println("'a' + \u0061 + 97 = " + charVar1 + charVar2 + charVar3);

        System.out.println("3.45 % 2.4 = " + (3.45 % 2.4));
        System.out.println("1.0 / 0.0 = " + (1.0 / 0.0));
        System.out.println("0.0 / 0.0 = " + (0.0 / 0.0));
        System.out.println("log(-345) = " + Math.log(-345));
        System.out.println("Float.intBitsToFloat(0x7F800000) = " + Float.intBitsToFloat(0x7F800000));
        System.out.println("Float.intBitsToFloat(0xFF800000) = " + Float.intBitsToFloat(0xFF800000));
        System.out.println("Целые константы можно записывать в СС: 2, 10, 16\n");

        System.out.println("\t\t3d");
        System.out.println("Значение Math.PI: " + Math.PI);
        System.out.println("Значение Math.E: " + Math.E);
        System.out.println("Округленное Math.PI: " + Math.round(Math.PI));
        System.out.println("Округленное Math.E: " + Math.round(Math.E));
        System.out.println("Минимальное из PI и E: " + Math.min(Math.PI, Math.E));
        System.out.println("Случайное число из диапазона [0,1): ");
        double start = 0.0;
        double end = 1.0;
        double random = new Random().nextDouble();
        double result = start + (random * (end - start));
        System.out.println(result);

        System.out.println("\t\t3e");
        Boolean boolO = true;
        Character charO = 'Q';
        Integer intO = 391;
        Byte byteO = (byte) 56;
        Short shortO = (short) 268;
        Long longO = 7453432462L;
        Double doubleO = 543.2;
        System.out.println("\tОператоры:");
        System.out.println("395 >>> 1 (беззнаковый сдвиг): " + (intO >>> 1));
        System.out.println("-10 >>> 1 (беззнаковый сдвиг): " + (-10 >>> 1));
        System.out.println("395 >> 1 (знаковый сдвиг): " + (intO >> 1));
        System.out.println("-10 >> 1 (знаковый сдвиг): " + (-10 >> 1));
        System.out.println("~125 (не): " + (~(125)));
        System.out.println("127 & 11 = " + (127 & 11));
        System.out.println("true && true = " + (boolO && true));
        System.out.println("true && false = " + (boolO && !boolO));
        System.out.println("true || true = " + (boolO || !boolO));
        System.out.println("byte + short = " + (byteO + shortO));
        System.out.println("int + long = " + (intO + longO));

        System.out.println("\tLong, Double:");
        System.out.println("Long.MAX_VALUE: " + (Long.MAX_VALUE));
        System.out.println("Long.MIN_VALUE: " + (Long.MIN_VALUE));

        System.out.println("Double.MAX_VALUE: " + (Double.MAX_VALUE));
        System.out.println("Double.MIN_VALUE: " + (Double.MIN_VALUE));

        // упаковка и распаковка для Integer и Byte
        Integer boxed_int = 19;              // автоупаковка
        int unbox_int = boxed_int; // распаковка

        Byte boxed_byte = 16;
        byte unbox_byte = boxed_byte;

        System.out.println("\tInteger:");
        System.out.println("ParseInt('170'): " + (Integer.parseInt("170")));
        System.out.println("ParseInt('170', 16): " + (Integer.parseInt("170",16)));

        System.out.println("toString(523): " + (Integer.toString(523)));
        System.out.println("toHexString(742): " + (Integer.toHexString(742)));
        System.out.println("compare(10, 17): " + (Integer.compare(10,17)));
        System.out.println("compare(17, 17): " + (Integer.compare(17,17)));
        System.out.println("compare(17, 10): " + (Integer.compare(17,10)));
        System.out.println("intO.compareTo(17): " + (intO.compareTo(17)));
        System.out.println("bitCount(127): " + (Integer.bitCount(127)));

        System.out.println("\t\t3f");
        String s34 = "2345";

        System.out.println("Integer.valueOf(s34): " + (Integer.valueOf(s34)));
        //System.out.println("new Integer(s34): " + (new Integer(s34)));
        System.out.println("Integer.parseInt(s34): " + (Integer.parseInt(s34)));

        byte[] strArr = s34.getBytes();
        System.out.println("массив байтов из строки: " + strArr);

        String newS34 = new String(strArr);
        System.out.println("из байтов в строку: " + newS34);

        // строка в логический тип 2мя способами
        System.out.println("1: " + Boolean.valueOf(s34));
        System.out.println("2: " + Boolean.getBoolean(s34));
        System.out.println("3: " + Boolean.parseBoolean(s34));

        String str1 = "hello";
        String str2 = "hello";
        System.out.println("== : " + (str1 == str2));
        System.out.println("equals: " + (str1.equals(str2)));
        System.out.println("compareTo: " + (str1.compareTo(str2)));
        str2 = null;
        System.out.println("== : " + (str1 == str2));
        System.out.println("equals: " + (str1.equals(str2)));
        // исключение
        //System.out.println("compareTo: " + (str1.compareTo(str2)));

        String myStr = "i'm out of my head";
        System.out.println("оригинал строки: " + myStr);
        String[] my_split = myStr.split(" ");
        for (String a : my_split)
            System.out.println(a);
        System.out.println("hashCode: " + myStr.hashCode());
        System.out.println("indexOf: " + myStr.indexOf("of"));     // индекс первого символа подстроки в строке
        System.out.println("length: " + myStr.length());
        System.out.println("replace: " + myStr.replace("head", "mind"));
        System.out.println();

        System.out.println("\t\t3g");
        char[][] c1;
        char[] c2[];
        char c3[][];

        int zeroArr[] = new int [0];
        // исключение: выход за пределы
        //System.out.println(zeroArr[5]);

        // c1
        c1 = new char[3][];
        c1[0] = new char[0];
        c1[1] = new char[1];
        c1[2] = new char[2];
        System.out.println("длина массива: " + c1.length);
        System.out.println("длина строки 0: " + c1[0].length);
        System.out.println("длина строки 1: " + c1[1].length);
        System.out.println("длина строки 2: " + c1[2].length);

        c2 = new char[][] {{'1','2','3'}, {'4','5','6'}, {'7','8','9'}};
        c3 = new char[][] {{'1','2','3'}, {'4','5','6'}, {'7','8','9'}};
        boolean comRez = c2 == c3;
        System.out.println(comRez);
        c2 = c3;
        System.out.println(c2 == c3);
        for (char[] inner_arr: c2) {
            for (char cell: inner_arr) {
                System.out.println(cell);
            }
        }

        String test = "Hello Wolrd!";
        WrapperString testWrapp = new WrapperString(test);
        testWrapp.replace('l','i');

        var testWrapp2 = new WrapperString(test) {
            @Override
            public void replace(char oldChar, char newChar) {
                System.out.println(test.replace(oldChar, newChar));
            }
            public void delete(String newChar) {
                System.out.println(test.replace(newChar, ""));
            }
        };
        testWrapp2.replace('l', 'i');
        testWrapp2.delete("llo");
    }
}
