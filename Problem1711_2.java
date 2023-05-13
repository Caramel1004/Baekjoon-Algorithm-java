//FlowChart
// 3개의 점 선택 -> 세변의 길이의 제곱 구하기
//->예각 직각 둔각 판별(직각만 판별하면 될듯 : 피타고라스 식 이용) -> 직각이면 카운팅
//main() start -> distancePow() -> isRightTriangle() start -> findMaxIndex() -> isRightTriangle() end ->main() end

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.Math;

public class Problem1711_2 {

    // 변의 길이의 제곱 구하는 메소드
    static long[] distancePow(int x1, int y1, int x2, int y2, int x3, int y3) {

        int[] x = { x1, x2, x3 };
        int[] y = { y1, y2, y3 };
        long[] sidePow = new long[3];// 변 3개
        int count = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                sidePow[count++] = (long) Math.pow(x[i] - x[j], 2) + (long) Math.pow(y[i] - y[j], 2);
            }
        }
        // System.out.println("변의 길이 제곱" + sidePow[0] + " " + sidePow[1] + " " +
        // sidePow[2]);
        return sidePow;
    }

    // true : 1, false : 0
    // 직각삼각형 판별 메소드
    static int isRightTriangle(long[] sidePow) {

        long max = sidePow[0];// 최댓값
        int maxIndex = 0;// 최댓값 인덱스

        for (int i = 0; i < sidePow.length; i++) {
            if (max < sidePow[i]) {
                maxIndex = i;
                max = sidePow[i];
            }
        }

        long powSum = 0;// 빗변이 아닌 변의 길이 제곱 합

        for (int i = 0; i < sidePow.length; i++) {
            powSum += sidePow[i];
        }
        // System.out.println("compValue" + compValue);
        // System.out.println("sidePow[maxIndex]" + sidePow[maxIndex]);

        // a^2 = b^2 + c^2 -> 직각
        return sidePow[maxIndex] == powSum - sidePow[maxIndex] ? 1 : 0;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] xyCoodi = new int[Integer.parseInt(br.readLine())][2];// 모든 xy좌표

        long[] sidePow = new long[3];// 세 변의 제곱을 저장하는 배열 : 피타고라스 식 판단 할 때 쓸 배열변수

        int rightTriangleCase = 0;// 삼각형 만들 수 있는 경우의 수 -> 점 3개 선택하는 경우 : 출력 할 값

        StringTokenizer st;

        // 입력 좌표를 정수형 2차원 배열에 저장
        for (int i = 0; i < xyCoodi.length; i++) {
            st = new StringTokenizer(br.readLine());
            xyCoodi[i][0] = Integer.parseInt(st.nextToken());// x좌표
            xyCoodi[i][1] = Integer.parseInt(st.nextToken());// y좌표
        }

        long start = System.currentTimeMillis();
        // 삼각형 만들 수 있는 경우의 수 -> 점 3개 선택하는 경우
        // 첫 번째 반복문 끝날때마다 side(변) 초기화
        for (int i = 0; i < xyCoodi.length; i++) {
            for (int j = i + 1; j < xyCoodi.length; j++) {
                for (int k = j + 1; k < xyCoodi.length; k++) {

                    // 파라미터 : 각배열의 XY 좌표 총 3개
                    // 총 파라미터 갯수 : 6
                    if (!((xyCoodi[i][0] == xyCoodi[j][0] && xyCoodi[i][0] == xyCoodi[k][0]
                            && xyCoodi[j][0] == xyCoodi[k][0])
                            || (xyCoodi[i][1] == xyCoodi[j][1] && xyCoodi[i][1] == xyCoodi[k][1]
                                    && xyCoodi[j][1] == xyCoodi[j][1]))) {// 세 점 모두 일직선 상에 있을 경우가 아닐 경우
                                                                          // 0
                        sidePow = distancePow(xyCoodi[i][0], xyCoodi[i][1], xyCoodi[j][0], xyCoodi[j][1], xyCoodi[k][0],
                                xyCoodi[k][1]);
                        // System.out.println(sidePow[0] + " " + sidePow[1] + " " + sidePow[2]);
                        // System.out.println(i + " " + j + " " + k);

                        // 직각삼각형 갯수
                        rightTriangleCase += isRightTriangle(sidePow);
                    }

                    sidePow = new long[3];// 배열 초기화
                }
            }
        }

        // 답 출력
        System.out.println((System.currentTimeMillis() - start) / 1000.0);
        bw.write(rightTriangleCase + "");
        bw.flush();
        bw.close();

    }// main
}