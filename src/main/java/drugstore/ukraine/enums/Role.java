package drugstore.ukraine.enums;

public enum Role {
    ADMIN("ROLE_ADMIN"),
    CUSTOMER("ROLE_CUSTOMER");

    private final String role;

  Role(String role) {
        this.role = role;
    }


    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return role;
    }
}
