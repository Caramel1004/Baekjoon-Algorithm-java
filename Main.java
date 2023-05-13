import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
// import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        ArrayList<String> arr = new ArrayList<String>();

        arr.add("321");
        arr.add("312");

        arr.sort(Comparator.naturalOrder());
        // sb.append("312\n321");
        System.out.println(arr);

        for (String str : arr) {
            System.out.println(str);
        }
    }
}
