import java.util.ArrayList;
import java.util.List;

public class LongestPalindromeSubstring {

    public static boolean isPalindrome(String a) {
        int i = 0;

        int limitInferior = 0;

        if (a.length() % 2 == 0) {
            limitInferior = (int)(a.length() / 2);
        } else {
            limitInferior = (int)(a.length() / 2) + 1;
        }

        int j = a.length() - 1;
        while (i < (int)(a.length() / 2) && j >= limitInferior && a.charAt(i) == a.charAt(j)) {
            j--;
            i++;
        }

        if (i > (int)(a.length() / 2) || j < limitInferior) {
            return true;
        }
        return false;
    }

    public static String longestSubsequence(String a) {
        int max = 0;
        String longest = null;
        for (int i = 0; i < a. length(); i++) {
            for (int j = i + 1; j <= a.length(); j++) {
                if (isPalindrome(a.substring(i,j))){
                    if (a.substring(i,j).length() > max) {
                        max = a.substring(i,j).length();
                        longest = a.substring(i,j);
                    }
                }
            }
        }

        return longest;
    }

    public static void main(String[] args)
    {
        System.out.println(longestSubsequence("forgeeksskeegfor"));
    }
}
