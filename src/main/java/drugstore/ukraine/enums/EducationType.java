package drugstore.ukraine.enums;

public enum EducationType {
    HIGH_SCHOOL("HIGH_SCHOOL"),
    UNIVERSITY("UNIVERSITY"),
    COLLEGE("COLLEGE");

    private final String type;

    EducationType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
      return  type;
    }
}
