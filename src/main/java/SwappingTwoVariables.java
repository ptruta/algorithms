public class SwappingTwoVariables {
    // Driver Code
    public static void main(String[] args) {
        int a = 200;
        int b = 300;

        a = a - b;
        b = b + a;
        a = b - a;

        System.out.println(a+" " +b);
    }
}
