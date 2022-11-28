package hu.bme.aut.archerybe.datamodel.enums;

public enum Location {
    INDOORS("indoors"),
    OUTDOORS("outdoors");

    private final String value;

    Location(String value) {
        this.value = value;
    }

    public static Location fromValue(String value) {
        for (Location l : Location.values()) {
            if (l.value.equals(value)) {
                return l;
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
