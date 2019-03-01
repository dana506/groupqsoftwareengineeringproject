/**
 * Represents a listener of the escape button
 * @author Callum Browne
 */
public interface EscapeButtonListener extends GuitarStateChangeListener {
    /**
     * The method to be called when the escape button changes state
     */
    public void escapeButtonEventReceived(EscapeButtonEvent event);
}
