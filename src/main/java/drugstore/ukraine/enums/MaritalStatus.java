package drugstore.ukraine.enums;

public enum MaritalStatus {
    SINGLE("SINGLE"),
    MARRIED("MARRIED"),
    DIVORCED("DIVORCED");

    private final String maritalStatus;

    public String getMaritalStatus() {
        return maritalStatus;
    }

    MaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @Override
    public String toString() {
        return maritalStatus;
    }
}
