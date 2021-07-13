import java.util.ArrayList;
import java.util.List;

public class LinearSearch {

    public static boolean linearSearchOne(Integer el, List<Integer> a){
        return a.contains(el);
    }

    public static boolean linearSearchTwo(int el, int[] a) {

        if (el == a[0]) {
            return true;
        } else
        {
            int i=0;
            while (i<a.length-1 && el != a[i]) {
                i=i+1;
            }
            if(el == a[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        List<Integer> a = new ArrayList<>();
        a.add(123);
        a.add(200);
        a.add(400);
        int el = 400;
        System.out.println(linearSearchOne(el,a));

        int[] a1 = {1,2,3,4,5,6};
        el = 100;

        System.out.println(linearSearchTwo(el,a1));
    }
}
