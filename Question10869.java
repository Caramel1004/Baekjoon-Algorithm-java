
// 문제 링크 : https://www.acmicpc.net/problem/10869
// 문제
// 두 자연수 A와 B가 주어진다. 이때, A+B, A-B, A*B, A/B(몫), A%B(나머지)를 출력하는 프로그램을 작성하시오. 

// 입력
// 두 자연수 A와 B가 주어진다. (1 ≤ A, B ≤ 10,000)

// 출력
// 첫째 줄에 A+B, 둘째 줄에 A-B, 셋째 줄에 A*B, 넷째 줄에 A/B, 다섯째 줄에 A%B를 출력한다.

import java.util.Scanner;

public class Question10869 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        int b = input.nextInt();

        input.close();

        int[] arithmetic = {
                a + b,
                a - b,
                a * b,
                a / b,
                a % b
        };

        for (int i = 0; i < arithmetic.length; i++) {
            System.out.println(arithmetic[i]);
        }
    }
}
