import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Question1003_3 {

    private static int[][] count;

    static void fibonacci(int n, int idx) {

        int tmp = 0;
        int tmp0 = 1;
        int tmp1 = 1;

        if (n == 0) {
            count[idx][0]++;
            return;
        } else if (n == 1) {
            count[idx][1]++;
            return;
        } else {
            for (int i = 2; i < n; i++) {
                tmp = tmp1;
                tmp1 += tmp0;
                tmp0 = tmp;
            }

            count[idx][0] = tmp0;
            count[idx][1] = tmp1;

        }

        return;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int TEST_CASE_NUM = Integer.parseInt(br.readLine());

        count = new int[TEST_CASE_NUM][2];

        for (int idx = 0; idx < TEST_CASE_NUM; idx++) {

            fibonacci(Integer.parseInt(br.readLine()), idx);
        }

        br.close();

        for (int i = 0; i < TEST_CASE_NUM; i++) {
            bw.write(count[i][0] + " " + count[i][1] + "\n");
        }

        bw.close();
    }
}
