//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler {

    private String[] buttonTexts = {
        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "C",
        "+/-", "%", "+", "-", "x", "/", "=", ".", ""
    };

    Function function = new Function(0.0, 0.0);

    ButtonHandler() {

    }

    public void addActionListeners() {

        System.out.println("implemented!");

        ActionListener buttonListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                Object event = ae.getSource();

                if (event == ButtonPanel.getButton("1")) {
                    function.pressedInputButton("1");
                }

                if (event == ButtonPanel.getButton("2")) {function.pressedInputButton("2");}
                if (event == ButtonPanel.getButton("3")) {function.pressedInputButton("3");}
                if (event == ButtonPanel.getButton("4")) {function.pressedInputButton("4");}
                if (event == ButtonPanel.getButton("5")) {function.pressedInputButton("5");}
                if (event == ButtonPanel.getButton("6")) {function.pressedInputButton("6");}
                if (event == ButtonPanel.getButton("7")) {function.pressedInputButton("7");}
                if (event == ButtonPanel.getButton("8")) {function.pressedInputButton("8");}
                if (event == ButtonPanel.getButton("9")) {function.pressedInputButton("9");}
                if (event == ButtonPanel.getButton("0")) {function.pressedInputButton("0");}

                // clear button
                if (event == ButtonPanel.getButton("C")) {
                    TextFieldPanel.setText("");

                    // set to original values
                    function.setInput1("");
                    function.setInput2("");
                    function.setOperator("");
                    function.setIsPercent(false);
                    function.setDecimalCount(0);
                    function.setIsAnAnswer(false);
                } // end clearButton

                // the +/- button, designed to change the input from positive to negative and vice versa
                if (event == ButtonPanel.getButton("+/-")) {

                    char firstCharacter = TextFieldPanel.getText().charAt(0);

                    // if positive, add a -
                    if (firstCharacter != '-') {
                        // adding a '-'
                        TextFieldPanel.setText("-" + TextFieldPanel.getText());

                        // do the same for input1
                        // if no operator has been selected yet (default value), then designate to input1
                        if (function.getOperator() == "") {
                            function.setInput1("-" + function.getInput1());
                        } else {
                            function.setInput2("-" + function.getInput2());
                        }
                    } else {
                        int textLength = TextFieldPanel.getText().length();

                        // formatted string is a substring of all the characters of the textfield except the first character
                        String formattedString = TextFieldPanel.getText().substring(1,  textLength);

                        TextFieldPanel.setText(formattedString);

                        // take out the first value of string which would be the '-'
                        if (function.getOperator() == "") {
                            int input1Length = function.getInput1().length();
                            String withoutFirstCharacter = function.getInput1().substring(1, input1Length);

                            function.setInput1(withoutFirstCharacter);
                        } else {
                            int input2Length = function.getInput2().length();
                            String withoutFirstCharacter = function.getInput2().substring(1, input2Length);

                            function.setInput2(withoutFirstCharacter);
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
                if (event == ButtonPanel.getButton("%")) {
                    String convertedText;

                    // System.out.println("textToConvert is " + textField.getText());

                    // if an operator hasn't been selected yet
                    if (function.getOperator() == "") {
                        convertedText = function.percentConvert(TextFieldPanel.getText(), true);
                    } else {
                        convertedText = function.percentConvert(TextFieldPanel.getText(), false);
                    }

                    // this will also work for when a result has been obtained because
                        // equalsButton resets operator to ""
                    if (function.getIsPercent() == true) {
                        function.setIsPercent(false);
                    } else {
                        function.setIsPercent(true);
                    }

                    TextFieldPanel.setText(convertedText);
                } // end percentButton

                // function buttons
                if (event == ButtonPanel.getButton("+")) {
                    function.pressedFuncButton("+");
                }
        
                // made the rest of the operator buttons as one liners as they are repeats of above
                if (event == ButtonPanel.getButton("-")) {function.pressedFuncButton("-");}
                if (event == ButtonPanel.getButton("x")) {function.pressedFuncButton("x");}
                if (event == ButtonPanel.getButton("/")) {function.pressedFuncButton("/");}

                // equals button
                if (event == ButtonPanel.getButton("=")) {
                    String answer = String.valueOf(function.getAnswer(function.getOperator()));

                    // sets the text to the result
                    TextFieldPanel.setText(answer);

                    String operator = function.getOperator();
                    String firstInput = function.getInput1();
                    String secondInput = function.getInput2();

                    TextFieldPanel.setCurrentOperationText(firstInput + " " + operator + " " + secondInput);

                    // so can keep adding, subtracting, etc.
                    // reset operator, num1, num2, decimalcount, isconvertedtopercent
                    function.setIsPercent(false);
                    function.setOperator("");
                    function.setInput1(answer);
                    function.setInput2("");
                    function.setIsAnAnswer(true);

                    if (answer.contains(".")) {
                        function.setDecimalCount(1);
                    }
                } // end equalsButton

                // . button
                if (event == ButtonPanel.getButton(".")) {

                    // so as to not have repeats of decimals
                    if (function.getDecimalCount() == 0) {
                        TextFieldPanel.setText(TextFieldPanel.getText() + ".");

                        if (function.getOperator() == "") {
                            function.setInput1(function.getInput1() + ".");
                        } else {
                            function.setInput2(function.getInput2() + ".");
                        }
                    }

                    if (function.getDecimalCount() != 1) {
                        function.setDecimalCount(1);
                    }
                } // end . button

                if (event == ButtonPanel.getButton("")) {
                    // for debugging 
                    System.out.println("***NUMBERS***");
                    System.out.println("input1 is " + function.getInput1());
                    System.out.println("input2 is " + function.getInput2());
                    System.out.println("indexOfDecimal is " + function.getIndexOfDecimal());
                    System.out.println("decimal count: " + function.getDecimalCount());
        
                    System.out.println("***OTHERS***");
                    System.out.println("text field is " + TextFieldPanel.getText());
                    System.out.println("operator is " + function.getOperator());
                    System.out.println("has been converted to percent? " + function.getIsPercent());
                    System.out.println("is an answer? " + function.getIsAnAnswer());
                } // end emptyButton
            } // end actionPerformed
        };

        // add action listeners for all the buttons
        for (int i = 0; i < buttonTexts.length; i++) {
            ButtonPanel.getButton(buttonTexts[i]).addActionListener(buttonListener);
        }
    } // end addActionListeners
}

