import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class MainPanel extends JPanel {
    private  ExitButton btnExit ;
    private  ExitButton btnExit2 ;
    private  PlayButton btnPlay ;
    private  SelectButton btnSelect ;
    private  StoreButton btnStore ;
    private  TutorialButton btnTutorial ;
    // the index of the selected button
    private int defaultButtonPosition;
    // the index of the first icon on the left
    private int firstPosition = 0;

    private static ArrayList<JButton> buttons = new ArrayList<>();
    public static Border border = BorderFactory.createLineBorder(Color.BLUE, 5);

    public MainPanel(){

    }
    public void addAllButtons(){
        buttons.add(btnExit);
        //buttons.add(btnExit2);
        buttons.add(btnPlay);
        buttons.add(btnSelect);
        buttons.add(btnStore);
        buttons.add(btnTutorial);
    }
}
