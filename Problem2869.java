// -------------이해를 위한 내 정리----------------
// testCase : a : 45, b : 32, v : 700
// 1일동안 13 올라가므로 수학적으로 접근하면 
// 첫날에는 높이 0부터 출발 하기 때문에 첫날에는 45 만큼 올라갑니다 두쨋날 부터 달팽이의 수면시간을 포함 하면 하루에 13 올라가는 것 이지요. 13만큼 올라가는 일수를 quota로 놓으면  45 + 13 x quota >= 700
// 부등식을 정리하면 quota >= 50.3xxxx 로 나오고 여기서 13만큼 올라간 일 수의 최솟값인 51을 얻을 수 있습니다. 여기서 주의 45만큼 올라간 1일도 더해야겠죠^^ 따라서 52일에 탈출하는 것이지요.
// 수식을 일반화 하면 a + (a - b) x quota >= v
// 따라서 코드는 이렇게 쓸 수 있겠네요.
// 여기서 주의할 점이 하나 있는데요. 나머지가 0인 경우가 있는데 이경우에는 1만 더해 주셔야 됩니다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Problem2869 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int totalDay = 0;

        int quota = (v - a) / (a - b);
        int rest = (v - a) % (a - b);

        if (rest > 0) {
            totalDay = (quota + 2);
        } else {
            totalDay = (quota + 1);
        }

        System.out.print(totalDay);

    }// main
}