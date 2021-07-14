import java.util.ArrayList;
import java.util.List;

class Pair {
    Integer key;
    Integer value;

    Pair(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}

public class AllThePalindromePairs {


    public static boolean arePalindromes(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int i = 0;
        int j = b.length() - 1;
        while (i < a.length() && j >= 0) {
            if (a.charAt(i) != b.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static List<Pair> allThePalindromesPairs(List<String> elements) {

        List<Pair> sortedMap = new ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {
            for (int j = 0; j < elements.size(); j++) {
                if (i != j && arePalindromes(elements.get(i), elements.get(j))) {
                    Pair e = new Pair(i, j);
                    sortedMap.add(e);
                }
            }
        }

        return sortedMap;
    }

    public static void main(String[] args) {

        List<String> words = new ArrayList<>();
        words.add("bat");
        words.add("tab");
        words.add("cat");
        words.add("tab");
        words.add("bat");
        words.add("tac");

        List<Pair> sortedMap = allThePalindromesPairs(words);

        for (Pair el : sortedMap) {
            System.out.print("[" + el.getKey() + "," + el.getValue() + "]");
        }
    }
}
