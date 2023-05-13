import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.io.IOException;

public class Problem2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> hs = new HashSet<>();

        int numSize = Integer.parseInt(br.readLine());
        int[] num = new int[numSize];

        for (int i = 0; i < numSize; i++) {
            hs.add(Integer.parseInt(br.readLine()));
        }

        hs.stream().sorted().forEach(System.out::println);// stream 형태로 출력하고 싶을 때

    }
}
