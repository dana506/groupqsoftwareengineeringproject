import javax.swing.*;
import java.util.ArrayList;
/**
 * This is the model class for the slash mode(In development)
 *
 * @author Sergiu Ivanov
 */
public class SlashModel {
    private ArrayList<JButton> buttons = new ArrayList<>();

    public void addButton(JButton button) {
        buttons.add(button);
    }

    public ArrayList<JButton> getButtons() {
        return buttons;
    }
}
