import java.util.HashMap;

public class AnagramsWithHashMap {
    public static boolean areAnagrams(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        HashMap<Character, Integer> firstCounter = new HashMap<Character, Integer>();
        HashMap<Character, Integer> secondCounter = new HashMap<Character, Integer>();

        int i = 0;

        char[] strArrayFirst = a.toCharArray();
        char[] strArrayTwo = b.toCharArray();

        for (char c : strArrayFirst) {
            if (firstCounter.containsKey(c)) {
                firstCounter.put(c, firstCounter.get(c) + 1);
            } else {
                firstCounter.put(c, 1);
            }
        }

        for (char c : strArrayTwo) {
            if (secondCounter.containsKey(c)) {
                secondCounter.put(c, secondCounter.get(c) + 1);
            } else {
                secondCounter.put(c, 1);
            }
        }
        i = 0;
        for (char charOne : strArrayFirst) {
            if (!firstCounter.get(charOne).equals(secondCounter.get(charOne))) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        System.out.println(areAnagrams("patriww", "iptwwra"));
    }
}
