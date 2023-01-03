// 링크 : https://www.acmicpc.net/problem/1065
// 문제
// 어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오. 

// 입력
// 첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.

// 출력
// 첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.

// 예제 입력 1 
// 110
// 예제 출력 1 
// 99
// 예제 입력 2 
// 1
// 예제 출력 2 
// 1
// 예제 입력 3 
// 210
// 예제 출력 3 
// 105
// 예제 입력 4 
// 1000
// 예제 출력 4 
// 144
// 예제 입력 5 
// 500
// 예제 출력 5 
// 119
import java.io.*;

public class Problem1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int netuNum = Integer.parseInt(br.readLine());
        int hansuCount = 0;// 한수 갯수
        int tmp = 0;// 임시저장 변수 -> 그냥 의미없는 수 담는 변수
        int[] diff;// 수 차이 배열

        for (int num = 1; num <= netuNum; num++) {
            tmp = 0;// 임시저장
            String[] str = Integer.toString(num).split("");
            diff = new int[str.length - 1];// 차이를 순서대로 문자열로 저장 수차이 배열길이 -> ex) 1 | 2 | 3 | 4 작대기가 diff갯수
            if (num < 100) {
                hansuCount++;
            } else {
                for (int i = 1; i <= diff.length; i++) {
                    tmp = Integer.parseInt(str[i]) - Integer.parseInt(str[i - 1]);
                    diff[i - 1] = tmp;
                }
                tmp = 0;

                for (int i = 0; i < diff.length; i++) {
                    if (diff[0] == diff[i]) {
                        tmp++;
                    }
                }

                if (diff.length == tmp) {
                    // System.out.println(num); // -> 세 자릿수 한수 보고 싶으면 주석처리 해제
                    hansuCount++;
                }
            }
        }

        System.out.println(hansuCount);
    }
}
