import java.util.Scanner;

public class Question3052 {

    // 같은 요소 찾아 카운팅하는 메소드
    static int indexOf(int[] remain) {

        int compValue = remain[0];
        int count = remain.length;// 서로 다른 나머지 갯수를 저장하는 변수 -> 처음에는 서로 다른것들이 10개있다고 생각하고 요소수로 초기화

        // 선형 검색 인덱스 0부터 시작해서 중복되는 요소를 찾으면 count 1씩 감소
        for (int i = 0; i < remain.length; i++) {
            compValue = remain[i];
            for (int k = i + 1; k < remain.length; k++) {
                if (compValue == remain[k]) {
                    count--;
                }
            }

            System.out.println(count);
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int remainNum = 10;

        int[] remain = new int[remainNum];// 10개 입력 받음

        for (int i = 0; i < remainNum; i++) {
            remain[i] = input.nextInt() % 42;
        }

        int count = indexOf(remain);

        // System.out.println(count);

    }
}
