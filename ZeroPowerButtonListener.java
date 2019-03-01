/**
 * Represents a listener of the Zero Power button
 * @author Callum Browne
 */
public interface ZeroPowerButtonListener extends GuitarStateChangeListener{
    public void zeroPowerButtonEventReceived(ZeroPowerButtonEvent event);
}
