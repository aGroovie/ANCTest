package drugstore.ukraine.enums;

public enum Status {
    VIP("VIP"),
    REGULAR("REGULAR");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return status;
    }
}
