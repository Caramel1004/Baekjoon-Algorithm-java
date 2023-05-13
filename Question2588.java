import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Question2588 {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int integFirst = Integer.parseInt(br.readLine());// 첫 번째 자연수
        int integSecond = Integer.parseInt(br.readLine());// 두 번째 자연수
        String integSecondStrArray = Integer.toString(integSecond);// 두 번째 자연수를 문자열로 저장하는 변수

        int[] integMulti = new int[integSecondStrArray.length()];// 각각의 자리수의 숫자와 곱한 결과를 배열로 저장하는 변수

        // 1. 각각의 자리수의 숫자와 곱한 결과를 배열로 저장
        for (int k = 0; k < integMulti.length; k++) {
            integMulti[k] = integFirst * Character.getNumericValue(integSecondStrArray.charAt(k));
        }

        // 2. 각각의 자리수의 숫자와 곱한 값을 출력
        for (int k = 2; k >= 0; k--) {
            bw.write(Integer.toString(integMulti[k]) + "\n");
        }

        // 3. 세 자릿수의 결과값 출력
        bw.write(Integer.toString(integFirst * integSecond));
        br.close();
        bw.close();
    }
}
