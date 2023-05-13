import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Question11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int strSize = Integer.parseInt(br.readLine());

        String[] testCase = new String[strSize];

        testCase = br.readLine().split("");

        int sum = 0;
        for (int i = 0; i < strSize; i++) {
            sum += Integer.parseInt(testCase[i]);
        }
        System.out.println(sum);
    }
}
