/**
 * Used to mock the guitar controller with just a keyboard
 * @author Callum Browne
 */
public class MockGuitarController implements GuitarController {
    /**
     * The object that keep tracks of the current keyboard state
     */
    private KeyboardWatcher keyboardWatcher;

    public MockGuitarController(KeyboardWatcher keyboardWatcher) {
        this.keyboardWatcher = keyboardWatcher;
    }

    /**
     * Query the keyboard watcher regarding which keys are being pressed, and mock the guitar state accordingly
     * @return
     */
    public GuitarState getState() {
        /* Keys 1 to 6 represent the fret buttons */
        boolean[] fretButtons = new boolean[]{
                keyboardWatcher.isOneButtonPressed(),
                keyboardWatcher.isTwoButtonPressed(),
                keyboardWatcher.isThreeButtonPressed(),
                keyboardWatcher.isFourButtonPressed(),
                keyboardWatcher.isFiveButtonPressed(),
                keyboardWatcher.isSixButtonPressed()
        };

        /* The left and right arrows keys represent the strum bar */
        int strumBar;
        if(keyboardWatcher.isLeftArrowButtonPressed()) {
            strumBar = -1;
        }
        else if(keyboardWatcher.isRightArrowButtonPressed()) {
            strumBar = 1;
        }
        else {
            strumBar = 0;
        }

        /* The space bar represents the Zero Power button */
        boolean zeroPowerButton = keyboardWatcher.isSpaceBarPressed();

        /* The Z button represents the whammy bar - for simplicity's sake we just set to either 0 or 1 */
        float whammyBar = keyboardWatcher.iszButtonPressed() ? 1 : 0;

        /* The M button represents the bender button - for simplicity's sake we just set to either 0 or 1 */
        float benderButton = keyboardWatcher.ismButtonPressed() ? 1 : 0;

        /* Obviously, the escape button represents the escape button... */
        boolean escapeButton = keyboardWatcher.isEscapeButtonPressed();

        return new GuitarState(fretButtons, strumBar, zeroPowerButton, whammyBar, benderButton, escapeButton);
    }
}
