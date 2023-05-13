import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Problem2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 행렬 A 입력
        int[][] matrixA = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrixA[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 행렬 B 입력
        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] matrixB = new int[m][k];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                matrixB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // -----------------------------------------------------------------------------------------
        // 2.행렬 계산
        int[][] matrixC = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int h = 0; h < m; h++) {
                    matrixC[i][j] += matrixA[i][h] * matrixB[h][j];
                }
                System.out.print(matrixC[i][j] + " ");
            }
            System.out.println();
        }
    }
}
