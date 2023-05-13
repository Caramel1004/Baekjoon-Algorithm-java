import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseSize = Integer.parseInt(br.readLine());
        String[] testCase;

        for (int i = 0; i < testCaseSize; i++) {
            testCase = br.readLine().split("");
            System.out.println(testCase[0] + "" + testCase[testCase.length - 1]);
        }
    }
}