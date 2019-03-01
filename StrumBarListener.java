/**
 * Represents a listener of the strum bar
 * @author Callum Browne
 */
public interface StrumBarListener extends GuitarStateChangeListener {
    /**
     * The method to be called when the strum bar changes state
     */
    public void strumBarEventReceived(StrumBarEvent event);
}
