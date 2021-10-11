package racinggame;

/**
 * @author Jo Guk <jjozerg@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public enum CarStatus {
    STOP, ADVANCE;

    public boolean isAdvance() {
        return this == ADVANCE;
    }
}
