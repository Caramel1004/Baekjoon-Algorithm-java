//문제 링크 : https://www.acmicpc.net/problem/10998

// 문제
// 두 정수 A와 B를 입력받은 다음, A×B를 출력하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)

// 출력
// 첫째 줄에 A×B를 출력한다.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Question10998 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 두 정수 입력
        int integ1 = Integer.parseInt(br.readLine());
        int integ2 = Integer.parseInt(br.readLine());

        // 2. 두 정수의 곱
        // String multi = Integer.toString(integ1 * integ2);
        int multi = integ1 * integ2;

        // 정수형을 BufferedWriter에 넣고 싶으면, String형으로의 변환이 필요함.
        // bw.write(multi + ""); // -> 문자열로 변환됨
        // bw.write(String.valueOf(multi)); -> String 클래스에 있는 valueOf 메소드 사용하여 문자열로 변환
        bw.write(Integer.toString(multi));

        bw.close();
        br.close();
    }
}
