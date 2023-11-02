public class Function {

    private double x;
    private double y;
    private double answer;
    private boolean isPercent;                      // see if has been converted to percent previously 
    private int indexOfDecimal;                     // to see where in the string the decimal is located
    private String input1, input2, operator;        // Strings for inputs and to hold operator for easy converting to textfieldpanel
    private int decimalCount;                       // to make sure there are no decimal repeats
    private Boolean isAnAnswer = false;             // to see if what's displayed is a result or an input
    //private Double parseDouble;

    Function(double xInput, double yInput) {
        this.x = xInput;
        this.y = yInput;
        this.operator = "";
        this.isPercent = false;
        this.input1 = this.input2 = "";
        this.decimalCount = 0;
    }

    // getters
    public double getX() {return this.x;}
    public double getY() {return this.y;}
    public String getInput1() {return this.input1;}
    public String getInput2() {return this.input2;}
    public int getIndexOfDecimal() {return this.indexOfDecimal;}
    public String getOperator() {return this.operator;}
    public boolean getIsPercent() {return this.isPercent;}
    public int getDecimalCount() {return this.decimalCount;}
    public boolean getIsAnAnswer() {return this.isAnAnswer;}
    public double getAnswer() {return this.answer;}

    // setters
    public void setX(double newValue) {this.x = newValue;}
    public void setY(double newValue) {this.y = newValue;}
    public void setInput1(String newInput1) {this.input1 = newInput1;}
    public void setInput2(String newInput2) {this.input2 = newInput2;}
    public void setIndexOfDecimal(int newIndex) {this.indexOfDecimal = newIndex;} 
    public void setOperator(String newOperator) {this.operator = newOperator;}
    public void setIsPercent(Boolean newBoolean) {this.isPercent = newBoolean;}
    public void setDecimalCount(int newDecimalCount) {this.decimalCount = newDecimalCount;}
    public void setIsAnAnswer(boolean newBoolean) {this.isAnAnswer = newBoolean;}

    private void add() {
        this.answer = this.x + this.y;
    }

    private void subtract() {
        this.answer = this.x - this.y;
    }

    private void multiply() {
        this.answer = this.x * this.y;
    }

    private void divide() {
        this.answer = this.x / this.y;
    }

    private void equals(String operator) {

        // if else statements depending on operator
        switch(operator) {

            // for addition
            case "+":
                add();
                break;
            
            // for subtraction
            case "-":
                subtract();
                break;

            // for multiplication
            case "x":
                multiply();
                break;
            
            // for dividing
            case "/":
                divide();
                break;
        }
    }

    public double solveForAnswer(String operator) {

        this.x = Double.parseDouble(input1);
        this.y = Double.parseDouble(input2);

        equals(operator);

        return this.answer;
    }

    public String percentConvert(String input, boolean isAnInput) {

        double inputAsDouble = Double.parseDouble(input);

        if (this.isPercent == false) {
            inputAsDouble /= 100;
        } else {
            inputAsDouble *= 100;
        }

        String convertToString = String.valueOf(inputAsDouble);

        if (isAnInput) {
            this.input1 = convertToString;
        } else {
            this.answer = inputAsDouble;
        }

        return convertToString;
    }

    private void concatenate(String stringToAdd) {
        if (this.operator == "") {
            this.input1 = this.input1 + stringToAdd;
        } else {
            this.input2 = this.input2 + stringToAdd;
        }
    }

    public void pressedInputButton(String input) {
        
        // set the text of the text field
        TextFieldPanel.setText(TextFieldPanel.getText() + input);

        // change boolean value if applicable
        if (isAnAnswer == true) {
            this.isAnAnswer = false;
        }

        concatenate(input);
    }

    public void pressedFuncButton(String operationInput) {

        // sets the operator
        this.operator = operationInput;

        // reset
        this.decimalCount = 0;

        // clear text field
        TextFieldPanel.setText("");
    }
}
