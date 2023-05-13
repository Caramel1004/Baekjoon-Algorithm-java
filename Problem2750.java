import java.util.Scanner;

public class Problem2750 {

    static void swap(int idx1, int idx2, int[] arr) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    static void bubbleSort(int[] arr) {
        int size = arr.length;
        for (int i = size; i > 0; i--) {
            for (int k = 1; k < i; k++) {
                if (arr[k - 1] > arr[k]) {
                    swap(k - 1, k, arr);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int size = input.nextInt();
        int[] num = new int[size];
        for (int i = 0; i < size; i++) {
            num[i] = input.nextInt();
        }

        input.close();
        bubbleSort(num);

        for (int i = 0; i < size; i++) {
            System.out.println(num[i]);
        }

    }
}
