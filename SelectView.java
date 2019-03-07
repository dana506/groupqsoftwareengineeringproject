import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * This is the main class that represents the Select mode menu.This class contains all
 *  components needed to be displayed in the main frame (the bundles)
 *
 * @author Callum Browne and Sergiu Ivanov
 */
public class SelectView {

    private JPanel selectModePanel ;
    private ExitButton btnExit ;
    private ExitButton btnExit2 ;
    private PlayButton btnPlay ;
    private SelectButton btnSelect ;
    private StoreButton btnStore ;
    private TutorialButton btnTutorial ;
    private ArrayList<JButton> buttons = new ArrayList<>();

    public SelectView(){

        btnExit = new ExitButton("exit.png");
//        btnExit2 = new ExitButton("exit2.png");
        btnPlay = new PlayButton("play.png");
        btnSelect = new SelectButton("select.png");
        btnStore = new StoreButton("store.png");
        btnTutorial = new TutorialButton("tutorial.png");

        buttons.add(btnExit);
//        buttons.add(btnExit2);
        buttons.add(btnPlay);
        buttons.add(btnSelect);
        buttons.add(btnStore);
        buttons.add(btnTutorial);

        selectModePanel = new JPanel();
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 0,2);
        selectModePanel.setLayout(flowLayout);
        //selectModePanel.setBackground(Color.cyan);
        selectModePanel.setOpaque(true);
        selectModePanel.setBounds(10, 200 ,760, 190 );

    }

    public   ExitButton getBtnExit() {
        return btnExit;
    }

    public   PlayButton getBtnPlay() {
        return btnPlay;
    }

    public   SelectButton getBtnSelect() {
        return btnSelect;
    }

    public   StoreButton getBtnStore() {
        return btnStore;
    }

    public   TutorialButton getBtnTutorial() {
        return btnTutorial;
    }

    public JPanel getSelectModePanel() {
        return selectModePanel;
    }
    public  ArrayList<JButton> getButtons() {
        return buttons;
    }
}
