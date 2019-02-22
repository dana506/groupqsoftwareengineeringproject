import java.io.IOException;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

/**
 * Represents the physical guitar controller, using JInput to retrieve information
 * @author Callum Browne
 *
 */
public class GuitarController {
	/**
	 * The JInput controller representing the physical controller
	 */
    private Controller controller;
    
    /**
     * The identifier for the controller
     */
    final static String GUITAR_HERO = "Guitar Hero";

    /**
     * Find the suitable JInput controller for the guitar
     * @throws IOException
     */
    public GuitarController() throws IOException {    	
        ControllerEnvironment cenv = ControllerEnvironment.getDefaultEnvironment();
        Controller[] ctrls = cenv.getControllers();

        for(Controller ctrl: ctrls) {
            if(ctrl.getName().contains(GUITAR_HERO))
            {
                controller = ctrl;
                break;
            }
        }
        
        // No guitar controller was found - this makes the program unusable hence we throw an error
        if(controller == null) {
        	throw new IOException("No guitar controller found");
        }
    }

    /**
     * Fetches the current state of the guitar
     * @return A GuitarState representing the guitar at the moment this method was called
     */
    public GuitarState getState() {
    	if(controller.poll()) {
            Component[] components = controller.getComponents();
            float[] values = new float[components.length];

            for(int i=0; i<values.length; i++) {
                values[i] = components[i].getPollData();
            }

            return GuitarState.fromControllerComponentsValues(values);
    	}
    	
    	return null;
    }
}
