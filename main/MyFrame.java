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

    Function function;

    // constructor
    MyFrame() {

        /* */
        input1 = "";
        input2 = "";
        sum = 0;
        decimalCount = 0;
        operator = "";
        function = new Function(Double.parseDouble(input1), Double.parseDouble(input2));
        

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
        }

        // the +/- button, designed to change the input from positive to negative and vice versa
        if (e.getSource() == signButton) {

            /* 
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
            */
        } // end signButton

        // the percentButton function moves the decimal two spaces to the left
        // because converting to a percent is essentially dividing by a 100
        if (e.getSource() == percentButton) {

            /*
            String newText;
            String formattedText;
            boolean isNegative;

            // gets the location of where the decimal is
            int indexOfDecimal = textField.getText().indexOf(".");

            // if negative
            if (textField.getText().charAt(0) == '-') {

                // takes out the first character of the textfield text
                textField.setText(textField.getText().substring(1, textField.getText().length())); 

                isNegative = true;
            } else {
                isNegative = false;
            }

            // takes out the decimal from the text
            formattedText = textField.getText().replace(".", "");

            // if false, convert to percent
            if (isConvertedToPercent == false) {
                
                if (indexOfDecimal == 0) {

                    // index of decimal should be at the front (very left)
                    indexOfDecimal = 0;

                    newText = "0.00" + formattedText;
                } else if (indexOfDecimal == 1) {

                    // index of decimal should be at the front (very left)
                    indexOfDecimal = 0;

                    newText = "0.0" + formattedText;
                } else {

                    // move the index of decimal 2 to the left
                    indexOfDecimal -= 2;

                    // sets the newText
                    newText =   textField.getText().substring(0, indexOfDecimal) +
                            "." + formattedText.substring(indexOfDecimal, formattedText.length());
                }
                
                if (isNegative) {
                    newText = "-" + newText;
                }

                // System.out.println("pre-replace: " + textField.getText());
                // System.out.println("does it contain '.'? " + textField.getText().contains("."));
                // String formattedText = textField.getText().replace(".", "");
                // System.out.println("post-format: " + formattedText);

                textField.setText(newText);


                if (operator == "") {
                    input1 = Function.convertToPercent(input1);
                } else {
                    input2 = Function.convertToPercent(input2);
                }

                isConvertedToPercent = true;
            } else {

                // move decimal point 2 to the right 
                indexOfDecimal += 2;

                newText = "";

                // add a negative if initially negative
                if (isNegative) {
                    newText = "-" + newText;
                }

                // convert back to a non-percent
                if (operator == "") {
                    input1 = Function.convertFromPercent(input1);

                    // updates text field
                    newText = input1;
                } else {
                    input2 = Function.convertFromPercent(input2);

                    newText = input2;
                }

                textField.setText(newText);

                isConvertedToPercent = false;
            }

            */
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

            /* 
            double num1 = Function.convertToDouble(input1);
            double num2 = Function.convertToDouble(input2);

            // if else statements depending on operator
            switch(operator) {

                // for addition
                case "+":

                    // add the two
                    result = Function.add(num1, num2);

                    break;
                
                // for subtraction
                case "-":

                    // subtract the two
                    result = Function.subtract(num1, num2);

                    break;

                // for multiplication
                case "x":

                    // multiply the two
                    result = Function.multiply(num1, num2);

                    break;
                
                // for dividing
                case "/":

                    // divide the two
                    result = Function.divide(num1, num2);

                    break;
            }

            // sets the text to the result
            textField.setText(String.valueOf(result));

            // so can keep adding, subtracting, etc.
            // reset operator, num1, num2, decimalcount, isconvertedtopercent
            isConvertedToPercent = false;
            decimalCount = 0;
            operator = "";
            num1 = 0;
            num2 = 0;
            input1 = String.valueOf(result);
            input2 = "";
            */
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