import java.util.Scanner;

public class P1546_average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 과목 수 받기

        long sum = 0;
        long max = 0;
        // 초기화

        for(int i = 0; i < n; i++) {
            int temp = sc.nextInt(); // 점수 받기
            if(temp > max) max = temp; // 들어온 값들 중 최댓값 구하기
            sum = sum + temp; // 점수 합산
        }
        System.out.println(sum*100.0/max/n); // 주어진 마무리 식
    }
}
