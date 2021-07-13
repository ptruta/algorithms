import java.util.stream.IntStream;

public class AnagramsVerification {
    public static boolean areAnagrams(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int[] counterOne = IntStream.range(0, 123).toArray();
        int[] counterTwo = IntStream.range(0, 123).toArray();
        int i = 0;
        int j = 0;
        while (i < a.length() && j < b.length()) {
            counterOne[a.charAt(i)]++;
            counterTwo[a.charAt(i)]++;
            i++;
            j++;
        }
        int first = 97;
        int last = 122;
        int firstOne = 65;
        int lastOne = 90;
        while ((counterOne[(char) first] == counterTwo[(char) first]
                || counterOne[(char) firstOne] == counterTwo[(char) firstOne])
                && (first < last || firstOne < lastOne)) {
            first = first + 1;
            firstOne = firstOne + 1;
        }

        return (first >= last || firstOne >= lastOne);
    }

    public static void main(String[] args) {
        System.out.println(areAnagrams("patriww24234", "iptw3434wra"));
    }
}
