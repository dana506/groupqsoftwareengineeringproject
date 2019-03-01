import java.util.EventObject;

/**
 * Represents a general change in state of the guitar. Ideally this class should not be directly used, it should be
 * extended for each different type of event
 * @author Callum Browne
 */
public class GuitarStateChangeEvent extends EventObject {
    /**
     * The state of the guitar at the moment the event is fired
     */
    private GuitarState state;

    public GuitarStateChangeEvent(Object source, GuitarState state) {
        super(source);
        this.state = state;
    }

    public GuitarState getState() {
        return state;
    }
}
