import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Question15552 {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int TESTCASE_SIZE = Integer.parseInt(br.readLine());// 테스트케이스갯수
        String[] testCase = new String[2];// 각각의 테스트 케이스 변수

        for (int k = 0; k < TESTCASE_SIZE; k++) {
            testCase = br.readLine().split(" ");// 공백을 구분
            bw.write((Integer.parseInt(testCase[0]) + Integer.parseInt(testCase[1])) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
