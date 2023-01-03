
/**
#문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
#입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

#출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.

예제 입력 1 
3 1
예제 출력 1 
1
2
3
예제 입력 2 
4 2
예제 출력 2 
1 2
1 3
1 4
2 1
2 3
2 4
3 1
3 2
3 4
4 1
4 2
4 3
예제 입력 3 
4 4
예제 출력 3 
1 2 3 4
1 2 4 3
1 3 2 4
1 3 4 2
1 4 2 3
1 4 3 2
2 1 3 4
2 1 4 3
2 3 1 4
2 3 4 1
2 4 1 3
2 4 3 1
3 1 2 4
3 1 4 2
3 2 1 4
3 2 4 1
3 4 1 2
3 4 2 1
4 1 2 3
4 1 3 2
4 2 1 3
4 2 3 1
4 3 1 2
4 3 2 1
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15649 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());// 1부터 n까지 자연수
        int m = Integer.parseInt(st.nextToken());// n개중 m개 뽑아서 정렬
        int lastIndex = (n - m);//
        int combi = (m - 1);

        String[] num = new String[n];

        for (int i = 0; i < n; i++) {
            num[i] = Integer.toString(i + 1);
            // System.out.println(num[i]);
        }

        // 배열 num에서 m개 뽑아서 정렬하고 문자열 형태로 저장
        // n - m
        for (int ptr = 0; ptr <= lastIndex; ptr++) {
            for (int i = (ptr + 1); i < combi; i++) {
                sb.append(num[ptr] + " ");
                sb.append(num[ptr + 1]);
                sb.append(num[i]);
            }
        }
    }
}
