import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] arr1 = br.readLine().split(" ");

        int m = Integer.parseInt(br.readLine());
        String[] arr2 = br.readLine().split(" ");

        int count = 0;

        // arr2의 요소들이 arr1에 몇개나 있는지 검색
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {// arr1 배열 검색
                if (Integer.parseInt(arr1[j]) == Integer.parseInt(arr2[i])) {
                    count++;
                    if (i < (m - 1)) {
                        sb.append("1\n");
                    } else if (i == (m - 1)) {
                        sb.append("1");
                    }
                    break;
                }
            }

            if (count == 0 && i < (m - 1)) {
                sb.append("0\n");
            } else if (count == 0 && i == (m - 1)) {
                sb.append("0");
            }

            count = 0;

        }

        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();

    }
}
