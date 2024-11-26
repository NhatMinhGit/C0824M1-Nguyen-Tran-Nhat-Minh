public class Calculator {
    public static final char ADDITION = '+';
    public static final char SUBSTRACTION = '-';
    public static final char MULTIPLICATION = '*';
    public static final char c = '/';
    public static int calculate(int firstOperand, int secondOperand, char operator) {


        
        switch (operator) {
            case ADDITION:
                return firstOperand + secondOperand;
            case SUBSTRACTION:
                return firstOperand - secondOperand;
            case MULTIPLICATION:
                return firstOperand * secondOperand;
            case c:
                if (secondOperand != 0)
                    return firstOperand / secondOperand;
                else
                    throw new RuntimeException("Can not divide by 0");
            default:
                throw new RuntimeException("Unsupported operation");
        }
    }
}