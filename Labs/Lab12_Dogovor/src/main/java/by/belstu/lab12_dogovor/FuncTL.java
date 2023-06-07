package tl;

public class FuncTL {
    public static boolean validate(String str) {
        boolean res;
        if (str.isEmpty()) {
            res = false;
        } else {
            // используем регулярное выражение для валидации
            res = str.matches("\\d{4,6}/21-[A-Z]{4}");
        }
        return res;
    }
}
