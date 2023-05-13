import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1920_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 이분 탐색의 조건은 정렬 된 배열 이어야 한다.
        Arrays.sort(num);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int key;

        for (int i = 0; i < m; i++) {
            key = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(num, key)).append("\n");
        }

        System.out.print(sb);
    }

    /**
     * @param arr 정렬 된 배열
     * @param key 찾으려는 값
     * @return key가 존재하면 1 아니면 0
     */
    public static int binarySearch(int[] arr, int key) {

        int pl = 0;// 포인터 왼쪽
        int pr = arr.length - 1;// 포인터 오른쪽
        int pivot = (pl + pr) / 2;// 배열 중간값

        // binarySearch
        while (pl <= pr) {
            if (arr[pivot] == key) {// 피벗과 같은면 1반환
                return 1;
            } else if (arr[pivot] > key) {// 피벗보다 작으면 오른쪽 포인터에 피벗의인덱스-1 저장
                pr = pivot - 1;
                pivot = (pl + pr) / 2;
            } else if (arr[pivot] < key) {// 피벗보다 크면 왼쪽 포인터에 피벗의인덱스+1 저장
                pl = pivot + 1;
                pivot = (pl + pr) / 2;
            }
        }
        return 0;
    }

}