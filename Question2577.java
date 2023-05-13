//자주쓰는 wrapper 클래스 정리
//String -> int Integer.parseInt(String str);
//int -> String Integer.toString(int num);
//char -> int Character.getNumericValue(char cha);

import java.io.*;

public class Question2577 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String calResult = "";// 문자열 형태 곱한 값
        int multi = 1;// int형 곱한 값

        // 입력
        for (int i = 0; i < 3; i++) {
            multi *= Integer.parseInt(br.readLine());
            calResult = Integer.toString(multi);
        }

        // 0 ~ 9 -> 10개
        int[] count = new int[10];

        // 0 ~ 9 숫자 조회
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < calResult.length(); j++) {
                if (Character.getNumericValue(calResult.charAt(j)) == i) {
                    count[i]++;// 같은 수 찾을 때 마다 갯수 카운팅
                }
            }
        }

        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
        }
    }
}
