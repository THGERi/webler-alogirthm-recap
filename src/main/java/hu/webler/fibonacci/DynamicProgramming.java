package hu.webler.fibonacci;

public class DynamicProgramming {

    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34

    public static void main(String[] args) {

        int n = 10; // Change this to the desired Fibonacci sequence term
        System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));
    }

    /*
    Fibonacci(2) = Fibonacci(1) + Fibonacci(0)  // 1 + 0 = 1
    Fibonacci(3) = Fibonacci(2) + Fibonacci(1)  // 1 + 1 = 2
    Fibonacci(4) = Fibonacci(3) + Fibonacci(2)  // 2 + 1 = 3
    ...
    Fibonacci(9) = Fibonacci(8) + Fibonacci(7)  // 21 + 13 = 34
    Fibonacci(10) = Fibonacci(9) + Fibonacci(8) // 34 + 21 = 55
    */

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n -1 ) + fibonacci(n - 2);
    }
}