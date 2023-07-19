public class Function {

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

    static double convertToDouble(String string) {

        return Double.parseDouble(string);
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
}
