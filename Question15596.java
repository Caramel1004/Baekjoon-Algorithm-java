import java.util.Scanner;

public class Question15596 {

    static long sumFunc(int[] arr) {

        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum;
    }
}
