//FlowChart
// 3개의 점 선택 -> 세변의 길이의 제곱 구하기
//->예각 직각 둔각 판별(직각만 판별하면 될듯 : 피타고라스 식 이용) -> 직각이면 카운팅
//main() start -> distancePow() -> isRightTriangle() start -> findMaxIndex() -> isRightTriangle() end ->main() end

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.lang.Math;

public class Problem1711 {

    // 변의 길이의 제곱 구하는 메소드
    static int[] distancePow(int x1, int y1, int x2, int y2, int x3, int y3) {

        int[] x = { x1, x2, x3 };
        int[] y = { y1, y2, y3 };
        int[] sidePow = new int[3];// 변 3개
        int count = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                sidePow[count++] = (int) Math.pow(x[i] - x[j], 2) + (int) Math.pow(y[i] - y[j], 2);
                // System.out.println("변의 길이 제곱" + sidePow[0] + " " + sidePow[1] + " " +
                // sidePow[2]);
            }
        }
        return sidePow;
    }

    // 배열의 최댓값 인덱스 찾는 메소드
    static int findMaxIndex(int[] sidePow) {

        int max = sidePow[0];// 최댓값
        int maxIndex = 0;// 최댓값 인덱스

        for (int i = 0; i < sidePow.length; i++) {
            if (max < sidePow[i]) {
                maxIndex = i;
                max = sidePow[i];
            }
        }
        // System.out.println("maxIndex : " + maxIndex);
        return maxIndex;
    }

    // true : 1, false : 0
    // 직각삼각형 판별 메소드
    static int isRightTriangle(int[] sidePow) {

        int maxIndex = findMaxIndex(sidePow);// 최댓값인 인덱스 검색
        int compValue = 0;

        for (int i = 0; i < sidePow.length; i++) {
            if (i != maxIndex) {
                compValue += sidePow[i];
            }
        }
        // System.out.println("compValue" + compValue);
        // System.out.println("sidePow[maxIndex]" + sidePow[maxIndex]);

        // a^2 = b^2 + c^2 -> 직각
        return sidePow[maxIndex] == compValue ? 1 : 0;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int POINT_SIZE = Integer.parseInt(br.readLine());// 주어진 점 갯수
        final int X = 0;// x좌표 인덱스
        final int Y = 1;// y좌표 인덱스

        int[][] xyCoodi = new int[POINT_SIZE][2];// 모든 xy좌표
        String xyStr;// 문자열 형태로 입력 받을 변수
        String[] xyStrSplit;// 공백 split해서 저장 할 배열변수

        int[] sidePow = new int[3];// 세 변의 제곱을 저장하는 배열 : 피타고라스 식 판단 할 때 쓸 배열변수

        int rightTriangleCase = 0;// 삼각형 만들 수 있는 경우의 수 -> 점 3개 선택하는 경우 : 출력 할 값

        // a^2 < b^2 + c^2 -> 예각
        // a^2 = b^2 + c^2 -> 직각
        // a^2 > b^2 + c^2 -> 둔각

        // 입력 좌표를 정수형 2차원 배열에 저장
        for (int i = 0; i < POINT_SIZE; i++) {
            xyStr = br.readLine();
            xyStrSplit = xyStr.split(" ");
            xyCoodi[i][X] = Integer.parseInt(xyStrSplit[0]);// x좌표
            xyCoodi[i][Y] = Integer.parseInt(xyStrSplit[1]);// y좌표
        }

        // int numOfCase = 1; -> 삼각형 만들 수 있는 경우의 수 저장 할 변수

        // 삼각형 만들 수 있는 경우의 수 -> 점 3개 선택하는 경우
        // 첫 번째 반복문 끝날때마다 side(변) 초기화
        for (int i = 0; i < POINT_SIZE; i++) {
            for (int j = i + 1; j < POINT_SIZE; j++) {
                for (int k = j + 1; k < POINT_SIZE; k++) {
                    // System.out.println("경우의 수" + numOfCase++);

                    // 파라미터 : 각배열의 XY 좌표 총 3개
                    // 총 파라미터 갯수 : 6
                    if ((xyCoodi[i][X] == xyCoodi[j][X] && xyCoodi[i][X] == xyCoodi[k][X]
                            && xyCoodi[j][X] == xyCoodi[k][X])
                            || (xyCoodi[i][Y] == xyCoodi[j][Y] && xyCoodi[i][Y] == xyCoodi[k][Y]
                                    && xyCoodi[j][Y] == xyCoodi[j][Y])) {// 세 점 모두 일직선 상에 있을 경우 삼각형 자체가 만들어지지 않으므로 카운트 0
                        rightTriangleCase += 0;
                    } else {

                        sidePow = distancePow(xyCoodi[i][X], xyCoodi[i][Y], xyCoodi[j][X], xyCoodi[j][Y], xyCoodi[k][X],
                                xyCoodi[k][Y]);
                        // System.out.println(sidePow[0] + " " + sidePow[1] + " " + sidePow[2]);
                        // System.out.println(i + " " + j + " " + k);

                        // 직각삼각형 갯수
                        rightTriangleCase += isRightTriangle(sidePow);
                    }

                    sidePow = new int[3];// 배열 초기화
                }
            }
        }

        // 답 출력
        bw.write(Integer.toString(rightTriangleCase));
        bw.flush();
        bw.close();
    }// main
}