/**
 * Represents the event of the whammy bar changing state
 * @author Callum Browne
 */
public class WhammyBarEvent extends GuitarStateChangeEvent {
    public WhammyBarEvent(Object source, GuitarState state) {
        super(source, state);
    }
}
