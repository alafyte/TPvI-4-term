package by.belstu.lab13.util;

public enum Page {
    LOGIN_PAGE("/login.jsp"),
    REGISTER_PAGE("/register.jsp"),
    WELCOME_PAGE ("/welcome.jsp"),
    ERROR_PAGE ("/errorPage.jsp");
    private final String value;
    Page(String value) {
        this.value = value;
    }
    public String getPage() {
        return value;
    }

}
