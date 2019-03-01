/**
 * Represents a listener of the bender button
 * @author Callum Browne
 */
public interface BenderButtonListener extends GuitarListener {
    /**
     * The method to be called when the bender button changes state
     */
    public void benderButtonEventReceived(GuitarEvent event);
}
