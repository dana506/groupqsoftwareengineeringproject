/**
 * Represents the event of the strum bar changing its state
 * @author Callum Browne
 */
public class StrumBarEvent extends GuitarStateChangeEvent{
    public StrumBarEvent(Object source, GuitarState state) {
        super(source, state);
    }
}
