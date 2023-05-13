//HashSet 내부에 원하는 값이 있는지 확인하고 싶다면 contains(value) 메소드

//생성자가 있는 수들을 hashset클래스로 저장 -> 검색 결과에서 찾는 수가 없는 수를 검색(contains(value) 메소드) 
//-> 검색결과가 false면 셀프넘버이므로 출력

import java.util.HashSet;

public class Problem4673 {

    public static void main(String[] args) {

        HashSet<Integer> hs = new HashSet<>();

        int[] integ = new int[10000];
        String[] integStr;

        // 생성자가 있는 수들
        for (int i = 1; i <= 10000; i++) {
            integStr = Integer.toString(i).split("");// int -> 문자열의 문자열배열
            if (i < 10 && i > 0) {// 1~9
                integ[i - 1] = i + i;
                hs.add(integ[i - 1]);
            } else if (i >= 10) {// 10~....
                integ[i - 1] = i;
                for (int j = 0; j < integStr.length; j++) {
                    integ[i - 1] += Integer.parseInt(integStr[j]);
                }
                hs.add(integ[i - 1]);
            }
        }

        // 내부에 해당 수가 없으면 그 수가 셀프 넘버 -> 출력
        for (int i = 1; i <= 10000; i++) {
            if (!hs.contains(i)) {
                System.out.println(i);
            }
        }

        // hs.forEach(System.out::println); -> stream 형태로 보고 싶을 때
        // System.out.println(hs); 생성자가 있는 수들 보고 싶을 때

    }
}
