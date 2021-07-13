public class BubbleSortAlgorithm {

    public static int[] bubbleSort(int[] a) {

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = a.length - 1; j > i; j--) {
                if (a[j] < a[i]) {
                    int aux = a[i];
                    a[i] = a[j];
                    a[j] = aux;
                }
            }
        }

        return a;

    }

    public static void main(String[] args) {
        int[] a = {123, 543534, 3435, 500, 2323};
        int[] b = bubbleSort(a);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }

    }
}
