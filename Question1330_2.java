import java.util.Scanner;

public class Question1330_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int integ1 = input.nextInt();
        int integ2 = input.nextInt();

        input.close();

        String result = "";

        if (integ1 > integ2) {
            result = ">";
        } else if (integ1 < integ2) {
            result = "<";
        } else if (integ1 == integ2) {
            result = "==";
        }

        System.out.print(result);
    }
}
