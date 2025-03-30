import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int task = sc.nextInt();

        switch (task) {
            case 1 -> {
                int n = sc.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
                System.out.println(minElement(arr, n - 1));
                public static int sum(int a, int b)
            }
            case 2 -> {
                int n = sc.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
                System.out.println((double) sumElements(arr, n - 1) / n);
            }
            case 3 -> System.out.println(isPrime(sc.nextInt(), 2) ? "Prime" : "Composite");
            case 4 -> System.out.println(factorial(sc.nextInt()));
            case 5 -> System.out.println(fibonacci(sc.nextInt()));
            case 6 -> System.out.println(power(sc.nextInt(), sc.nextInt()));
            case 7 -> generatePermutations(sc.next());
            case 8 -> System.out.println(containsOnlyDigits(sc.next()) ? "Yes" : "No");
            case 9 -> System.out.println(binomialCoefficient(sc.nextInt(), sc.nextInt()));
            case 10 -> System.out.println(gcd(sc.nextInt(), sc.nextInt()));
        }
    }

    static int minElement(int[] arr, int i) {
        return (i == 0) ? arr[0] : Math.min(arr[i], minElement(arr, i - 1));
    }

    static int sumElements(int[] arr, int i) {
        return (i < 0) ? 0 : arr[i] + sumElements(arr, i - 1);
    }

    static boolean isPrime(int n, int d) {
        return (n < 2) ? false : (d * d > n) || (n % d != 0 && isPrime(n, d + 1));
    }

    static int factorial(int n) {
        return (n == 0) ? 1 : n * factorial(n - 1);
    }

    static int fibonacci(int n) {
        return (n < 2) ? n : fibonacci(n - 1) + fibonacci(n - 2);
    }

    static int power(int a, int n) {
        return (n == 0) ? 1 : a * power(a, n - 1);
    }

    static void generatePermutations(String s) {
        findPermutations(s, "");
    }

    static void findPermutations(String s, String prefix) {
        if (s.isEmpty()) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < s.length(); i++) {
                findPermutations(s.substring(0, i) + s.substring(i + 1), prefix + s.charAt(i));
            }
        }
    }

    static boolean containsOnlyDigits(String s) {
        return s.isEmpty() || (Character.isDigit(s.charAt(0)) && containsOnlyDigits(s.substring(1)));
    }

    static int binomialCoefficient(int n, int k) {
        return (k == 0 || k == n) ? 1 : binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
    }

    static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}

