import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/* 
         *  Layout for calculator
         *  
         *  C   Neg %   /
         *  7   8   9   x
         *  4   5   6   -
         *  1   2   3   +
         *  0       .   =
         *  
        */

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
    static double result;                          // double to hold the result
    static Boolean isAnAnswer;                     // to see if what's displayed is a result or an input

    private String[] buttonTexts = {
        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "C",
        "+/-", "%", "+", "-", "x", "/", "=", ".", ""
    };

    //JButton btn1;

    // constructor
    MyFrame() {

        buttonPanel = new ButtonPanel();
        textFieldPanel = new TextFieldPanel();
        //btn1 = ButtonPanel.getButton("1");

        initialize();

        // setting up frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new BorderLayout(0, 0));

        //ButtonPanel.getButton("1").addActionListener(this);
        //ButtonPanel.getButton(buttonTexts[1]).addActionListener(this);
        //ButtonPanel.getButton("2").addActionListener(this);
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

    private void determineIfAnswer() {
        if (isAnAnswer == true) {
            isAnAnswer = false;
        } else {
            isAnAnswer = true;
        }
    }

    private void setText(String input) {
        TextFieldPanel.setText(TextFieldPanel.getText() + input);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        // for each button
        if (e.getSource() == ButtonPanel.getButton("0")) {
            System.out.println("clicked button 0");

            setText("0");
            determineIfAnswer();

            // to see which input the button should go in
            if (operator == "") {
                input1 = input1 + "0";
            } else {
                input2 = input2 + "0";
            }
        }

        // made as one liners as they are a repeat of button1 above
        if (e.getSource() == ButtonPanel.getButton("1")) {

            setText("1");
            determineIfAnswer();

            // to see which input the button should go in
            if (operator == "") {input1 = input1 + "1";} else {input2 = input2 + "1";}
        }

        if (e.getSource() == ButtonPanel.getButton("2")) {

            setText("2");
            determineIfAnswer();

            if (operator == "") {input1 = input1 + "2";} else {input2 = input2 + "2";}
        }

        if (e.getSource() == ButtonPanel.getButton("3")) {

            setText("3");
            determineIfAnswer();

            if (operator == "") {input1 = input1 + "3";} else {input2 = input2 + "3";}
        }

        if (e.getSource() == ButtonPanel.getButton("4")) {

            setText("4");
            determineIfAnswer();

            if (operator == "") {input1 = input1 + "4";} else {input2 = input2 + "4";}
        }

        if (e.getSource() == ButtonPanel.getButton("5")) {

            setText("5");
            determineIfAnswer();

            if (operator == "") {input1 = input1 + "5";} else {input2 = input2 + "5";}
        }

        if (e.getSource() == ButtonPanel.getButton("6")) {

            setText("6");
            determineIfAnswer();

            if (operator == "") {input1 = input1 + "6";} else {input2 = input2 + "6";}
        }

        if (e.getSource() == ButtonPanel.getButton("7")) {

            setText("7");
            determineIfAnswer();

            if (operator == "") {input1 = input1 + "7";} else {input2 = input2 + "7";}
        }

        if (e.getSource() == ButtonPanel.getButton("8")) {

            setText("8");
            determineIfAnswer();

            if (operator == "") {input1 = input1 + "8";} else {input2 = input2 + "8";}
        }

        if (e.getSource() == ButtonPanel.getButton("9")) {

            setText("9");
            determineIfAnswer();

            if (operator == "") {input1 = input1 + "9";} else {input2 = input2 + "9";}
        }

        /* 
        if (e.getSource() == clearButton) {

            // set to original values
            textField.setText("");
            input1 = "";
            input2 = "";
            operator = "";
            isConvertedToPercent = false;
            decimalCount = 0;
            isAnAnswer = false;
        } // end clearButton

        // the +/- button, designed to change the input from positive to negative and vice versa
        if (e.getSource() == signButton) {

            // if positive, add a -
            if (textField.getText().charAt(0) != '-') 
            {
                // adding a '-'
                textField.setText("-" + textField.getText());

                // do the same for input1
                // if no operator has been selected yet (default value), then designate to input1
                if (operator == "") {
                    input1 = "-" + input1;
                } else {
                    input2 = "-" + input2;
                }
            } else {
                // formatted string is a substring of all the characters of the textfield except the first character


                // original version
                //textField.setText(textField.getText().substring(1, textField.getText().length()));

                // easier to understand
                String formattedString = textField.getText().substring(1,  textField.getText().length());

                textField.setText(formattedString);

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
        
        if (e.getSource() == percentButton) {

            Function function = new Function(0.0,0.0);
            String convertedText = function.percentConvert(textField.getText(), isConvertedToPercent);

            // System.out.println("textToConvert is " + textField.getText());

            // if an operator hasn't been selected yet
            // this will also work for when a result has been obtained because
                // equalsButton resets operator to ""
            if (isConvertedToPercent == true) {
                isConvertedToPercent = false;
            } else {
                isConvertedToPercent = true;
            }

            textField.setText(convertedText);
        } // end percentButton

        if (e.getSource() == addButton) {
            
            // set the operator sign
            operator = "+";

            // reset decimal count
            decimalCount = 0;

            // clears the textfield to get input2
            textField.setText("");
        } // end addButton

        if (e.getSource() == subtractButton) {
            
            // set the operator sign
            operator = "-";

            // reset decimal count
            decimalCount = 0;

            // clears the textfield to get input2
            textField.setText("");
        } // end subtractButton

        if (e.getSource() == multiplyButton) {

            // set the operator sign
            operator = "x";

            // reset decimal count
            decimalCount = 0;

            // clears the textfield to get input2
            textField.setText("");
        } // end multiplyButton

        if (e.getSource() == divideButton) {

            // set the operator sign
            operator = "/";

            // reset decimal count
            decimalCount = 0;

            // clears the textfield to get input2
            textField.setText("");
        } // end divideButton

        
        if (e.getSource() == equalsButton) {
            Function function = new Function(Double.parseDouble(input1), Double.parseDouble(input2));

            String answer = String.valueOf(function.equals(input1, input2, operator));

            // sets the text to the result
            textField.setText(answer);

            // so can keep adding, subtracting, etc.
            // reset operator, num1, num2, decimalcount, isconvertedtopercent
            isConvertedToPercent = false;
            decimalCount = 0;
            operator = "";
            //num1 = 0;
            //num2 = 0;
            input1 = answer;
            input2 = "";
            isAnAnswer = true;
        } // end equalsButton

        

        if (e.getSource() == decimalButton) {

            // so as to not have repeats of decimals
            if (decimalCount == 0) {
                textField.setText(textField.getText() + ".");
            }

            if (operator == "") {
                input1 = input1 + ".";
            } else {
                input2 = input2 + ".";
            }
            
            decimalCount++;
        }
        */

        if (e.getSource() == ButtonPanel.getButton("")) {
            // for debugging 
            System.out.println("***NUMBERS***");
            System.out.println("input1 is " + input1);
            System.out.println("input2 is " + input2);
            System.out.println("result is " + result);
            System.out.println("indexOfDecimal is " + indexOfDecimal);

            System.out.println("***OTHERS***");
            System.out.println("text field is " + TextFieldPanel.getText());
            System.out.println("operator is " + operator);
            System.out.println("has been converted to percent? " + isConvertedToPercent);
            System.out.println("is an answer? " + isAnAnswer);
        } // end emptyButton
    } // end actionPerformed
}