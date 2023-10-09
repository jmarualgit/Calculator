package main;
public class Function {

    private double x;
    private double y;
    private double answer;
    private boolean isPercent = false;
    private Double parseDouble;

    Function(double xInput, double yInput) {
        this.x = xInput;
        this.y = yInput;
        this.isPercent = false;
    }

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

    public double equals(String input1, String input2) {

        this.x = Double.parseDouble(string)

        return
    }

    /*
    static double add(double input1, double input2) {

        return input1 + input2;
    }

    static double subtract(double input1, double input2) {
        return input1 - input2;
    }

    static double multiply(double input1, double input2) {
        return input1 * input2;
    }

    static double divide(double input1, double input2) {

        // dividing by 0 is bad
        if (input2 == 0) {
            return 0.0;
        } else {
            return input1 / input2;
        }
    }

    

    String deleteLeadingZeros(String string) {

        int position = 0;
        int stringLength = string.length();

        // while the position isn't at the last character and the character at the position is still 0
        while ((position < (stringLength - 1)) && (string.charAt(position) == '0')) {
            
            // move up across the screen
            position++;
        }

        string = string.substring(position);

        return string;
    }

    static String convertToPercent(String string) {

        // converts to double named number
        double number = convertToDouble(string);
        
        // divides number by 100 to convert to percent
        number /= 100;

        // returns value converted back to a string
        return String.valueOf(number);
    }

    static String convertFromPercent(String string) {

        // converts to a double named number
        double number = convertToDouble(string);

        // multiplies number by 100 (which is = moving decimal to the right 2x)
        // reversing the 'percentagification'
        number *= 100;

        return String.valueOf(number);
    }
    */
}
