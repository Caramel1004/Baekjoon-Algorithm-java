import java.util.Scanner;

//문제 링크 : https://www.acmicpc.net/problem/2480

// 문제
// 1에서부터 6까지의 눈을 가진 3개의 주사위를 던져서 다음과 같은 규칙에 따라 상금을 받는 게임이 있다. 

// 같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다. 
// 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다. 
// 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.  
// 예를 들어, 3개의 눈 3, 3, 6이 주어지면 상금은 1,000+3×100으로 계산되어 1,300원을 받게 된다. 또 3개의 눈이 2, 2, 2로 주어지면 10,000+2×1,000 으로 계산되어 12,000원을 받게 된다. 3개의 눈이 6, 2, 5로 주어지면 그중 가장 큰 값이 6이므로 6×100으로 계산되어 600원을 상금으로 받게 된다.

// 3개 주사위의 나온 눈이 주어질 때, 상금을 계산하는 프로그램을 작성 하시오.

// 입력
// 첫째 줄에 3개의 눈이 빈칸을 사이에 두고 각각 주어진다. 

// 출력
// 첫째 줄에 게임의 상금을 출력 한다.

// 예제 입력 1 
// 3 3 6
// 예제 출력 1 
// 1300
// 예제 입력 2 
// 2 2 2
// 예제 출력 2 
// 12000
// 예제 입력 3 
// 6 2 5
// 예제 출력 3 
// 600

public class Question2480 {

    // 최댓값 찾는 메소드
    static int maxOf(int[] arr) {

        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (max <= arr[i]) {
                max = arr[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        final int DICE_NUM = 3;// 주사위 갯수
        int[] diceSpot = new int[DICE_NUM];// 주사위 눈을 배열로 저장

        for (int i = 0; i < DICE_NUM; i++) {
            diceSpot[i] = input.nextInt();
        }

        input.close();

        int key = 0;// 검색 키
        int sameCount = 0;// 같은 눈 갯수
        int prizeMoney = 0;// 상금

        // 1.검색 알고리즘
        for (int k = 0; k < DICE_NUM; k++) {

            key = diceSpot[k];
            sameCount = 0;// 같은눈 갯수 초기화

            for (int j = 0; j < DICE_NUM; j++) {
                if (key == diceSpot[j]) {
                    sameCount++;
                }
            }

            // 각각의 케이스 조건문
            if (sameCount == 3) {// 같은눈이 3개면 반복문 종료
                prizeMoney = 10000 + (diceSpot[k] * 1000);
                break;
            } else if (sameCount == 2) {// 같은눈이 2개면 반복문 종료
                prizeMoney = 1000 + diceSpot[k] * 100;
                break;
            } else if (sameCount == 1 && k == (DICE_NUM - 1)) {// 같은눈이 반복문 끝까지 없으면 주사위눈 최댓값찾아서 계산
                prizeMoney = maxOf(diceSpot) * 100;
            }
        }

        System.out.println(prizeMoney);

    }
}
