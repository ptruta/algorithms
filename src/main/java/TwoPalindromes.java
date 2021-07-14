public class TwoPalindromes {

    public static boolean arePalindromes(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int i = 0;
        int j = b.length() - 1;
        while (i < a.length() && j > 0) {
            if (a.charAt(i) != b.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(arePalindromes("abc", "cba"));
    }

}
