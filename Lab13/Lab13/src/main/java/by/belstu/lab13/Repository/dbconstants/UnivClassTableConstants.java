package by.belstu.lab13.Repository.dbconstants;

public enum UnivClassTableConstants {
    ID("ClassId"),
    NAME("ClassName"),
    DAY("ClassDay"),
    HOURS("ClassHours");
    private String fieldName;
    private UnivClassTableConstants(String fieldName) {
        this.fieldName = fieldName;
    }
    public String getFieldName() {
        return fieldName;
    }

}
