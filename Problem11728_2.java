// 문제
// 정렬되어있는 두 배열 A와 B가 주어진다. 두 배열을 합친 다음 정렬해서 출력하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 배열 A의 크기 N, 배열 B의 크기 M이 주어진다. (1 ≤ N, M ≤ 1,000,000)

// 둘째 줄에는 배열 A의 내용이, 셋째 줄에는 배열 B의 내용이 주어진다. 배열에 들어있는 수는 절댓값이 109보다 작거나 같은 정수이다.

// 출력
// 첫째 줄에 두 배열을 합친 후 정렬한 결과를 출력한다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

//통과
public class Problem11728_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String[] arrA = new String[Integer.parseInt(st.nextToken())];
        String[] arrB = new String[Integer.parseInt(st.nextToken())];

        arrA = br.readLine().split(" ");
        arrB = br.readLine().split(" ");

        int ptrA = 0;// A배열 포인터 0번째 부터
        int ptrB = 0;// B배열 포인터 0번째 부터

        /** 정렬이 이미 된 각각의 배열이기 때문에 포인터로 이동하면서 비교 한다. 포인터는 곧 배열의 인덱스를 의미함 */
        while (true) {
            /** 배열 A B 중에서 하나라도 끝지점 넘으면 남은 배열의 요소 리스트에 추가 하고 반복문 break */
            if (ptrA >= arrA.length) {
                for (int i = ptrB; i < arrB.length; i++) {
                    sb.append(arrB[i] + " ");
                }
                break;
            } else if (ptrB >= arrB.length) {
                for (int i = ptrA; i < arrA.length; i++) {
                    sb.append(arrA[i] + " ");
                }
                break;
            }

            /** 포인터가 이동하면서 배열의 요소를 비교 */
            if (Integer.parseInt(arrA[ptrA]) < Integer.parseInt(arrB[ptrB])) {
                sb.append(arrA[ptrA] + " ");
                ptrA++;
            } else {
                sb.append(arrB[ptrB] + " ");
                ptrB++;
            }
        }

        System.out.println(sb);

    }// main

}