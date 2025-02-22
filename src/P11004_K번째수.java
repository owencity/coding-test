import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11004_K번째수 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
//       BuffredReader 사용이유 : Scanner보다 입력속도가 빠르다. (특히 반복문에서 많은 입력을 처리할 때 유리)
        // System.in.read()를 직접 쓰는 것보다 편리하게 문자열 단위로 입력받을 수 있다.
    // 2. StringTokenizer 사용 이유
        // split("") 보다 속도가 빠르다
        // 공백기준으로 쉽게 나눌수 있다.
//        StringBuilder sb = new StringBuilder(); 문자열을 저장할 버퍼
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(in.readLine());

    int[] A = new int[N];
    for(int i = 0; i<N; i++){
        A[i] = Integer.parseInt(st.nextToken());
    }
    quickSort(A, 0, N-1, K-1);
    System.out.println(A[K-1]);
    }

    public static void quickSort(int[]A, int S, int E, int K) {
        if(S < E) {
            int pivot = partition(A, S, E);
            if(pivot == K)
                return;
            else if (K < pivot)
                quickSort(A, S , pivot - 1, K);
            else
                quickSort(A, pivot + 1, E, K);
        }
    }

    public static int partition(int[] A, int S, int E) {
        if(S + 1 == E) {
            if(A[S] > A[E])
                swap(A, S ,E);
            return E;
        }
        int M = (S + E) / 2;
        swap(A, S , M);
        int pivot = A[S];
        int i = S + 1, j = E;
        while( i <= j) {
            while(j >= S + 1 && pivot < A[j]) {
                j--;
            }
            while(i <= E && pivot > A[i]) {
                i++;
            }
            if(i <= j) {
                swap( A, i++, j--);
            }
        }
        // 피벗 테이블을 나눠진 두그룹의 경계 index에 저장하기
        A[S] = A[j];
        A[j] = pivot;
        return j;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
