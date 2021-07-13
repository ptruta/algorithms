import static java.lang.Math.sqrt;

public class PrimeNumberUntilAGivenNumberLimit {

    public static boolean isPrime(int n) {
        if(n == 2)
            return true;
        if (n % 2 == 0) {
            return false;
        }
        if (n <= 1) {
            return false;
        }
        int upTo = (int)((sqrt(n))+1);
        int d=3;
        while (d < upTo) {
            if (n % d == 0)
            {
                return false;
            }
            d=d+2;
        }
        return true;
    }

    public static void generatePrimeNumberUntilAGivenNumber(int n) {
        int d = 2;
        while (d <= n) {
            if (isPrime(d)) {
                System.out.println(d);
            }
            d++;
        }

    }

    public static void main(String[] args) {
        int n = 98;
        generatePrimeNumberUntilAGivenNumber(n);
    }

}
