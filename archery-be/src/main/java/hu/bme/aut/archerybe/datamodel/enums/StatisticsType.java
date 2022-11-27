package hu.bme.aut.archerybe.datamodel.enums;

public enum StatisticsType {
    USER_SCOPE("user_scope"),
    TRAINING_SCOPE("training_scope");

    private final String value;

    StatisticsType(String value) {
        this.value = value;
    }

    public static StatisticsType fromValue(String value) {
        for (StatisticsType s : StatisticsType.values()) {
            if (s.value.equals(value)) {
                return s;
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
