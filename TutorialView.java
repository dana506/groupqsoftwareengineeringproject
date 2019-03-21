import javax.swing.*;

/**
 * This is the main class that represents the Tutorial mode View. It contains all
 * components needed to be displayed in the main frame
 *
 * @author Sergiu Ivanov
 */
public class TutorialView {
    private ImageIcon backgroundImage ;
    private JLabel background;


    public TutorialView(){
        backgroundImage = new ImageIcon("tutorialSample.png");
        background = new JLabel("Background", backgroundImage, JLabel.CENTER);
    }

    public ImageIcon getBackgroundImage() {
        return backgroundImage;
    }

    public JLabel getBackground() {
        return background;
    }
}
