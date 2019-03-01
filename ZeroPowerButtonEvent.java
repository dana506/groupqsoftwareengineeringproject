/**
 * Represents the event of the Zero Power button being pressed or released
 * @author Callum Browne
 */
public class ZeroPowerButtonEvent extends GuitarStateChangeEvent {
    public ZeroPowerButtonEvent(Object source, GuitarState state) {
        super(source, state);
    }
}
