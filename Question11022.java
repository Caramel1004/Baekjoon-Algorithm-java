import java.util.Scanner;

public class Question11022 {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);

        final int TESTCASE_SIZE = input.nextInt();// 테스트케이스갯수
        final int TESTCASE_NUM = 2;// 요소수

        int[] integSum = new int[TESTCASE_SIZE];// 두 정수의 합을 배열로 저장
        int[][] testCaseData = new int[TESTCASE_SIZE][TESTCASE_NUM];

        // 1. 입력된 정수를 바로 배열에 저장
        for (int k = 0; k < TESTCASE_SIZE; k++) {
            for (int i = 0; i < TESTCASE_NUM; i++) {
                testCaseData[k][i] = input.nextInt();
            }

            integSum[k] = testCaseData[k][0] + testCaseData[k][1];
        }

        // 2. 합 출력
        for (int k = 0; k < TESTCASE_SIZE; k++) {
            System.out.println(
                    "Case #" + (k + 1) + ": " + testCaseData[k][0] + " + " + testCaseData[k][1] + " = " + integSum[k]);
        }

    }
}
