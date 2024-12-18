import java.util.Scanner;

public class P11720SumNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        // 입력받은 문자열을 char 배열로 변환하여 각 문자(숫자)를 개별적으로 처리할 수 있도록 함.
        int sum = 0;
        // sum 초기화
        for (int i = 0; i < cNum.length; i++) {
            sum += cNum[i] - '0';
            // char 배열의 각 문자를 숫자로 변환(아스키 코드 '0' 빼기)하여 sum에 더함.
            // '0'의 아스키 코드 값(48)을 빼면 실제 숫자값으로 변환됩니다.
            // += 복합대입연산자는 = 와 우선순위 동일(즉, 가장낮아 가장 나중에 실행)
        }
        System.out.println(sum);
    }
}
