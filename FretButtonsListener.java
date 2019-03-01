/**
 * Represents a listener of the fret buttons
 * @author Callum Browne
 */
public interface FretButtonsListener extends GuitarListener {
    /**
     * The method to be called when the fret buttons change state
     */
    public void fretButtonsEventReceived(GuitarEvent event);
}
