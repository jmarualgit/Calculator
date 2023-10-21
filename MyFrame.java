import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/* 
        /* 
         *  methods to implement
         *  sin, cos, tan
         *  various square root functions
         *  log, ln, e, pi
         *  custom parentheses
         *  option to switch out between radians and degree
         *  factorials
        */

        /* 
         *  Layout for calculator (future) (to be implemented)
         *  taken from google calculator (as of 2023-10-09) (YY/MM/DD)
         *  
         *  rad/deg       (       )     C   Neg %   /
         *  sin    cos    tan     pi    7   8   9   x
         *  x!     x^2    x^3     x^y   4   5   6   -
         *  1/x    sqrtx  y^sqrtx EE    1   2   3   +
         *  log    ln     e^x     e     0     .   =
         *  
        */

public class MyFrame extends JFrame implements ActionListener {

    // separate classes for my panels
    private ButtonPanel buttonPanel;
    private TextFieldPanel textFieldPanel;

    static boolean isConvertedToPercent = false;   // see if has been converted to percent previously
    static int indexOfDecimal;                     // to see where in the string the decimal is located
    static String input1, input2, operator;        // Strings for inputs and to hold operator
    static int decimalCount;                       // to make sure there are no decimal repeats
    static Boolean isAnAnswer;                     // to see if what's displayed is a result or an input

    private String[] buttonTexts = {
        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "C",
        "+/-", "%", "+", "-", "x", "/", "=", ".", ""
    };

    // constructor
    MyFrame() {

        buttonPanel = new ButtonPanel();
        textFieldPanel = new TextFieldPanel();

        initialize();

        // setting up frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new BorderLayout(0, 0));

        for (int i = 0; i < buttonTexts.length; i++) {
            ButtonPanel.getButton(buttonTexts[i]).addActionListener(this);
        }

        // add to panel
        this.add(textFieldPanel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);

        this.setVisible(true);
    } // end constructor

    private void initialize() {
        input1 = "";
        input2 = "";
        decimalCount = 0;
        operator = "";
        isAnAnswer = false;
    }

    private void pressedInputButton(String input) {
        
        // set the text of the text field
        TextFieldPanel.setText(TextFieldPanel.getText() + input);

        // change boolean value if applicable
        if (isAnAnswer == true) {
            isAnAnswer = false;
        }

        // to see which input the button should go in
        if (operator == "") {
            input1 = input1 + input;
        } else {
            input2 = input2 + input;
        }
    }

