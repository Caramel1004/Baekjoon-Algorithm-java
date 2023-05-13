import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Problem1769 {
    public static void main(String[] args) throws IOException, NumberFormatException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strSplit = str.split("");

        int num = 0;
        int count = 0;

        while (strSplit.length > 1) {

            count++;

            for (int i = 0; i < strSplit.length; i++) {
                num += Integer.parseInt(strSplit[i]);
            }

            str = Integer.toString(num);
            strSplit = Integer.toString(num).split("");
            num = 0;
        }

        if (Integer.parseInt(str) % 3 == 0) {
            System.out.println(count + "\nYES");
        } else {
            System.out.println(count + "\nNO");
        }

    }
}