import java.util.Scanner;

public class Question11021 {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);

        final int TESTCASE_SIZE = input.nextInt();// 테스트케이스갯수

        int[] integSum = new int[TESTCASE_SIZE];// 두 정수의 합을 배열로 저장

        // 1. 입력된 정수를 바로 배열에 저장
        for (int k = 0; k < TESTCASE_SIZE; k++) {
            int integ1 = input.nextInt();
            int integ2 = input.nextInt();

            integSum[k] = integ1 + integ2;

        }

        // 2. 합 출력
        for (int k = 0; k < TESTCASE_SIZE; k++) {
            System.out.println("Case #" + (k + 1) + ": " + integSum[k]);
        }
    }
}
