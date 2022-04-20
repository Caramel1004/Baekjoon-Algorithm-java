import java.util.Scanner;

// 조규현과 백승환은 터렛에 근무하는 직원이다. 하지만 워낙 존재감이 없어서 인구수는 차지하지 않는다. 다음은 조규현과 백승환의 사진이다.

// 이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다. 조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.

// 조규현의 좌표 (x1, y1)와 백승환의 좌표 (x2, y2)가 주어지고, 조규현이 계산한 류재명과의 거리 r1과 백승환이 계산한 류재명과의 거리 r2가 주어졌을 때, 류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 다음과 같이 이루어져 있다.

// 한 줄에 x1, y1, r1, x2, y2, r2가 주어진다. x1, y1, x2, y2는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수이고, r1, r2는 10,000보다 작거나 같은 자연수이다.

// 출력
// 각 테스트 케이스마다 류재명이 있을 수 있는 위치의 수를 출력한다. 만약 류재명이 있을 수 있는 위치의 개수가 무한대일 경우에는 -1을 출력한다.

// 예제 입력 1 
// 3
// 0 0 13 40 0 37
// 0 0 3 0 7 4
// 1 1 1 1 1 5
// 예제 출력 1 
// 2
// 1
// 0

public class Question1002 {

    static int coordinateDistin(double[] testCase) {

        // x1 y1 r1 조규현
        final double X1 = testCase[0];
        final double Y1 = testCase[1];
        final double R1 = testCase[2];

        // x2 y2 r2 백승환
        final double X2 = testCase[3];
        final double Y2 = testCase[4];
        final double R2 = testCase[5];

        int result = -2;

        double distance_pow = (double) Math.pow(X1 - X2, 2) + (double) Math.pow(Y1 - Y2, 2);// 두점 XY1, XY2의 거리 제곱
        double distance = Math.sqrt(distance_pow);// 두점 XY1, XY2의 거리

        double sub_abs_r = (double) Math.abs(R1 - R2);// |R1 - R2| 두거리의 차를 이용하여 원의 위치관계를 알기 위한 변수
        double sum_r = R1 + R2;

        if (distance > sum_r || distance == 0 && R1 != R2 || distance < sub_abs_r) {// d > R1+R2 or d < |R1-R2| or d = 0
                                                                                    // R1 != R2 -> 두원이 절대 만나지 않는 경우

            result = 0;

        } else if (distance == sum_r || distance == sub_abs_r) {// d = R1 + R2 or d = |R1 - R2| 외접 ,내접 -> 한점으로 만날 경우

            // R1 = R2, R1 > 0 R2 > 0 -> 외접 OR
            // 내접 한다는 조건을 만족시키면서
            // 위치가 무한일 경우는 동일한 원이라는 의미 -1
            // 주의 할 점은 3명이 모두 같은 지점에 있을 경우이다 이 경우에는 한곳에서 만나므로 위치
            // 수가
            // 1이다.
            result = (distance == 0 && sub_abs_r == 0 && R1 > 0 && R2 > 0) ? -1 : 1;

        } else if (distance > sub_abs_r && distance < sum_r) {// |R1 - R2| < d < R1 + R2 ->두점으로 만날 경우

            result = 2;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        final int TEST_CASE_NUM = input.nextInt();// 테스트 케이스 갯수
        final int REQUIRE_VALUE_NUM = 6;// 테스트 케이스 안에 필요한 값 갯수

        final double[][] TEST_CASE = new double[TEST_CASE_NUM][REQUIRE_VALUE_NUM];// 테스트 케이스 데이터
        final int TEST_CASE_SIZE = TEST_CASE.length;// 데이터 크기

        int[] result = new int[TEST_CASE_NUM];// 데이터 케이스 하나당 결과 값 배열로 저장

        // 1. 테스트 케이스 데이터 입력
        for (int k = 0; k < TEST_CASE_SIZE; k++) {
            for (int i = 0; i < REQUIRE_VALUE_NUM; i++) {
                TEST_CASE[k][i] = input.nextDouble();
            }
        }

        input.close();

        // 2. 테스트 케이스를 위치 수 판별 메소드로 갯수 조사
        for (int k = 0; k < TEST_CASE_NUM; k++) {
            result[k] = coordinateDistin(TEST_CASE[k]);// 위치 수 판별 메소드
        }

        // 3. 각 케이스 마다 위치수가 배열로 저장 된 것들을 출력
        for (int k = 0; k < TEST_CASE_NUM; k++) {
            System.out.println(result[k]);
        }
    }
}
