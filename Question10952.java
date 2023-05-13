
// 두 수를 입력받을 수 있다면, 합을 출력하지만, 수가 하나만 입력되는 경우에는 java.util.NoSuchElementException이 발생합니다. 다음은 런타임 에러 메시지입니다.
//더 이상 입력이 없다는 것을 판단할 부분이 필요합니다. Scanner에서는 hasNext, hasNextInt, hasNextLong등과 같은 메소드로 판단할 수 있습니다.
import java.util.Scanner;

public class Question10952 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int numA = 0;
        int numB = 0;

        // do~while문으로 두 수 모두 0이 나오기 전까지는 무한루프
        do {
            numA = input.nextInt();
            numB = input.nextInt();

            if (numA == 0 && numB == 0) {
                break;
            }

            System.out.println(numA + numB);
        } while (input.hasNextInt());

    }
}
