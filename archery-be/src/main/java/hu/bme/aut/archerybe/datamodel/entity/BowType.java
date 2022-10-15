package hu.bme.aut.archerybe.datamodel.entity;

public enum BowType {
    TRADITIONAL("traditional"),
    HUNTING_RECURVE("hunting_recurve"),
    OLYMPIC_RECURVE("olympic_recurve"),
    COMPOUND("compound");

    private final String value;

    BowType(String value) {
        this.value = value;
    }

    public static BowType fromValue(String value) {
        for (BowType b : BowType.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
