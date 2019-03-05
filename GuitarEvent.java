import java.util.EventObject;

/**
 * Represents a change in state of the guitar
 * @author Callum Browne
 */
public class GuitarEvent extends EventObject {
    /**
     * The state of the guitar at the moment the event is fired
     */
    private GuitarState state;

    public GuitarEvent(Object source, GuitarState state) {
        super(source);
        this.state = state;
    }
    public GuitarState getState() {
        return state;
    }
}
