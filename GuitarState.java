import java.util.Arrays;

/**
 * Represents the state of a guitar controller at a given moment in time, i.e. the status of all its components
 * @author Callum Browne
 *
 */
public class GuitarState {
	/**
	 * An array of six boolean values, corresponding to each fret button
	 */
    private boolean[] fretButtons;
    
    /**
     * An integer value (either -1, 0 or 1) corresponding to the strum bar's state
     */
    private int strumBar;
    
    /**
     * A boolean value representing whether the Zero Power button is pressed
     */
    private boolean zeroPowerButton;
    
    /**
     * A float value between 0 and 1 (inclusive) representing the current value of the whammy bar
     */
    private float whammyBar;
    
    /**
     * A float value between 0 and 1 (going up in 0.125 increments) representing the current value of the bender button
     */
    private float benderButton;
    
    /**
     * A boolean value representing whether the escape button is pressed
     */
    private Boolean escapeButton;

    public GuitarState(boolean[] fretButtons, int strumBar, boolean zeroPowerButton, float whammyBar, float benderButton, Boolean escapeButton) {
        this.fretButtons = fretButtons;
        this.strumBar = strumBar;
        this.zeroPowerButton = zeroPowerButton;
        this.whammyBar = whammyBar;
        this.benderButton = benderButton;
        this.escapeButton = escapeButton;
    }

    /**
     * Calling the getComponents() method on a JInput controller, then using getPollData() produces an array of 18 floats
     * corresponding to various parts on the controller. This method takes in those floats and interprets them
     * @param values - The values obtained via JInput
     * @return A GuitarState representing the given values
     */
    public static GuitarState fromControllerComponentsValues(float[] values)
    {
        boolean[] fretButtons = new boolean[]{false, false, false, false, false, false};
        int strumBar = 0;
        boolean zeroPowerButton = false;
        float whammyBar = 0;
        float benderButton = 0;
        boolean escapeButton = false;

        String os = System.getProperty("os.name").toLowerCase();
        if(os.contains("windows")) {
            fretButtons = new boolean[]{(values[1] != 0), (values[0] != 0), (values[2] != 0), (values[4] != 0), (values[3] != 0), (values[5] != 0)};
            strumBar = (int) values[16];
            zeroPowerButton = (values[8] != 0);
            whammyBar = values[14];
            benderButton = values[13];
            escapeButton = (values[10] != 0);
        }
        else if(os.contains("inux")) {
            fretButtons = new boolean[]{(values[1] != 0), (values[0] != 0), (values[2] != 0), (values[4] != 0), (values[3] != 0), (values[5] != 0)};
            strumBar = (int) values[14];
            zeroPowerButton = (values[8] != 0);
            whammyBar = values[16];
            benderButton = values[17];
            escapeButton = (values[10] != 0);
        }
        else if(os.contains("mac")) {
            fretButtons = new boolean[]{(values[1] != 0), (values[0] != 0), (values[2] != 0), (values[4] != 0), (values[3] != 0), (values[5] != 0)};
            strumBar = (int) values[15];
            zeroPowerButton = (values[8] != 0);
            whammyBar = values[17];
            benderButton = values[13];
            escapeButton = (values[10] != 0);
        }
        else {
            System.out.println("Unsupported machine...");
            System.exit(-1);
        }

        return new GuitarState(fretButtons, strumBar, zeroPowerButton, whammyBar, benderButton, escapeButton);
    }

    public boolean[] getFretButtons() {
        return fretButtons;
    }

    public int getStrumBar() {
        return strumBar;
    }

    public Boolean getZeroPowerButton() {
        return zeroPowerButton;
    }

    public float getWhammyBar() {
        return whammyBar;
    }

    public float getBenderButton() {
        return benderButton;
    }

    public Boolean getEscapeButton() {
        return escapeButton;
    }
}
