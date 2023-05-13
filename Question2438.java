import java.util.Scanner;

public class Question2438 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int lineNum = input.nextInt();
        String star = "*";

        for (int i = 0; i < lineNum; i++) {

            System.out.println(star);

            star += "*";
        }
    }
}
