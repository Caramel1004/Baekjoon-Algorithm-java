// ⊙ BigInteger

// int와 BigInteger의 차이점

//        int의 범위는 '-2,147,483,648~2,147,483,647'이지만
//        BigInteger의 범위는 문자열 형태로 이루어져 있어 무한이다.
//  

// BigInteger 계산법

//       문자열 형태로 이루어져 있기에 사칙연산이 안된다.
//       따라서 BigInteger의 값을 계산을 하려면 클래스 내부의 함수를 이용해야 한다.
//  
//       더하기 : add()      빼   기 : subtract()      곱하기 : multiply()      나누기 : divide()

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.io.IOException;

public class Problem1271 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger money = new BigInteger(st.nextToken());
        BigInteger unitNum = new BigInteger(st.nextToken());

        System.out.println(money.divide(unitNum) + "\n" + money.mod(unitNum));
    }
}
