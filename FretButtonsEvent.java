/**
 * Represents the event of any of the six fret buttons being pressed or released
 * @author Callum Browne
 */
public class FretButtonsEvent extends GuitarStateChangeEvent {
    public FretButtonsEvent(Object source, GuitarState state) {
        super(source, state);
    }
}
