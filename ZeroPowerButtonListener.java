/**
 * Represents a listener of the Zero Power button
 * @author Callum Browne
 */
public interface ZeroPowerButtonListener extends GuitarListener {
    public void zeroPowerButtonEventReceived(GuitarEvent event);
}
