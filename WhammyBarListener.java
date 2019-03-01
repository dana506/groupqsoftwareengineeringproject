/**
 * Represents a listener of the whammy bar
 * @author Callum Browne
 */
public interface WhammyBarListener extends GuitarListener {
    /**
     * The method to be called when the whammy bar changes state
     */
    public void whammyBarEventReceived(GuitarEvent event);
}
