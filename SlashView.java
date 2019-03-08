import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * This is the main class that represents the Slash mode View. It contains all
 * components needed to be displayed in the main frame
 *
 * @author Sergiu Ivanov
 */
public class SlashView {

    private JPanel slashModePanel ;
    private ExitButton btnExit ;
    private PlayButton btnPlay ;
    private SelectButton btnSelect ;
    private StoreButton btnStore ;
    private TutorialButton btnTutorial ;
    private ArrayList<JButton> buttons = new ArrayList<>();

    public SlashView(){

        btnExit = new ExitButton("exit2.png");
        btnPlay = new PlayButton("play2.png");
        btnSelect = new SelectButton("select2.png");
        btnStore = new StoreButton("store2.png");
        btnTutorial = new TutorialButton("tutorial2.png");

        buttons.add(btnExit);
        buttons.add(btnPlay);
        buttons.add(btnSelect);
        buttons.add(btnStore);
        buttons.add(btnTutorial);

        slashModePanel = new JPanel();
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 0,2);
        slashModePanel.setLayout(flowLayout);
        //slashModePanel.setBackground(Color.red);
        slashModePanel.setOpaque(true);
        slashModePanel.setBounds(10, 200 ,760, 190 );

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

    public JPanel getSlashModePanel() {
        return slashModePanel;
    }
    public  ArrayList<JButton> getButtons() {
        return buttons;
    }
}
