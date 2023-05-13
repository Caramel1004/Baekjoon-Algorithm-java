
/**
 * ex) aaabbbcca
 * 문자가 중복되는 경우 ptr을 1씩 증가 -> 인접한 문자가 다른 문자이면 조건식 실행 
 * -> ptr을 기준으로 ptr-1과 같은 문자가 있는지 조사 만약 중복 문자 발견하면 while문 break,중복 없으면 계속 진행
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Problem1316 {

    // 중복 되는지만 체크 하면 됨
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int groupCount = 0;// 그룹 단어 카운팅
        int ptr = 1;// 인덱스 위치(포인터)
        int toggle = 0;// 인접한 문자 제외 중복이 있는지 확인, 없으면 0 있으면 1
        String[] word;// 입력 단어

        for (int i = 0; i < size; i++) {

            word = br.readLine().split("");

            while (word.length > ptr) {

                // System.out.println("ptr : " + ptr);

                if (!(word[ptr - 1].equals(word[ptr]))) {
                    for (int k = ptr + 1; k < word.length; k++) {
                        if (word[ptr - 1].equals(word[k])) {
                            // System.out.println("중복문자 발견");
                            toggle = 1;// 연속되지 않은곳에서 중복 문자 발견
                            break;
                        } // for문 브레이크
                    }
                    if (toggle == 1)
                        break;// while문 브레이크 --> 연속되지 않은곳에서 중복 문자 발견했으므로 더 이상 조사 x
                } // 첫번째 if문

                ptr++;
            } // while문

            if (toggle == 0) {
                groupCount++; // 토글로 인접한 문자 제외 중복 체크 0 이면 카운팅
            } else {
                toggle = 0;// 중복 체크 해제
            }

            ptr = 1;
        }

        System.out.println(groupCount);
    }// main
}
