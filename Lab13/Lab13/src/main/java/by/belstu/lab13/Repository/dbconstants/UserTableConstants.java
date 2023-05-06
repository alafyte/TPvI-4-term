package by.belstu.lab13.Repository.dbconstants;

public enum UserTableConstants {
    ID("ID"),
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
