import java.util.Scanner;

// Task 1: Find Minimum Element
class Task1 {
    static int minElement(int[] arr, int i) {
        return (i == 0) ? arr[0] : Math.min(arr[i], minElement(arr, i - 1));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(minElement(arr, n - 1));
    }
    // Time Complexity: O(n)
    // Space Complexity: O(n) (due to recursion stack)
}

// Task 2: Find Average
class Task2 {
    static int sumElements(int[] arr, int i) {
        return (i < 0) ? 0 : arr[i] + sumElements(arr, i - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println((double) sumElements(arr, n - 1) / n);
    }
    // Time Complexity: O(n)
    // Space Complexity: O(n) (due to recursion stack)
}

// Task 3: Check if Prime
class Task3 {
    static boolean isPrime(int n, int d) {
        return (n < 2) ? false : (d * d > n) || (n % d != 0 && isPrime(n, d + 1));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(isPrime(sc.nextInt(), 2) ? "Prime" : "Composite");
    }
    // Time Complexity: O(√n)
    // Space Complexity: O(√n) (due to recursion stack)
}

// Task 4: Factorial
class Task4 {
    static int factorial(int n) {
        return (n == 0) ? 1 : n * factorial(n - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(factorial(sc.nextInt()));
    }
    // Time Complexity: O(n)
    // Space Complexity: O(n) (due to recursion stack)
}

// Task 5: Fibonacci Sequence
class Task5 {
    static int fibonacci(int n) {
        return (n < 2) ? n : fibonacci(n - 1) + fibonacci(n - 2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(fibonacci(sc.nextInt()));
    }
    // Time Complexity: O(2^n)
    // Space Complexity: O(n) (due to recursion stack)
}

// Task 6: Power Function
class Task6 {
    static int power(int a, int n) {
        return (n == 0) ? 1 : a * power(a, n - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(power(sc.nextInt(), sc.nextInt()));
    }
    // Time Complexity: O(n)
    // Space Complexity: O(n) (due to recursion stack)
}

// Task 7: Generate Permutations
class Task7 {
    static void generatePermutations(String s, String prefix) {
        if (s.isEmpty()) System.out.println(prefix);
        else for (int i = 0; i < s.length(); i++)
            generatePermutations(s.substring(0, i) + s.substring(i + 1), prefix + s.charAt(i));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        generatePermutations(sc.next(), "");
    }
    // Time Complexity: O(n!)
    // Space Complexity: O(n) (due to recursion stack)
}

// Task 8: Check if String is All Digits
class Task8 {
    static boolean containsOnlyDigits(String s) {
        return s.isEmpty() || (Character.isDigit(s.charAt(0)) && containsOnlyDigits(s.substring(1)));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(containsOnlyDigits(sc.next()) ? "Yes" : "No");
    }
    // Time Complexity: O(n)
    // Space Complexity: O(n) (due to recursion stack)
}

// Task 9: Binomial Coefficient
class Task9 {
    static int binomialCoefficient(int n, int k) {
        return (k == 0 || k == n) ? 1 : binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(binomialCoefficient(sc.nextInt(), sc.nextInt()));
    }
    // Time Complexity: O(2^n)
    // Space Complexity: O(n) (due to recursion stack)
}

// Task 10: GCD using Euclidean Algorithm
class Task10 {
    static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(gcd(sc.nextInt(), sc.nextInt()));
    }
    // Time Complexity: O(log n)
    // Space Complexity: O(log n) (due to recursion stack)
}
