package by.belstu.lab13.repository;

public enum UserTableConstants {
    ID("id"),
    LOGIN("User_Login"),
    PASSWORD("User_Password"),
    ROLE("User_Role");
    private String fieldName;
    private UserTableConstants(String fieldName) {
        this.fieldName = fieldName;
    }
    public String getFieldName() {
        return fieldName;
    }

}
