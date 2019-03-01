import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Receives events regarding key presses and keeps tracks of the state of various keys. Used in mocking the guitar
 * controller
 * @author Callum Browne
 */
public class KeyboardWatcher implements KeyListener {
    private boolean oneButtonPressed = false;
    private boolean twoButtonPressed = false;
    private boolean threeButtonPressed = false;
    private boolean fourButtonPressed = false;
    private boolean fiveButtonPressed = false;
    private boolean sixButtonPressed = false;
    private boolean leftArrowButtonPressed = false;
    private boolean rightArrowButtonPressed = false;
    private boolean spaceBarPressed = false;
    private boolean zButtonPressed = false;
    private boolean mButtonPressed;
    private boolean escapeButtonPressed = false;

    public void keyTyped(KeyEvent event) {
        return;
    }

    public void keyPressed(KeyEvent event) {
        if(event.getKeyCode() == KeyEvent.VK_1) {
            oneButtonPressed = true;
        }
        else if(event.getKeyCode() == KeyEvent.VK_2) {
            twoButtonPressed = true;
        }
        else if(event.getKeyCode() == KeyEvent.VK_3) {
            threeButtonPressed = true;
        }
        else if(event.getKeyCode() == KeyEvent.VK_4) {
            fourButtonPressed = true;
        }
        else if(event.getKeyCode() == KeyEvent.VK_5) {
            fiveButtonPressed = true;
        }
        else if(event.getKeyCode() == KeyEvent.VK_6) {
            sixButtonPressed = true;
        }
        else if(event.getKeyCode() == KeyEvent.VK_LEFT) {
            leftArrowButtonPressed = true;
        }
        else if(event.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightArrowButtonPressed = true;
        }
        else if(event.getKeyCode() == KeyEvent.VK_SPACE) {
            spaceBarPressed = true;
        }
        else if(event.getKeyCode() == KeyEvent.VK_Z) {
            zButtonPressed = true;
        }
        else if(event.getKeyCode() == KeyEvent.VK_M) {
            mButtonPressed = true;
        }
        else if(event.getKeyCode() == KeyEvent.VK_ESCAPE) {
            escapeButtonPressed = true;
        }
    }

    public void keyReleased(KeyEvent event) {
        if(event.getKeyCode() == KeyEvent.VK_1) {
            oneButtonPressed = false;
        }
        else if(event.getKeyCode() == KeyEvent.VK_2) {
            twoButtonPressed = false;
        }
        else if(event.getKeyCode() == KeyEvent.VK_3) {
            threeButtonPressed = false;
        }
        else if(event.getKeyCode() == KeyEvent.VK_4) {
            fourButtonPressed = false;
        }
        else if(event.getKeyCode() == KeyEvent.VK_5) {
            fiveButtonPressed = false;
        }
        else if(event.getKeyCode() == KeyEvent.VK_6) {
            sixButtonPressed = false;
        }
        else if(event.getKeyCode() == KeyEvent.VK_LEFT) {
            leftArrowButtonPressed = false;
        }
        else if(event.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightArrowButtonPressed = false;
        }
        else if(event.getKeyCode() == KeyEvent.VK_SPACE) {
            spaceBarPressed = false;
        }
        else if(event.getKeyCode() == KeyEvent.VK_Z) {
            zButtonPressed = false;
        }
        else if(event.getKeyCode() == KeyEvent.VK_M) {
            mButtonPressed = false;
        }
        else if(event.getKeyCode() == KeyEvent.VK_ESCAPE) {
            escapeButtonPressed = false;
        }
    }

    public boolean isOneButtonPressed() {
        return oneButtonPressed;
    }

    public boolean isTwoButtonPressed() {
        return twoButtonPressed;
    }

    public boolean isThreeButtonPressed() {
        return threeButtonPressed;
    }

    public boolean isFourButtonPressed() {
        return fourButtonPressed;
    }

    public boolean isFiveButtonPressed() {
        return fiveButtonPressed;
    }

    public boolean isSixButtonPressed() {
        return sixButtonPressed;
    }

    public boolean isLeftArrowButtonPressed() {
        return leftArrowButtonPressed;
    }

    public boolean isRightArrowButtonPressed() {
        return rightArrowButtonPressed;
    }

    public boolean isSpaceBarPressed() {
        return spaceBarPressed;
    }

    public boolean iszButtonPressed() {
        return zButtonPressed;
    }

    public boolean ismButtonPressed() {
        return mButtonPressed;
    }

    public boolean isEscapeButtonPressed() {
        return escapeButtonPressed;
    }
}
