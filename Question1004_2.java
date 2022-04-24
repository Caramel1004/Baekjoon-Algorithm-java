import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Question1004_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test_case_size = Integer.parseInt(br.readLine());
        int[] result = new int[test_case_size];

        for (int k = 0; k < test_case_size; k++) {
            int start_x = Integer.parseInt(br.readLine());
            int start_y = Integer.parseInt(br.readLine());

            int end_x = Integer.parseInt(br.readLine());
            int end_y = Integer.parseInt(br.readLine());

            int circle_num = Integer.parseInt(br.readLine());

            for (int i = 0; i < circle_num; i++) {
                int mid_x = Integer.parseInt(br.readLine());
                int mid_y = Integer.parseInt(br.readLine());
                int radius = Integer.parseInt(br.readLine());

                double distance = (double) Math.sqrt(Math.pow(start_x - mid_x, 2) + Math.pow(start_y - mid_y, 2));

                if (distance < radius && distance >= 0) {
                    result[k]++;
                }

                distance = (double) Math.sqrt(Math.pow(end_x - mid_x, 2) + Math.pow(end_y - mid_y, 2));

                if (distance < radius && distance >= 0) {
                    result[k]++;
                }
            }

            bw.write(result[k] + "\n");

        }

        br.close();
        bw.close();
    }

}