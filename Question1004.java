//RunTime 에러
// 문제 링크 : https://www.acmicpc.net/problem/1004

import java.util.Scanner;

public class Question1004 {

    static int coordinateDistin(int req, int circle_req) {

        Scanner in = new Scanner(System.in);

        int[] start_end_xy = new int[req];
        int count = 0;

        // 1.출발점,도착점 좌표 입력
        for (int k = 0; k < req; k++) {
            start_end_xy[k] = in.nextInt();
        }

        int circle_num = in.nextInt();// 원의 갯수(행성계 수)

        int[][] circle_value = new int[circle_num][circle_req];// 원의 방정식 좌표 값, 반지름

        // 2. 원의 방정식 좌표 값, 반지름 입력
        for (int k = 0; k < circle_num; k++) {
            for (int i = 0; i < circle_req; i++) {
                circle_value[k][i] = in.nextInt();
            }
        }

        double start_distance_pow = 0;
        double start_distance = 0;// 출발점과 원의 중심사이 거리
        double end_distance_pow = 0;
        double end_distance = 0;// 도착점과 원의 중심사이 거리
        double radius = 0;// 원의 반지름

        for (int k = 0; k < circle_num; k++) {
            start_distance_pow = (double) Math.pow(start_end_xy[0] - circle_value[k][0], 2)
                    + (double) Math.pow(start_end_xy[1] - circle_value[k][1], 2);// 두점 XY1, XY2의 거리 제곱

            end_distance_pow = (double) Math.pow(start_end_xy[2] - circle_value[k][0], 2)
                    + (double) Math.pow(start_end_xy[3] - circle_value[k][1], 2);// 두점 XY1, XY2의 거리 제곱

            start_distance = Math.sqrt(start_distance_pow);// 두점 XY1, XY2의 거리
            end_distance = Math.sqrt(end_distance_pow);// 두점 XY1, XY2의 거리
            radius = (double) circle_value[k][2];

            if (start_distance < radius && start_distance >= 0) {
                count++;
            }

            if (end_distance < radius && end_distance >= 0) {
                count++;
            }
        }

        in.close();

        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final int TEST_CASE_SIZE = input.nextInt();// 테스트 케이스 갯수
        final int REQ_VAL_NUM = 4;// 출발점 도착점 좌표 x1,y1,x2,y2
        final int PLANET_REQ_VAL_NUM = 3;// 행성계 데이터 갯수

        int[] result = new int[TEST_CASE_SIZE];// 데이터 케이스 하나당 결과 값 배열로 저장

        // 1. 행성계 진입/이탈 횟수 메소드 실행
        for (int k = 0; k < TEST_CASE_SIZE; k++) {
            result[k] = coordinateDistin(REQ_VAL_NUM, PLANET_REQ_VAL_NUM);// 진입/이탈 횟수 구하는 메소드
        }

        // 2. 진입/이탈 횟수 출력
        for (int k = 0; k < TEST_CASE_SIZE; k++) {
            System.out.println(result[k]);
        }
        input.close();

    }
}
