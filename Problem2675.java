import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseSize = Integer.parseInt(br.readLine());

        String[] testCase;
        int repeatCount = 0;
        String[] str;

        for (int i = 0; i < testCaseSize; i++) {
            testCase = br.readLine().split(" ");
            repeatCount = Integer.parseInt(testCase[0]);
            str = testCase[1].split("");

            for (int j = 0; j < str.length; j++) {
                for (int k = 0; k < repeatCount; k++) {
                    System.out.print(str[j]);
                }
            }
            System.out.println();
        }
    }
}
