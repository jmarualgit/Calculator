package main;
import java.awt.*;
import java.awt.event.*; 

import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {

    // see if has been converted to percent previously
    // the % symbol reconverts to non percent value
    boolean isConvertedToPercent = false;

    int indexOfDecimal;

    // declaring panels
    JPanel inputPanel, buttonsPanel;

    // textfield to input or put in numbers
    JTextField textField;
    
    // declaring input buttons
    JButton button1, button2, button3, button4, button5, 
            button6, button7, button8, button9, button0;

    // declaring function buttons
    JButton clearButton, signButton, percentButton, addButton, subtractButton, 
            multiplyButton, divideButton, equalsButton, decimalButton;

    // declaring misc/placeholder button(s)
    JButton emptyButton;
    
    /**/
    // Strings for inputs and sum
    // going to parse as double later
    String input1;
    String input2;
    double sum;

    // string to hold operator
    String operator;

    // to make sure there are no decimal repeats
    int decimalCount;

    // double to hold the result
    double result;

    // to see if what's displayed is a result or an input
    Boolean isAnAnswer;

    // constructor
    MyFrame() {

        /* */
        input1 = "";
        input2 = "";
        sum = 0;
        decimalCount = 0;
        operator = "";
        isAnAnswer = false;
        

        // setting up my frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);

        // border layout
        this.setLayout(new BorderLayout());

        // inputPanel
        inputPanel = new JPanel();
        inputPanel.setPreferredSize(new Dimension(500, 100));
        inputPanel.setBackground(new Color(0xEEEEEE));

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(500, 100));
        textField.setFont(new Font("Consolas", Font.BOLD, 35));
        textField.setBackground(new Color(0x444444));
        textField.setForeground(new Color(0xDDDDDD));
        textField.setHorizontalAlignment(SwingConstants.RIGHT);

        // initializing with a blank
        textField.setText("");

        inputPanel.add(textField);

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
        buttonsPanel = new JPanel(new GridLayout(5, 4, 10, 10));
        buttonsPanel.setPreferredSize(new Dimension(500, 400));
        buttonsPanel.setBackground(new Color(0x222222));

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

        emptyButton = new JButton();

        // adding onto button panel
        buttonsPanel.add(clearButton);
        buttonsPanel.add(signButton);
        buttonsPanel.add(percentButton);
        buttonsPanel.add(divideButton);

        buttonsPanel.add(button7);
        buttonsPanel.add(button8);
        buttonsPanel.add(button9);
        buttonsPanel.add(multiplyButton);

        buttonsPanel.add(button4);
        buttonsPanel.add(button5);
        buttonsPanel.add(button6);
        buttonsPanel.add(subtractButton);

        buttonsPanel.add(button1);
        buttonsPanel.add(button2);
        buttonsPanel.add(button3);
        buttonsPanel.add(addButton);

        buttonsPanel.add(button0);
        buttonsPanel.add(emptyButton);
        buttonsPanel.add(decimalButton);
        buttonsPanel.add(equalsButton);

        // a master array for all buttons
        JButton[] buttonsList = {
        button1, button2, button3, button4, button5, 
        button6, button7, button8, button9, button0,

        clearButton, signButton, percentButton, addButton, subtractButton, 
        multiplyButton, divideButton, equalsButton, decimalButton,

        emptyButton
        };

        // put into array of input buttons
        JButton[] inputButtonsList = {
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

            buttonsList[i].setForeground(new Color(0xDDDDDD));      // foreground color
            buttonsList[i].setBorderPainted(false);     // makes it so there's no border
            buttonsList[i].setFocusable(false);     // takes away dotted line
        }

        // customizing the input buttons (0 - 9)
        for (int i = 0; i < inputButtonsList.length; i++) {

            // set background color
            inputButtonsList[i].setBackground(new Color(0x555555));

            // add an action listener
            buttonsList[i].addActionListener(this);
        }

        // customizing the functions buttons
        for (int i = 0; i < functionButtonsList.length; i++) {

            // set background color
            functionButtonsList[i].setBackground(new Color(0x333333));

            // add an action listener
            functionButtonsList[i].addActionListener(this);
        }

        emptyButton.addActionListener(this);
        emptyButton.setBackground(new Color(0x333333));

        // add to panel
        this.add(inputPanel, BorderLayout.NORTH);
        this.add(buttonsPanel, BorderLayout.CENTER);

        // make visible
        this.setVisible(true);
    } // end constructor

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button0 || e.getSource() == button1 || e.getSource() == button2 ||
            e.getSource() == button3 || e.getSource() == button4 || e.getSource() == button5 ||
            e.getSource() == button6 || e.getSource() == button7 || e.getSource() == button8 ||
            e.getSource() == button9) {

            if (isAnAnswer == true) {
                isAnAnswer = false;
            }
        }
        
        // for each button
        if (e.getSource() == button1) {
            textField.setText(textField.getText() + "1");

            // to see which input the button should go in
            if (operator == "") {
                input1 = input1 + "1";
            } else {
                input2 = input2 + "1";
            }
        }

        if (e.getSource() == button2) {
            textField.setText(textField.getText() + "2");

            if (operator == "") {
                input1 = input1 + "2";
            } else {
                input2 = input2 + "2";
            }
        }

        if (e.getSource() == button3) {
            textField.setText(textField.getText() + "3");

            if (operator == "") {
                input1 = input1 + "3";
            } else {
                input2 = input2 + "3";
            }
        }

        if (e.getSource() == button4) {
            textField.setText(textField.getText() + "4");

            if (operator == "") {
                input1 = input1 + "4";
            } else {
                input2 = input2 + "4";
            }
        }

        if (e.getSource() == button5) {
            textField.setText(textField.getText() + "5");

            if (operator == "") {
                input1 = input1 + "5";
            } else {
                input2 = input2 + "5";
            }
        }

        if (e.getSource() == button6) {
            textField.setText(textField.getText() + "6");

            if (operator == "") {
                input1 = input1 + "6";
            } else {
                input2 = input2 + "6";
            }
        }

        if (e.getSource() == button7) {
            textField.setText(textField.getText() + "7");

            if (operator == "") {
                input1 = input1 + "7";
            } else {
                input2 = input2 + "7";
            }
        }

        if (e.getSource() == button8) {
            textField.setText(textField.getText() + "8");

            if (operator == "") {
                input1 = input1 + "8";
            } else {
                input2 = input2 + "8";
            }
        }

        if (e.getSource() == button9) {
            textField.setText(textField.getText() + "9");

            if (operator == "") {
                input1 = input1 + "9";
            } else {
                input2 = input2 + "9";
            }
        }

        if (e.getSource() == button0) {
                textField.setText(textField.getText() + "0");

                if (operator == "") {
                    input1 = input1 + "0";
                } else {
                    input2 = input2 + "0";
                }
        }

        if (e.getSource() == clearButton) {

            // set to original values
            textField.setText("");
            input1 = "";
            input2 = "";
            operator = "";
            isConvertedToPercent = false;
            decimalCount = 0;
            isAnAnswer = false;
        }

        // the +/- button, designed to change the input from positive to negative and vice versa
        if (e.getSource() == signButton) {

            /* */
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
        */
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
        }

        if (e.getSource() == subtractButton) {
            
            // set the operator sign
            operator = "-";

            // reset decimal count
            decimalCount = 0;

            // clears the textfield to get input2
            textField.setText("");
        }

        if (e.getSource() == multiplyButton) {

            // set the operator sign
            operator = "x";

            // reset decimal count
            decimalCount = 0;

            // clears the textfield to get input2
            textField.setText("");
        }

        if (e.getSource() == divideButton) {

            // set the operator sign
            operator = "/";

            // reset decimal count
            decimalCount = 0;

            // clears the textfield to get input2
            textField.setText("");
        }

        
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

        if (e.getSource() == emptyButton) {
            // for debugging
            /* */
            System.out.println("***NUMBERS***");
            System.out.println("input1 is " + input1);
            System.out.println("input2 is " + input2);
            System.out.println("result is " + result);
            System.out.println("indexOfDecimal is " + indexOfDecimal);

            System.out.println("***OTHERS***");
            System.out.println("text field is " + textField.getText());
            System.out.println("operator is " + operator);
            System.out.println("has been converted to percent? " + isConvertedToPercent);
            System.out.println("is an answer? " + isAnAnswer);
        }

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
    } // end actionPerformed
}