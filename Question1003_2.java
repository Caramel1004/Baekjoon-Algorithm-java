import java.util.Scanner;

public class Question1003_2 {

    private static int[][] count;

    static int fibonacci(int n, int k) {

        if (n == 0) {
            count[k][0]++;
            return 0;
        } else if (n == 1) {
            count[k][1]++;
            return 1;
        }

        return fibonacci(n - 1, k) + fibonacci(n - 2, k);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        final int TEST_CASE_NUM = input.nextInt();

        count = new int[TEST_CASE_NUM][2];

        for (int i = 0; i < TEST_CASE_NUM; i++) {
            fibonacci(input.nextInt(), i);
        }

        input.close();

        for (int i = 0; i < TEST_CASE_NUM; i++) {
            System.out.println(count[i][0] + " " + count[i][1]);
        }
    }
}
