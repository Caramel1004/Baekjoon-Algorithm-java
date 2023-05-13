import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr1 = br.readLine().split(" ");// n개의 정수들이 문자열로 공백이루며 저장

        int m = Integer.parseInt(br.readLine());
        String[] arr2 = br.readLine().split(" ");// m개의 정수들이 문자열로 공백이루며 저장

        int comp = 0;
        int[] count = new int[m];

        // arr2의 요소들이 arr1에 몇개나 있는지 검색
        for (int i = 0; i < m; i++) {
            comp = Integer.parseInt(arr2[i]);
            for (int j = 0; j < n; j++) {// arr1 배열 검색
                if (Integer.parseInt(arr1[j]) == comp) {
                    count[i]++;// 1
                    break;
                }
            }
            bw.write(count[i] + "\n");
        }

        bw.flush();
        bw.close();

    }
}
