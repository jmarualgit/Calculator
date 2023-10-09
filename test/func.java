package test;

public class func {

    private double x;
    private double y;
    private double answer;
    private boolean isPercent = false;
    private Double parseDouble;
    
    func(double xInput, double yInput) {

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

    public double getAnswer() {
        return this.answer;
    }

    public boolean isNumberPercent() {
        return this.isPercent;
    }

    public void add() {
        answer = this.x + this.y;
    }

    public void subtract() {
        answer = this.x - this.y;
    }

    public void multiply() {
        answer = this.x * this.y;
    }

    public void divide() {
        answer = this.x / this.y;
    }

    public void changeToPercent() {
        if (isPercent == false) {
            isPercent = true;
            answer/=100;
        } else {
            isPercent = false;
            answer*=100;
        }
    }
}
