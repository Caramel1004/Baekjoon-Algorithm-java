import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문제
// 캠프에 오게 된 송유진은 캠프가 너무 지루해서 오늘로부터 캠프가 끝날 때 까지 며칠이나 남았는지 알아보고 싶었다. 그런데 캠프는 비상식적으로 길지도 몰라서 (윤년을 포함할지도 모른다) 손으로 하나하나 세기에는 힘들어 보였다.

// 더욱 정확한 계산을 위해, 유진이는 윤년이 정해지는 기준을 찾아보았고, 그것은 다음과 같았다.

// 서력기원 연수가 4로 나누어떨어지는 해는 우선 윤년으로 한다. (2004년, 2008년, …)
// 100으로 나누어떨어지는 해는 평년으로 한다. (2100년, 2200년, …)
// 400으로 나누어떨어지는 해는 다시 윤년으로 한다. (1600년, 2000년, …)
// 그런데 캠프가 너무 길 경우, 사춘기인 유진이는 캠프에 무단으로 빠질지도 모른다.

// 입력
// 첫째 줄에 오늘의 날짜가 주어지고, 두 번째 줄에 D-Day인 날의 날짜가 주어진다. 날짜는 연도, 월, 일순으로 주어지며, 공백으로 구분한다. 입력 범위는 1년 1월 1일부터 9999년 12월 31일 까지 이다. 오늘의 날짜는 항상 D-Day보다 앞에 있다.

// 출력
// 오늘부터 D-Day까지 x일이 남았다면, "D-"를 출력하고 그 뒤에 공백 없이 x를 출력한다. 만약 캠프가 천년 이상 지속된다면 (오늘이 y년 m월 d일이고, D-Day가 y+1000년 m월 d일과 같거나 늦다면) 대신 "gg"를 출력한다. 오늘이 2월 29일인 경우는 주어지지 않는다.
public class Problem1308 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] normalYear = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[] leapYear = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String[] today = br.readLine().split(" ");
        String[] dDay = br.readLine().split(" ");

        int todayYear = Integer.parseInt(today[0]);
        int todayMonth = Integer.parseInt(today[1]);
        int todayDay = Integer.parseInt(today[2]);

        int dDayYear = Integer.parseInt(dDay[0]);
        int dDayMonth = Integer.parseInt(dDay[1]);
        int dDayDay = Integer.parseInt(dDay[2]);

        int remainDay = 0;// 남은 일 수

        // (오늘이 y년 m월 d일이고, D-Day가 y+1000년 m월 d일과 같거나 늦다면) "gg"를 출력한다.
        if ((dDayYear == todayYear + 1000 && dDayMonth >= todayMonth && dDayDay >= todayDay)
                || dDayYear > todayYear + 1000) {
            System.out.print("gg");

        } else {

            // 오늘 날짜 년도와 디데이 날짜 년도 사이 년도의 일 수
            if (dDayYear - todayYear > 1) {
                for (int year = todayYear + 1; year < dDayYear; year++) {
                    if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                        remainDay += 366;// 윤년
                    } else {
                        remainDay += 365;// 평년
                    }
                }
            }

            // 같은 년도 일 때
            if (todayYear == dDayYear) {
                // 같은 년도 and 같은 달(월)
                if (todayMonth == dDayMonth) {
                    remainDay += dDayDay - todayDay;
                } else {// 같은 년도 and 같은 달 아닌 경우
                    for (int month = todayMonth; month <= dDayMonth; month++) {// 윤년 일 때
                        if ((todayYear % 4 == 0 && todayYear % 100 != 0) || todayYear % 400 == 0) {
                            if (month == todayMonth) {// 오늘 날짜 달인 경우
                                remainDay += leapYear[month - 1] - todayDay + 1;
                            } else if (month != dDayMonth) {// 오늘 날짜 달이 아닌 경우
                                remainDay += leapYear[month - 1];
                            } else if (month == dDayMonth) {// 디데이 날짜 달인 경우
                                remainDay += dDayDay - 1;
                            }
                        } else {// 평년 일 때
                            if (month == todayMonth) {
                                remainDay += normalYear[month - 1] - todayDay + 1;
                            } else if (month != dDayMonth) {
                                remainDay += normalYear[month - 1];
                            } else if (month == dDayMonth) {
                                remainDay += dDayDay - 1;
                            }
                        }
                    }
                }

            } else {// 같은 년도 아닐 떄

                // 오늘 날짜 부터 이번년도 12월 까지의 일 수 모두 더하는 알고리즘
                for (int month = todayMonth; month <= 12; month++) {
                    if ((todayYear % 4 == 0 && todayYear % 100 != 0) || todayYear % 400 == 0) {
                        if (month == todayMonth) {
                            remainDay += leapYear[month - 1] - todayDay + 1;
                        } else {
                            remainDay += leapYear[month - 1];
                        }
                    } else {
                        if (month == todayMonth) {
                            remainDay += normalYear[month - 1] - todayDay + 1;
                        } else {
                            remainDay += normalYear[month - 1];
                        }
                    }
                }

                // 1월부터 디데이 날짜 달 까지의 일 수 모두 더하는 알고리즘
                for (int month = 1; month <= dDayMonth; month++) {
                    if ((dDayYear % 4 == 0 && dDayYear % 100 != 0) || dDayYear % 400 == 0) {
                        if (month == dDayMonth) {// 디데이 날짜의 달인 경우
                            remainDay += dDayDay - 1;
                        } else {
                            remainDay += leapYear[month - 1];
                        }
                    } else {// 평년 일 때
                        if (month == dDayMonth) {
                            remainDay += dDayDay - 1;
                        } else {
                            remainDay += normalYear[month - 1];
                        }
                    }
                }
            }

            System.out.print("D-" + remainDay);
        }

    }
}
