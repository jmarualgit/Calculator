package main;
public class Function {

    private double x;
    private double y;
    private double answer;
    //private boolean isPercent = false;
    //private Double parseDouble;

    Function(double xInput, double yInput) {
        this.x = xInput;
        this.y = yInput;
        //this.isPercent = false;
    }

    // yet to be used
    /* 
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double newValue) {
        this.x = parseDouble;
    }

    public void setY(double newValue) {
        this.y = newValue;
    }
    */

    private void add() {
        answer = this.x + this.y;
    }

    private void subtract() {
        answer = this.x - this.y;
    }

    private void multiply() {
        answer = this.x * this.y;
    }

    private void divide() {
        answer = this.x / this.y;
    }

    public double equals(String input1, String input2, String operator) {

        this.x = Double.parseDouble(input1);
        this.y = Double.parseDouble(input2);


        // if else statements depending on operator
        switch(operator) {

            // for addition
            case "+":

                // add the two
                add();

                break;
            
            // for subtraction
            case "-":

                // subtract the two
                subtract();

                break;

            // for multiplication
            case "x":

                // multiply the two
                multiply();

                break;
            
            // for dividing
            case "/":

                // divide the two
                divide();

                break;
        }

        return answer;
    }

    public String percentConvert(String string, boolean isPercent) {
        // converts to double named number
        double number = Double.parseDouble(string);
        
        if (isPercent == false) {
            number /= 100;
        } else {
            number *= 100;
        }

        // returns value converted back to a string
        return String.valueOf(number);
    }
}
