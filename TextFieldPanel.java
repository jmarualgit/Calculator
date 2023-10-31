import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TextFieldPanel extends JPanel {

    private static JTextField currentOperationTextField;
    private static JTextField textField;

    private final Dimension currentOperationTextFieldSize = new Dimension(500, 25);
    private final Dimension textFieldSize = new Dimension(500, 75);

    private final Font mainFont = new Font("Consolas", Font.BOLD, 35);
    private final Font operationTextFieldFont = new Font("Consolas", Font.BOLD, 15);

    private final Color backgroundColor = new Color(0x444444);
    private final Color foregroundColor = new Color(0xDDDDDD);
    private final Color currentOperationColor = new Color(0xCCCCCC);

    TextFieldPanel() {
        this.setLayout(new BorderLayout(0, 0));

        textField = new JTextField("");
        currentOperationTextField = new JTextField("");

        textField.setSize(textFieldSize);
        textField.setFont(mainFont);
        textField.setBackground(backgroundColor);
        textField.setForeground(foregroundColor);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        currentOperationTextField.setSize(currentOperationTextFieldSize);
        currentOperationTextField.setFont(operationTextFieldFont);
        currentOperationTextField.setBackground(backgroundColor);
        currentOperationTextField.setForeground(currentOperationColor);
        currentOperationTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        currentOperationTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        currentOperationTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        this.add(currentOperationTextField, BorderLayout.NORTH);
        this.add(textField, BorderLayout.CENTER);
    }

    public static void setText(String string) {textField.setText(string);}

    public static void setCurrentOperationText(String string) {currentOperationTextField.setText(string);}

    public static String getText() {return textField.getText();}
    
    public static String getCurrentOperationText() {return currentOperationTextField.getText();}
}
