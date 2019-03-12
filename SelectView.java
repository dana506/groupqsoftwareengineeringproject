import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
/**
 * This is the main class that represents the Select mode menu.This class contains all
 *  components needed to be displayed in the main frame (the bundles)
 *
 * @author Callum Browne and Sergiu Ivanov
 */
public class SelectView {

    private JPanel selectModePanel ;
    private ArrayList<JButton> buttons = new ArrayList<>();

    public SelectView(){
        ArrayList<Bundle> bundles = BundleFetcher.fetchAllBundles(new File("./bundles"));
        for(Bundle bundle: bundles) {
            buttons.add(new SongButton(bundle.getArtworkFile().getAbsolutePath()));
        }

        selectModePanel = new JPanel();
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 0,2);
        selectModePanel.setLayout(flowLayout);
        //selectModePanel.setBackground(Color.cyan);
        selectModePanel.setOpaque(true);
        selectModePanel.setBounds(10, 200 ,760, 190 );

    }

    public JPanel getSelectModePanel() {
        return selectModePanel;
    }
    public  ArrayList<JButton> getButtons() {
        return buttons;
    }
}
