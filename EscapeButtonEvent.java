/**
 * Represents the event of the escape button being pressed or released
 * @author Callum Browne
 */
public class EscapeButtonEvent extends GuitarStateChangeEvent {
    public EscapeButtonEvent(Object source, GuitarState state) {
        super(source, state);
    }
}
