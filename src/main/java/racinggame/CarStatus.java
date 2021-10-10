package racinggame;

public enum CarStatus {
    STOP, ADVANCE;

    public boolean isAdvance() {
        return this == ADVANCE;
    }
}
