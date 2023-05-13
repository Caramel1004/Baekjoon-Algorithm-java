import java.util.Scanner;

public class Question2439 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int lineNum = input.nextInt();
        String star = "*";
        String space = " ";

        for (int i = 1; i <= lineNum; i++) {
            for (int j = lineNum - i; j > 0; j--) {
                System.out.print(space);
            }
            System.out.println(star);

            star += "*";
        }
    }
}
