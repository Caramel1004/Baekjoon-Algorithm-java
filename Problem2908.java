import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Problem2908 {

    static String swap(int idx1, int idx2, String arr) {

        String tmp = "";
        String[] arrSplit = arr.split("");

        tmp = arrSplit[idx1];
        arrSplit[idx1] = arrSplit[idx2];
        arrSplit[idx2] = tmp;

        return arr = String.join("", arrSplit);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] integStr = br.readLine().split(" ");

        int integ1 = Integer.parseInt(swap(0, 2, integStr[0]));
        int integ2 = Integer.parseInt(swap(0, 2, integStr[1]));

        if (integ1 >= integ2) {
            System.out.println(integ1);
        } else {
            System.out.println(integ2);
        }
    }
}