    private void pressedFuncButton(String operationInput) {

        // sets the operator
        operator = operationInput;

        // reset
        decimalCount = 0;

        // clear text field
        TextFieldPanel.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // for each button
        if (e.getSource() == ButtonPanel.getButton("0")) {

            pressedInputButton("0");
        }

        // made as one liners as they are a repeat of button1 above
        if (e.getSource() == ButtonPanel.getButton("1")) {pressedInputButton("1");}

        if (e.getSource() == ButtonPanel.getButton("2")) {pressedInputButton("2");}

        if (e.getSource() == ButtonPanel.getButton("3")) {pressedInputButton("3");}

        if (e.getSource() == ButtonPanel.getButton("4")) {pressedInputButton("4");}

        if (e.getSource() == ButtonPanel.getButton("5")) {pressedInputButton("5");}

        if (e.getSource() == ButtonPanel.getButton("6")) {pressedInputButton("6");}

        if (e.getSource() == ButtonPanel.getButton("7")) {pressedInputButton("7");}

        if (e.getSource() == ButtonPanel.getButton("8")) {pressedInputButton("8");}

        if (e.getSource() == ButtonPanel.getButton("9")) {pressedInputButton("9");}

        // clear button
        if (e.getSource() == ButtonPanel.getButton("C")) {

            // set to original values
            TextFieldPanel.setText("");
            input1 = "";
            input2 = "";
            operator = "";
            isConvertedToPercent = false;
            decimalCount = 0;
            isAnAnswer = false;
        } // end clearButton
        
        // the +/- button, designed to change the input from positive to negative and vice versa
        if (e.getSource() == ButtonPanel.getButton("+/-")) {

            char firstCharacter = TextFieldPanel.getText().charAt(0);

            // if positive, add a -
            if (firstCharacter != '-') {
                // adding a '-'
                TextFieldPanel.setText("-" + TextFieldPanel.getText());

                // do the same for input1
                // if no operator has been selected yet (default value), then designate to input1
                if (operator == "") {
                    input1 = "-" + input1;
                } else {
                    input2 = "-" + input2;
                }
            } else {

                int textLength = TextFieldPanel.getText().length();

                // formatted string is a substring of all the characters of the textfield except the first character
                String formattedString = TextFieldPanel.getText().substring(1,  textLength);

                TextFieldPanel.setText(formattedString);

                // take out the first value of string which would be the '-'
                if (operator == "") {
                    input1 = input1.substring(1, input1.length());
                } else {
                    input2 = input2.substring(1, input1.length());
                }
            
            }
            
        } // end signButton

        /* 
         *  percentButton!
         *  the percentButton function moves the decimal two spaces to the left
         *  because converting to a percent is essentially dividing by a 100
         *  
         *  will only be usable if 
         *      1) as a first input as to do quick percent math
         *      2) for the result to see the answer as a percent
        */
        if (e.getSource() == ButtonPanel.getButton("%")) {

            Function function = new Function(0.0,0.0);
            String convertedText = function.percentConvert(TextFieldPanel.getText(), isConvertedToPercent);

            // System.out.println("textToConvert is " + textField.getText());

            // if an operator hasn't been selected yet
            // this will also work for when a result has been obtained because
                // equalsButton resets operator to ""
            if (isConvertedToPercent == true) {
                isConvertedToPercent = false;
            } else {
                isConvertedToPercent = true;
            }

            TextFieldPanel.setText(convertedText);
        } // end percentButton

        // add button
        if (e.getSource() == ButtonPanel.getButton("+")) {
            
            pressedFuncButton("+");
        } // end addButton

        // made into one liners as they are repeats of above
        // subtract button
        if (e.getSource() == ButtonPanel.getButton("-")) {pressedFuncButton("-");}

        // multiply button
        if (e.getSource() == ButtonPanel.getButton("x")) {pressedFuncButton("x");}

        // divide button
        if (e.getSource() == ButtonPanel.getButton("/")) {pressedFuncButton("/");}

        // equals button
        if (e.getSource() == ButtonPanel.getButton("=")) {
            Function function = new Function(Double.parseDouble(input1), Double.parseDouble(input2));

            String answer = String.valueOf(function.equals(input1, input2, operator));

            // sets the text to the result
            TextFieldPanel.setText(answer);

            // so can keep adding, subtracting, etc.
            // reset operator, num1, num2, decimalcount, isconvertedtopercent
            isConvertedToPercent = false;
            decimalCount = 0;
            operator = "";
            input1 = answer;
            input2 = "";
            isAnAnswer = true;
        } // end equalsButton

        // . button
        if (e.getSource() == ButtonPanel.getButton(".")) {

            // so as to not have repeats of decimals
            if (decimalCount == 0) {
                TextFieldPanel.setText(TextFieldPanel.getText() + ".");
            }

            if (operator == "") {
                input1 = input1 + ".";
            } else {
                input2 = input2 + ".";
            }
            
            decimalCount++;
        }

        if (e.getSource() == ButtonPanel.getButton("")) {
            // for debugging 
            System.out.println("***NUMBERS***");
            System.out.println("input1 is " + input1);
            System.out.println("input2 is " + input2);
            System.out.println("indexOfDecimal is " + indexOfDecimal);

            System.out.println("***OTHERS***");
            System.out.println("text field is " + TextFieldPanel.getText());
            System.out.println("operator is " + operator);
            System.out.println("has been converted to percent? " + isConvertedToPercent);
            System.out.println("is an answer? " + isAnAnswer);
        } // end emptyButton
    } // end actionPerformed
}