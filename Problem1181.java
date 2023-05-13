import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.io.IOException;

/**
 * 입력 된 문자열의배열을 문자열의 길이순으로 정렬 ->
 * 중복 값 제거 하고 arrayList로 저장 ->
 * 길이가 같은 것 끼리 그룹 배열을 만들어 사전순으로 정렬 후 list 수정 ->
 * 출력
 */

public class Problem1181 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strList = new String[Integer.parseInt(br.readLine())];

        for (int i = 0; i < strList.length; i++) {
            strList[i] = br.readLine();
        }

        // 문자열 길이 순으로 정렬
        Arrays.sort(strList, Comparator.comparing(String::length));

        ArrayList<String> list = new ArrayList<>();

        // 중복 제거하고 리스트에 저장
        for (String str : strList) {
            if (!list.contains(str)) {
                list.add(str);
            }
        }

        // 같은 문자열길이를 저장 하기 위한 arrayList
        ArrayList<String> tmpList = new ArrayList<>();
        int index = 1;// 배열 번호
        int startIndex = 0;// 같은 문자열의 길이 처음 번호

        // list에서 0번째 요소 저장
        tmpList.add(list.get(index - 1));

        while (true) {

            if (list.size() <= index) {/** 인덱스가 배열의 크기 보다 같거나 크면 tmpList정렬하고 루프 브레이크(조건이 끝나는 구간) */
                tmpList.sort(Comparator.naturalOrder());
                for (int i = 0; i < tmpList.size(); i++) {
                    list.set(startIndex + i, tmpList.get(i));
                }
                // System.out.println("index : " + index);
                // System.out.println("tmpList : " + tmpList);
                // System.out.println("list : " + list);
                tmpList.clear();
                break;

                /** 문자열길이 같은거 tmpList에 저장 그리고 인덱스가 배열사이즈보다 작아야 함 */
            } else if (list.get(index - 1).length() == list.get(index).length() && list.size() > index) {
                tmpList.add(list.get(index));
                index++;
            } else {// 문자열의 같은 길이 끼리 사전순으로 정렬
                tmpList.sort(Comparator.naturalOrder());
                for (int i = 0; i < tmpList.size(); i++) {
                    list.set(startIndex + i, tmpList.get(i));
                }
                startIndex = index++;// 끝난 지점의 번호를 저장 후 인덱스 1증가
                // System.out.println("index : " + index);
                // System.out.println("tmpList : " + tmpList);
                // System.out.println("list : " + list);
                tmpList.clear();
                tmpList.add(list.get(startIndex));
            }

        }

        // stream 형태로 출력
        for (String str : list) {
            System.out.println(str);
        }

    }// main
}