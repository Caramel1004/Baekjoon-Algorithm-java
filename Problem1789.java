import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long sum = Long.parseLong(br.readLine());// 자연수 n개의 합

        // 주어진 합이 최대한 많이 서로 다른 자연수들의 합으로 구성되어져야 함으로
        // 최대한 많은 자연수를 선택하려면 선택되지 않은 최소값을 선택한다.
        // 그래서 1부터 1씩 증가하는 수를 선택하자
        long n = 1;// 항 갯수
        long seqSum = (n * (n + 1)) / 2;// 연속 합

        // 항 갯수가 몇개 일 때 주어진 합을 넘는지 조회
        while (seqSum < sum) {
            n++;
            seqSum = (n * (n + 1)) / 2;
        }

        // System.out.println("seqSum : " + seqSum);
        // System.out.println("n : " + n);

        if (seqSum == sum) {
            System.out.println(n);
        } else {
            while (true) {
                n--;
                seqSum = (n * (n + 1)) / 2;
                if (sum - seqSum > n) {
                    n++;// ex) 1+...+18 = 171 171 + 29 = 200 1~18 : 18개, 29 : 1개 총19개 그래서 갯수 하나 추가
                    System.out.println(n);
                    return;
                }
            }
        }

    }
}
