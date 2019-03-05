import javax.swing.*;
import java.util.ArrayList;

/**
 * Represents a listener of the strum bar
 * @author Callum Browne
 */
public interface StrumBarListener extends GuitarListener {
    /**
     * The method to be called when the strum bar changes state
     */
    public void strumBarEventReceived(GuitarEvent event);
}
