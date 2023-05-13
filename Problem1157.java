import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.Math;
import java.util.Arrays;

public class Problem1157 {

    static int countMax(int[] arr) {

        int max = arr[0];
        int count = 1;

        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                count = 1;
            } else if (max == arr[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 아스키 코드 A : 65, Z : 90 -> 65 ~ 90
        // 아스키 코드 a : 97, z : 122 -> 97 ~ 122
        String str = br.readLine();
        int[] asciiCode = new int[str.length()];
        int[] alphaFreq = new int[str.length()];// 빈도수 저장
        int compValue = 0;
        int codeOfHighFreq = 0;

        for (int i = 0; i < str.length(); i++) {
            asciiCode[i] = (int) str.charAt(i);
            System.out.print(asciiCode[i] + " ");
        }

        // 오름차순 정렬
        Arrays.sort(asciiCode);

        for (int k = 0; k < str.length(); k++) {
            if (asciiCode[k] != -1) {
                for (int j = k; j < asciiCode.length; j++) {
                    if ((asciiCode[k] == asciiCode[j] || Math.abs(asciiCode[k] - asciiCode[j]) == 32) && k != j) {
                        alphaFreq[k]++;
                        asciiCode[j] = -1;
                    }
                }
                if (compValue == 0) {

                }
            }
        }

        int count = countMax(alphaFreq);
        if (count > 1) {
            System.out.println("?");
        }

        // System.out.println(alphabet);
    }
}
