import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class to continuously poll the guitar in its own thread, and send events to listeners when the state changes
 * @author Callum Browne
 */
public class GuitarPoller implements Runnable {
    /**
     * The controller that we query to fetch the state
     */
    private IGuitarController controller;

    /**
     * The listeners of the various events that can occur
     */
    private ArrayList<FretButtonsListener> fretButtonsListeners = new ArrayList<>();
    private ArrayList<StrumBarListener> strumBarListeners = new ArrayList<>();
    private ArrayList<ZeroPowerButtonListener> zeroPowerButtonListeners = new ArrayList<>();
    private ArrayList<WhammyBarListener> whammyBarListeners = new ArrayList<>();
    private ArrayList<BenderButtonListener> benderButtonListeners = new ArrayList<>();
    private ArrayList<EscapeButtonListener> escapeButtonListeners = new ArrayList<>();

    public GuitarPoller(IGuitarController controller) {
        this.controller = controller;
    }

    /**
     * The methods to fire the various events that can occur
     * @param state The state of the guitar at the instance the event occurs
     */
    private void fireFretButtonsEvent(GuitarState state) {
        FretButtonsEvent event = new FretButtonsEvent(this, state);
        for(FretButtonsListener listener: fretButtonsListeners) {
            listener.fretButtonsEventReceived(event);
        }
    }

    private void fireStrumBarEvent(GuitarState state) {
        StrumBarEvent event = new StrumBarEvent(this, state);
        for(StrumBarListener listener: strumBarListeners) {
            listener.strumBarEventReceived(event);
        }
    }

    private void fireZeroPowerButtonEvent(GuitarState state) {
        ZeroPowerButtonEvent event = new ZeroPowerButtonEvent(this, state);
        for(ZeroPowerButtonListener listener: zeroPowerButtonListeners) {
            listener.zeroPowerButtonEventReceived(event);
        }
    }

    public void fireWhammyBarEvent(GuitarState state) {
        WhammyBarEvent event = new WhammyBarEvent(this, state);
        for(WhammyBarListener listener: whammyBarListeners) {
            listener.whammyBarEventReceived(event);
        }
    }

    public void fireBenderButtonEvent(GuitarState state) {
        BenderButtonEvent event = new BenderButtonEvent(this, state);
        for(BenderButtonListener listener: benderButtonListeners) {
            listener.benderButtonEventReceived(event);
        }
    }

    private void fireEscapeButtonEvent(GuitarState state) {
        EscapeButtonEvent event = new EscapeButtonEvent(this, state);
        for(EscapeButtonListener listener: escapeButtonListeners) {
            listener.escapeButtonEventReceived(event);
        }
    }

    /**
     * The methods to register a new listener
     * @param listener The object to be alerted to any events
     */
    public void addFretButtonsListener(FretButtonsListener listener) {
        fretButtonsListeners.add(listener);
    }

    public void addStrumBarListener(StrumBarListener listener) {
        strumBarListeners.add(listener);
    }

    public void addZeroButtonListener(ZeroPowerButtonListener listener) {
        zeroPowerButtonListeners.add(listener);
    }

    public void addWhammyBarListener(WhammyBarListener listener) {
        whammyBarListeners.add(listener);
    }

    public void addBenderButtonListener(BenderButtonListener listener) {
        benderButtonListeners.add(listener);
    }

    public void addEscapeButtonListener(EscapeButtonListener listener) {
        escapeButtonListeners.add(listener);
    }

    /**
     * Start polling the guitar
     */
    public void run() {
        GuitarState state;
        GuitarState previousState = controller.getState();

        while(true) {
            state = controller.getState();

            /* For each component of the guitar, check if its state has changed since we last checked... */

            if(!Arrays.equals(state.getFretButtons(), previousState.getFretButtons())) {
                fireFretButtonsEvent(state);
            }

            if(state.getStrumBar() != previousState.getStrumBar()) {
                fireStrumBarEvent(state);
            }

            if(state.getZeroPowerButton() != previousState.getZeroPowerButton()) {
                fireZeroPowerButtonEvent(state);
            }

            if(state.getWhammyBar() != previousState.getWhammyBar()) {
                fireWhammyBarEvent(state);
            }

            if(state.getBenderButton() != previousState.getBenderButton()) {
                fireBenderButtonEvent(state);
            }

            if(state.getEscapeButton() != previousState.getEscapeButton()) {
                fireEscapeButtonEvent(state);
            }

            previousState = state;
        }
    }
}
