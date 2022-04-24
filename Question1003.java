//RunTime 에러
// 문제 링크 : https://www.acmicpc.net/problem/1003

import java.util.Scanner;

public class Question1003 {

    private static int count0;
    private static int count1;

    static int fibonacci(int n) {

        if (n == 0) {
            count0++;
            return 0;
        } else if (n == 1) {
            count1++;
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        final int TEST_CASE_NUM = input.nextInt();

        int num[] = new int[TEST_CASE_NUM];
        int[][] count = new int[TEST_CASE_NUM][2];

        for (int i = 0; i < TEST_CASE_NUM; i++) {
            num[i] = input.nextInt();
            fibonacci(num[i]);
            count[i][0] = count0;
            count[i][1] = count1;

            count0 = 0;
            count1 = 0;
        }

        input.close();

        for (int i = 0; i < TEST_CASE_NUM; i++) {
            System.out.println(count[i][0] + " " + count[i][1]);
        }
    }
}
