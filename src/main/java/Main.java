public class Main {
    public static void main(String[] args){

        int[] v = {79875,5345,234,2342,3423,423,423,4,234,23,42,34,234,234,2342,32,3,32,32,32,43,34};
        int n = 22;
        int k = 3;
        rotation(n,k,v);
        //rotationOne(n,k,v);


    }

    public static void rotation(int n, int k, int[] v){
        int[] temp = new int[n];

        int contor = n-k;
        int i=0;

        while (contor < n) {
            temp[i] = v[contor];
            i = i + 1;
            contor = contor + 1;
        }

        i = n;
        int j = 0;
        temp[n-1] = v[n-k-1];
        while (i > 0 && j < n-k-1) {
            temp[n-i+k] = v[j];
            i = i - 1;
            j = j + 1;
        }

        i = 0;
        while (i < n){
            v[i] = temp[i];
            i = i + 1;
        }

        for (i = 0; i < n; i++) {
            System.out.println(v[i]);
        }

    }

    public static void rotationOne(int n, int k, int[] v) {
        int i;
        int len = v.length;
        int[] temp = new int[len * 2];

        for (i = 0; i < n; i++) {
            temp[i + n] = v[i];
        }

        for (i = 0; i < n*2; i++) {
            System.out.println(temp[i]);
        }

        System.out.println("\nNew ");
        for (i = n - k + 3; i < n * 2 + k + 3; i++) {
            System.out.println(temp[i]);
        }
    }

}

