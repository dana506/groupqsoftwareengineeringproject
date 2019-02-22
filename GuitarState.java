/**
 * Represents the state of a guitar controller at a given moment in time, i.e. the status of all its components
 * @author Callum Browne
 *
 */
public class GuitarState {
	/**
	 * An array of six boolean values, corresponding to each fret button
	 */
    private Boolean[] fretButtons;
    
    /**
     * An integer value (either -1, 0 or 1) corresponding to the strum bar's state
     */
    private int strumBar;
    
    /**
     * A boolean value representing whether the Zero Power button is pressed
     */
    private Boolean zeroPowerButton;
    
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

    public GuitarState(Boolean[] fretButtons, int strumBar, Boolean zeroPowerButton, float whammyBar, float benderButton, Boolean escapeButton) {
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
        Boolean[] fretButtons = {(values[1] != 0), (values[0] != 0), (values[2] != 0), (values[4] != 0), (values[3] != 0), (values[5] != 0)};
        int strumBar = (int) values[14];
        Boolean zeroPowerButton = (values[8] != 0);
        float whammyBar = values[16];
        float benderButton = values[17];
        Boolean escapeButton = (values[10] != 0);

        return new GuitarState(fretButtons, strumBar, zeroPowerButton, whammyBar, benderButton, escapeButton);
    }

    public Boolean[] getFretButtons() {
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
