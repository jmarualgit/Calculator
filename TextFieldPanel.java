import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TextFieldPanel extends JPanel {

    // textfield to input or put in numbers
    private static JTextField textField;

    TextFieldPanel() {
        this.setLayout(new BorderLayout(0, 0));

        textField = new JTextField("");
        textField.setPreferredSize(new Dimension(500, 100));
        textField.setFont(new Font("Consolas", Font.BOLD, 35));
        textField.setBackground(new Color(0x444444));
        textField.setForeground(new Color(0xDDDDDD));
        textField.setHorizontalAlignment(SwingConstants.RIGHT);

        this.add(textField);
    }

    public static void setText(String string) {
        textField.setText(string);
    }

    public static String getText() {
        return textField.getText();
    }
}
