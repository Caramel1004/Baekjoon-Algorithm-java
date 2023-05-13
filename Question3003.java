import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Question3003 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] testCase = br.readLine().split(" ");// 테스트 케이스
        int[] piece = { 1, 1, 2, 2, 2, 8 };// 킹 1개, 퀸 1개, 룩 2개, 비숍 2개, 나이트 2개, 폰 8개

        int count = 0;// 필요 갯수

        for (int i = 0; i < piece.length; i++) {

            count = piece[i] - Integer.parseInt(testCase[i]);

            System.out.print(count + " ");
        }

    }
}
