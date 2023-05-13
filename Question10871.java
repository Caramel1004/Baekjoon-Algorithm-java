import java.util.Scanner;

public class Question10871 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int progressionNum = input.nextInt();// 수열의 항 갯수

        int compNum = input.nextInt();// 비교 할 수

        int[] term = new int[progressionNum];// 수열

        for (int i = 0; i < progressionNum; i++) {
            term[i] = input.nextInt();
        }

        for (int k = 0; k < progressionNum; k++) {
            if (term[k] < compNum) {
                System.out.print(term[k] + " ");
            }
        }
    }
}
