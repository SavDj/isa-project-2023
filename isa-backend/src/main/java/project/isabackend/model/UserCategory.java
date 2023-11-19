package project.isabackend.model;

public enum UserCategory{
    REGULAR("Regular"), SILVER("Silver"), GOLD("Gold");

    public final String value;

    private UserCategory(String value) {
        this.value = value;
    }
}
