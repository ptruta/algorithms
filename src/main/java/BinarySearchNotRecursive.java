public class BinarySearchNotRecursive {
    public static int binarySearch(int[] a, Integer el) {

        int left = 0;
        int right = a.length - 1;

        while (left <= right && left < a.length - 1) {
            int middle = left + (right - left) / 2;
            if (el == a[middle]) {
                return middle;
            }
            if (el < a[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }

        }

        return -1;

    }

    public static void main(String[] args) {
        int[] a = {123, 222, 345, 500, 2323};
        int el = 777;

        System.out.println(binarySearch(a, el));
    }
}
