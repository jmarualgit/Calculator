import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {

    // declaring input buttons
    private static JButton button1, button2, button3, button4, button5, 
                    button6, button7, button8, button9, button0;

    // declaring function buttons
    private JButton clearButton, signButton, percentButton, addButton, subtractButton, 
                    multiplyButton, divideButton, equalsButton, decimalButton;

    // declaring misc/placeholder button(s)
    private static JButton emptyButton;

    static JButton[] buttonsList = new JButton[20];
    static JButton[] inputButtonsList = new JButton[10];

    ButtonPanel() {

        this.setLayout(new GridLayout(5, 4, 10, 10));
        this.setSize(new Dimension(500, 400));
        this.setBackground(new Color(0x222222));

        // assigning input buttons as JButtons with text
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        button0 = new JButton("0");

        // assigning function buttons as JButtons with text
        clearButton = new JButton("C");
        signButton = new JButton("+/-");
        percentButton = new JButton("%");
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("x");
        divideButton = new JButton("/");
        equalsButton = new JButton("=");
        decimalButton = new JButton(".");

        emptyButton = new JButton("");

        // a master array for all buttons
        buttonsList = new JButton[]{
        clearButton, signButton, percentButton, divideButton,
        button7, button8, button9, multiplyButton,
        button4, button5, button6, subtractButton,
        button1, button2, button3, addButton,
        button0, emptyButton, decimalButton, equalsButton
        };

        // put into array of input buttons
        inputButtonsList = new JButton[]{
            button1, button2, button3, button4, button5, 
            button6, button7, button8, button9, button0
        };

        // put into array of function buttons
        JButton[] functionButtonsList = {
            clearButton, signButton, percentButton, addButton, subtractButton, 
            multiplyButton, divideButton, equalsButton, decimalButton
        };

        // customizing buttons
        for (int i = 0; i < buttonsList.length; i++) {
            // add each button to the panel
            this.add(buttonsList[i]);

            buttonsList[i].setForeground(new Color(0xDDDDDD));        // foreground color
            buttonsList[i].setBorderPainted(false);                     // makes it so there's no border
            buttonsList[i].setFocusable(false);                 // takes away dotted line
        }

        // customizing the input buttons (0 - 9)
        for (int i = 0; i < inputButtonsList.length; i++) {

            // set background color
            inputButtonsList[i].setBackground(new Color(0x555555));
        }

        // customizing the functions buttons
        for (int i = 0; i < functionButtonsList.length; i++) {

            // set background color
            functionButtonsList[i].setBackground(new Color(0x333333));
        }

        emptyButton.setBackground(new Color(0x333333));
    }

    public static JButton getButton(String buttonText) {
        JButton buttonToBeReturned = button0;

        for (int i = 0; i < buttonsList.length; i++) {

            if (buttonsList[i].getText() == buttonText) {

                buttonToBeReturned = buttonsList[i];
                break;
            }
        }

        return buttonToBeReturned;
    }
}