import java.util.Scanner;

public class Question2884 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int inputHour = input.nextInt();// 입력 시
        int inputMin = input.nextInt();// 입력 분

        int subHour = (inputMin - 45) < 0 ? 1 : 0;// 입력 시에서 뺄 시
        int alarmMin = (15 + inputMin) % 60;// 알람 울릴 분

        int alarmHour = (inputHour - subHour) < 0 ? (24 - subHour) : inputHour - subHour;// 알람 울릴 시

        System.out.println(alarmHour + " " + alarmMin);
    }
}
