import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    public static int binarySearch(int[] a, Integer el) {

        return binarySearchUtils(a, 0, a.length - 1, el);

    }

    public static int binarySearchUtils(int[] a, int left, int right, int el) {

        if (left <= right && left < a.length - 1) {
            int middle = left + (right - left) / 2;
            if (el == a[middle]) {
                return middle;
            }
            if (el < a[middle]) {
                return binarySearchUtils(a, left, middle - 1, el);
            }
            return binarySearchUtils(a, middle + 1, right, el);
        }


        return -1;
    }

    public static void main(String[] args) {
        int[] a = {123,222,345,500,2323};
        int el = 345;

        System.out.println(binarySearch(a, el));
    }
}
