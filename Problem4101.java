import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Problem4101 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer testCase = new StringTokenizer(br.readLine());
        int integ1 = Integer.parseInt(testCase.nextToken());
        int integ2 = Integer.parseInt(testCase.nextToken());

        while (integ1 != 0 && integ2 != 0) {
            if (integ1 > integ2) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            testCase = new StringTokenizer(br.readLine());
            integ1 = Integer.parseInt(testCase.nextToken());
            integ2 = Integer.parseInt(testCase.nextToken());
        }
    }
}
