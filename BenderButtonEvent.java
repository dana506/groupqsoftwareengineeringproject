/**
 * Represents the event of the bender button being pressed or released
 * @author Callum Browne
 */
public class BenderButtonEvent extends GuitarStateChangeEvent {
    public BenderButtonEvent(Object source, GuitarState state) {
        super(source, state);
    }
}
