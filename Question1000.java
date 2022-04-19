// 문제
// 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)

// 출력
// 첫째 줄에 A+B를 출력한다.
import java.util.Scanner;

public class Question1000 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // 1. 두 정수 입력
        int integ1 = input.nextInt();
        int integ2 = input.nextInt();

        input.close();

        // 2.두 정수의 합
        int sum = integ1 + integ2;

        System.out.println(sum);
    }
}
