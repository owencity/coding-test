import java.util.Scanner;

public class P2750_수정렬하기 {
    // 버블정렬 1000 이하 -> 1000000 이라서 가능 제한조건 잘볼것
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        // 버블정렬 구현
        for(int i = 0; i < N-1; i++) { // 한자리씩 빼서 루프
            for(int j=0; j <N-1-i; j++) { // 인접한 두 자리 숫자비교
                if(A[j] > A[j+1]) {
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }
        for(int i = 0; i < N; i++) {
            System.out.print(A[i] + " ");
        }
    }
}
