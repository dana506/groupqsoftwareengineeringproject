/**
 * Represents a listener of the whammy bar
 * @author Callum Browne
 */
public interface WhammyBarListener extends GuitarStateChangeListener{
    /**
     * The method to be called when the whammy bar changes state
     */
    public void whammyBarEventReceived(WhammyBarEvent event);
}
