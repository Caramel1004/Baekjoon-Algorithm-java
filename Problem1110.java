// 링크 : https://www.acmicpc.net/problem/1110
// 더하기 사이클
// 문제
// 0보다 크거나 같고, 99보다 작거나 같은 정수가 주어질 때 다음과 같은 연산을 할 수 있다. 먼저 주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수로 만들고, 각 자리의 숫자를 더한다. 그 다음, 주어진 수의 가장 오른쪽 자리 수와 앞에서 구한 합의 가장 오른쪽 자리 수를 이어 붙이면 새로운 수를 만들 수 있다. 다음 예를 보자.

// 26부터 시작한다. 2+6 = 8이다. 새로운 수는 68이다. 6+8 = 14이다. 새로운 수는 84이다. 8+4 = 12이다. 새로운 수는 42이다. 4+2 = 6이다. 새로운 수는 26이다.

// 위의 예는 4번만에 원래 수로 돌아올 수 있다. 따라서 26의 사이클의 길이는 4이다.

// N이 주어졌을 때, N의 사이클의 길이를 구하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 N이 주어진다. N은 0보다 크거나 같고, 99보다 작거나 같은 정수이다.

// 출력
// 첫째 줄에 N의 사이클 길이를 출력한다.

// 예제 입력 1 
// 26
// 예제 출력 1 
// 4
// 예제 입력 2 
// 55
// 예제 출력 2 
// 3
// 예제 입력 3 
// 1
// 예제 출력 3 
// 60
// 예제 입력 4 
// 0
// 예제 출력 4 
// 1
// 예제 입력 5 
// 71
// 예제 출력 5 
// 12

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] digit = br.readLine().split("");// 문자열의배열형 자릿 수
        String digitStr = String.join("", digit);// 문자열형 자릿 수
        String compDigit = digitStr;// 처음 입력된 자릿 수 -> 한 사이클 후 나온 자릿수와 비교하기 위한 변수
        int cycleCount = 0;// 사이클 횟수

        int sumOfDigit = 0;// 각 자릿 수의 합 정수형
        String sumOfDigitStr = "";// 각 자릿 수의 합 문자열형

        // 한 자릿수면 0추가
        if (digit.length < 2) {
            digitStr = "0" + digitStr;
            digit = digitStr.split("");
            compDigit = digitStr;
        }

        // System.out.println("digitStr : " + digitStr);
        // System.out.println("digit : " + digit[0] + "" + digit[1]);
        // System.out.println(digitStr.equals(compDigit));

        while (!digitStr.equals(compDigit) || cycleCount == 0) {

            sumOfDigit = Integer.parseInt(digit[0]) + Integer.parseInt(digit[1]);
            sumOfDigitStr = Integer.toString(sumOfDigit);

            // System.out.println("sumOfDigit : " + sumOfDigit);

            if (sumOfDigit >= 10) {
                sumOfDigitStr = String.valueOf(sumOfDigitStr.charAt(1));
            }

            digitStr = digit[1] + sumOfDigitStr;
            digit = digitStr.split("");
            cycleCount++;

            // System.out.println("digitStr : " + digitStr);
            // System.out.println("digit : " + digit[0] + "" + digit[1]);
            // System.out.println("cycleCount : " + cycleCount);
            // System.out.println(digitStr.equals(compDigit));
        }

        System.out.println(cycleCount);
    }
}
