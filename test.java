import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // String myString = "aBcDeFg";
        // String[] arr = myString.split("");
        // int charArr = (int) arr[0].charAt(0);
        // System.out.println("arr: "+ arr[0]);
        // System.out.println("myString: "+ myString);
        // System.out.println("charArr: "+ charArr);
        // System.out.println((char)90);
        // System.out.println(Integer.parseInt("002"));

        int[] ingredient = { 2, 1, 1, 2, 3, 1, 2, 3, 1 };
        int[] recipe = { 1, 2, 3, 1 };
        int count = 0;
        ArrayList<Integer> ingredList = new ArrayList<Integer>();
        // ArrayList<Integer> recipe = new ArrayList<Integer>();

        for (int element : ingredient) {
            ingredList.add(element);
        }
        // for (int element : arr) {
        //     recipe.add(element);
        // }

        // ArrayList<Integer> recipe = new ArrayList<Integer>(Arrays.asList(1, 2, 3,
        // 1));// 1 2 3 1

        // System.out.println(Arrays.equals(recipe, ingredList.toArray()));
        for (int index = 0; index < ingredList.size() - 2; index++) {
            ingredList.contains(1);
            boolean isArrayEqual = false;
            int tmpElem = ingredList.get(index);
            System.out.println("ingredList: " + ingredList + ", index: " + index);

            if(tmpElem == 1) {
                int[] subList = ingredList.subList(index, index + 4).stream().mapToInt(e -> e).toArray();
                isArrayEqual = Arrays.equals(recipe, subList);
                System.out.println(isArrayEqual);
            }

            if(isArrayEqual) {
                count++;
                for(int k = index; k < index + 4; k++){
                    ingredList.remove(index);
                    System.out.println(ingredList);
                }
                index = 0;
            }
        }
        System.out.println("count: " + count);
    }
}
