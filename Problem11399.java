
/**1 2 3 4 5
 * 3 1 4 3 2
 * 
 * 돈을 인출하는데에 걸리는 최소시간을 먼저 선택
 * 1 (1)-> 2 (3)-> 3 (6)-> 3 (9)-> 4(13)
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class Problem11399 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int personNum = Integer.parseInt(st.nextToken());
        int minTime = 0;// 최소시간의 누적시간 총합
        int[] time = new int[personNum];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < personNum; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time);

        int sum = 0;// 누적 시간
        for (int timeLine : time) {
            // System.out.println("timeLine : " + time);
            sum += timeLine;
            // System.out.println("sum : " + sum);
            minTime += sum;
            // System.out.println("minTime : " + minTime);
        }

        System.out.println(minTime);
    }// main
}
