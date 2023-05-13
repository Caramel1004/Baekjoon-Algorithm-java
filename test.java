import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        // 1. 입력 구간
        Scanner input = new Scanner(System.in);

        double gradient1 = -3.0;// 기울기
        double gradient2 = 3.0 / 0.0;

        double result = gradient1 * gradient2;

        System.out.println(result);
    }
}
