import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Problem25304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int money = Integer.parseInt(br.readLine());// 영수증 금액
        int itemNum = Integer.parseInt(br.readLine());// 영수증 아이템 갯수

        String[] items;// 입력 아이템들
        int sumMoney = 0;// 비교 할 총 금액
        for (int i = 0; i < itemNum; i++) {

            items = br.readLine().split(" ");

            sumMoney += Integer.parseInt(items[0]) * Integer.parseInt(items[1]);

        }

        if (money == sumMoney) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
