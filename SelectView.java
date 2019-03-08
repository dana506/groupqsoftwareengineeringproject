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
    private SongButton song1 ;
    private SongButton song2 ;
    private SongButton song3 ;
    private SongButton song4 ;
    private SongButton song5 ;
    private ArrayList<JButton> buttons = new ArrayList<>();

    public SelectView(){

        song1 = new SongButton("selectmodeicons/icon1.png");
        song2 = new SongButton("selectmodeicons/icon2.png");
        song3 = new SongButton("selectmodeicons/icon3.png");
        song4 = new SongButton("selectmodeicons/icon4.png");
        song5 = new SongButton("selectmodeicons/icon5.png");

        buttons.add(song1);
        buttons.add(song2);
        buttons.add(song3);
        buttons.add(song4);
        buttons.add(song5);

        selectModePanel = new JPanel();
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 0,2);
        selectModePanel.setLayout(flowLayout);
        //selectModePanel.setBackground(Color.cyan);
        selectModePanel.setOpaque(true);
        selectModePanel.setBounds(10, 200 ,760, 190 );

    }

    public SongButton getSong1() {
        return song1;
    }

    public SongButton getSong2() {
        return song2;
    }

    public SongButton getSong3() {
        return song3;
    }

    public SongButton getSong4() {
        return song4;
    }

    public SongButton getSong5() {
        return song5;
    }

    public JPanel getSelectModePanel() {
        return selectModePanel;
    }
    public  ArrayList<JButton> getButtons() {
        return buttons;
    }
}
