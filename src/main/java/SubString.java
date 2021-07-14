import java.util.ArrayList;
import java.util.List;

public class SubString {

    public static boolean canBeSegmented(String s, List<String> dict) {
        int count = 0;
        while (count < dict.size()) {
            // parse each element from the dictionary
            if (!s.contains(dict.get(count))) {
                return false;
            }
            count++;
        }

        return true;
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");
        dict.add("code");
        dict.add("dada");
        System.out.println(canBeSegmented("leetcode", dict));
    }

}
