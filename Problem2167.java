import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Problem2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());// 행
        int m = Integer.parseInt(st.nextToken());// 열

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int row = Integer.parseInt(br.readLine());

        int a, b, c, d;
        int sum = 0;
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken()) - 1;
            d = Integer.parseInt(st.nextToken()) - 1;
            sum = 0;

            for (int j = a; j <= c; j++) {
                for (int k = b; k <= d; k++) {
                    sum += matrix[j][k];
                }
            }
            sb.append(sum + "\n");
        }
        System.out.print(sb);
    }
}
