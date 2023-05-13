import java.io.*;

public class Question8958 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        String oxStr = "";
        int stackScore = 0;
        int[] totalScore = new int[testCase];

        for (int i = 0; i < testCase; i++) {
            oxStr = br.readLine();
            for (int k = 0; k < oxStr.length(); k++) {
                if (oxStr.charAt(k) == 'O') {// 연속으로 o면 스택 1씩증가
                    stackScore++;
                    totalScore[i] += stackScore;
                } else {// x면 스택 0으로 저장
                    stackScore = 0;
                }
            }
            stackScore = 0;
        }

        for (int i = 0; i < testCase; i++) {
            System.out.println(totalScore[i]);
        }
    }
}
