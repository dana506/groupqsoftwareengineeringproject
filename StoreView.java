import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

/**
 * This is the main class that represents the Store mode View.
 *
 *
 * @author Sergiu Ivanov
 */
public class StoreView {
    private JPanel storeModePanel ;
    private ArrayList<JButton> buttons = new ArrayList<>();
    private PlayButton btn1 ;
    private PlayButton btn2 ;
    private PlayButton btn3 ;
    private PlayButton btn4 ;
    private PlayButton btn5 ;
    private PlayButton btn6 ;

    public StoreView(){

        btn1 = new PlayButton("artwork1.png");
        btn2 = new PlayButton("artwork2.png");
        btn3 = new PlayButton("artwork3.png");
        btn4 = new PlayButton("artwork4.png");
        btn5 = new PlayButton("artwork5.png");
        btn6 = new PlayButton("artwork6.png");

        buttons.add(btn1);
        buttons.add(btn2);
        buttons.add(btn3);
        buttons.add(btn4);
        buttons.add(btn5);
        buttons.add(btn6);
        storeModePanel = new JPanel();
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 0,2);
        storeModePanel.setLayout(flowLayout);
//        storeModePanel.setBackground(Color.yellow);

        storeModePanel.setOpaque(true);
        storeModePanel.setBounds(10, 200 ,760, 190 );

    }

    public JPanel getStoreModePanel() {
        return storeModePanel;
    }
    public  ArrayList<JButton> getButtons() {
        return buttons;
    }

    public void setStoreModePanel(JPanel storeModePanel) {
        this.storeModePanel = storeModePanel;
    }

    public void setButtons(ArrayList<JButton> buttons) {
        this.buttons = buttons;
    }

    public PlayButton getBtn1() {
        return btn1;
    }

    public void setBtn1(PlayButton btn1) {
        this.btn1 = btn1;
    }

    public PlayButton getBtn2() {
        return btn2;
    }

    public void setBtn2(PlayButton btn2) {
        this.btn2 = btn2;
    }

    public PlayButton getBtn3() {
        return btn3;
    }

    public void setBtn3(PlayButton btn3) {
        this.btn3 = btn3;
    }

    public PlayButton getBtn4() {
        return btn4;
    }

    public void setBtn4(PlayButton btn4) {
        this.btn4 = btn4;
    }

    public PlayButton getBtn5() {
        return btn5;
    }

    public void setBtn5(PlayButton btn5) {
        this.btn5 = btn5;
    }

    public PlayButton getBtn6() {
        return btn6;
    }

    public void setBtn6(PlayButton btn6) {
        this.btn6 = btn6;
    }
}
