public class ProperExceptionHandling {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        try {
            calculator.divide(10, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class Calculator {
    public void divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        System.out.println("Result: " + (a / b));
    }
}
