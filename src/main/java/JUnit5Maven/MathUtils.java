package JUnit5Maven;

public class MathUtils {

    public int add(int a, int b){
        return a+b;
    }

    public double computeCircleArea(double radius){
        return Math.PI * Math.pow(radius, 2);
    }

    public int divide(int a, int b){
        if (b == 0){
            throw new ArithmeticException();
        }
        return a/b;
    }

    public int multiply(int a, int b) {
        return a*b;
    }
}
