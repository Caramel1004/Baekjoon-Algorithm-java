//FlowChart
// 3개의 점 선택 -> 두 기울기 곱이 -1 이면 직각 삼각형 또는 기울기 0이면서 기울기가 무한인 경우 직각 삼각형
// -> 직각이면 카운팅
//main() start -> (loop) isRightTriangle() -> main() end

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Problem1711_3 {

    // true : 1, false : 0
    // 직각삼각형 판별 메소드
    static int isRightTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {

        double gradient1 = (double) (y1 - y2) / (x1 - x2);// 기울기
        double gradient2 = (double) (y1 - y3) / (x1 - x3);// 기울기
        double gradient3 = (double) (y2 - y3) / (x2 - x3);// 기울기

        if (gradient1 * gradient2 == -1.0 || Double.isInfinite(gradient1) && gradient2 == 0.0
                || Double.isInfinite(gradient2) && gradient1 == 0.0) {
            return 1;
        } else if (gradient1 * gradient3 == -1.0 || Double.isInfinite(gradient1) && gradient3 == 0.0
                || Double.isInfinite(gradient3) && gradient1 == 0.0) {
            return 1;
        } else if (gradient2 * gradient3 == -1.0 || Double.isInfinite(gradient2) && gradient3 == 0.0
                || Double.isInfinite(gradient3) && gradient2 == 0.0) {
            return 1;
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] xyCoodi = new int[Integer.parseInt(br.readLine())][2];// 모든 xy좌표

        int rightTriangleCase = 0;// 삼각형 만들 수 있는 경우의 수 -> 점 3개 선택하는 경우 : 출력 할 값

        StringTokenizer st;

        // 입력 좌표를 정수형 2차원 배열에 저장
        for (int i = 0; i < xyCoodi.length; i++) {
            st = new StringTokenizer(br.readLine());
            xyCoodi[i][0] = Integer.parseInt(st.nextToken());// x좌표
            xyCoodi[i][1] = Integer.parseInt(st.nextToken());// y좌표
        }

        int count = 0;
        // 삼각형 만들 수 있는 경우의 수 -> 서로 다른 점 3개 선택하는 경우
        for (int i = 0; i < xyCoodi.length; i++) {
            for (int j = i + 1; j < xyCoodi.length; j++) {
                for (int k = j + 1; k < xyCoodi.length; k++) {

                    // 파라미터 : 각배열의 XY 좌표 총 3개
                    // 총 파라미터 갯수 : 6
                    if (!((xyCoodi[i][0] == xyCoodi[j][0] && xyCoodi[i][0] == xyCoodi[k][0]
                            && xyCoodi[j][0] == xyCoodi[k][0])
                            || (xyCoodi[i][1] == xyCoodi[j][1] && xyCoodi[i][1] == xyCoodi[k][1]
                                    && xyCoodi[j][1] == xyCoodi[j][1]))) {// 세 점 모두 일직선 상에 있을 경우가 아닐 경우
                        rightTriangleCase += isRightTriangle(xyCoodi[i][0], xyCoodi[i][1], xyCoodi[j][0], xyCoodi[j][1],
                                xyCoodi[k][0],
                                xyCoodi[k][1]);
                        count++;
                    }

                }
            }
        }

        // 답 출력
        System.out.println("함수 호출 횟수 : " + count);
        bw.write(rightTriangleCase + "");
        bw.flush();
        bw.close();

    }// main
}
