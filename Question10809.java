import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Question10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열에서 각 하나씩 문자형으로 변환 -> 문자형->int형 아스키 코드형태로 변환
        // -> 아스키코드로 알파벳 유무 조사->인덱스 번호를 저장

        String word = br.readLine();
        int chaComp;

        int asciiCode = (int) 'a';// a 아스키코드 == 97
        int alphaRange = 'z' - 'a' + 1;// a : 97 ~ z : 122 -> 26개

        int[] result = new int[alphaRange];

        for (int i = 0; i < alphaRange; i++) {
            for (int j = 0; j < word.length(); j++) {
                chaComp = (int) word.charAt(j);
                if (chaComp == asciiCode) {
                    result[i] = j;
                    break;
                } else {
                    result[i] = -1;
                }
            }
            asciiCode++;

            System.out.print(result[i] + " ");
        }

    }
}
