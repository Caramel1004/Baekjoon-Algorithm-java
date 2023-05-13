import java.io.*;

public class Question4344 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 점수 반 평균 구하기 -> 평균 못넘는 학생 수 조사 -> 비율로 출력

        int testCaseSize = Integer.parseInt(br.readLine());// 테스트 케이스 크기

        int stuNum = 0;// 총 학생 수
        int sumScore = 0;// 반 점수 합산
        double avgScore = 0;// 점수 반 평균

        double[] stuPer = new double[testCaseSize];// 평균 못넘는 학생 비율
        int tmpCount = 0;// 평균 넘은 총 학생 수 임시 저장

        for (int i = 0; i < testCaseSize; i++) {
            tmpCount = 0;
            sumScore = 0;
            String[] testCase = br.readLine().split(" ");// 테스트 케이스 문자열 배열로 저장
            stuNum = Integer.parseInt(testCase[0]);
            for (int j = 1; j <= stuNum; j++) {
                sumScore += Integer.parseInt(testCase[j]);// 점수 입력들의 합 저장
            }
            avgScore = (double) sumScore / stuNum;// 실수/정수 = 실수

            // 평균 점수보다 크면 평균 넘는 학생 수 1 증가
            for (int j = 1; j <= stuNum; j++) {
                if (avgScore < Integer.parseInt(testCase[j])) {
                    tmpCount++;
                }
            }

            stuPer[i] = ((double) tmpCount / stuNum) * 100;
        }

        for (int i = 0; i < testCaseSize; i++) {
            System.out.printf("%.3f%c %n", stuPer[i], '%');
        }
    }
}
