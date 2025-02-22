import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11004_K번째수 {
    public static void main(String[] args) throws IOException {

        // 수N개가 있을때 문제 예 데이터 개수 5 , K번째 수 2 -> 5개의 데이터를 오름차순으로 정렬했을때 K번째 수는?
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        // BuffredReader 사용이유 : Scanner보다 입력속도가 빠르다. (특히 반복문에서 많은 입력을 처리할 때 유리)
        // System.in.read()를 직접 쓰는 것보다 편리하게 문자열 단위로 입력받을 수 있다.
        // 2. StringTokenizer 사용 이유
        // split("") 보다 속도가 빠르다
        // 공백기준으로 쉽게 나눌수 있다.
        // StringBuilder sb = new StringBuilder(); 문자열을 저장할 버퍼
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(in.readLine());

    int[] A = new int[N];
    // 데이터 갯수 만큼 배열 생성

    for(int i = 0; i<N; i++){
        A[i] = Integer.parseInt(st.nextToken());
    }
    // 들어오는 숫자대로 해당 인덱스 배열에 저장

    quickSort(A, 0, N-1, K-1);
    // A배열 넘기기, 시작위치 넘기기 , 종료 위치 , 찾는 k번째 값
    System.out.println(A[K-1]);
    // 퀵정렬 실행

    }

    public static void quickSort(int[]A, int S, int E, int K) {
        // 넘어온 배열값 , 시작위치 넘기기 , 종료 위치 , 찾는 k번째 값
        // 퀵소트 (시작, 종료 , K)
        if(S < E) {
            int pivot = partition(A, S, E);
            // 피벗 구하기 (배열, 시작위치 , 종료위치)
            if(pivot == K)
                return;
            // pivot 값과 K가 같다면 종료
            else if (K < pivot)
                quickSort(A, S , pivot - 1, K);
            // 찾는 K번째 값이 pivot 보다 작다면 배열,start값, pivot-1 을 end값으로 넘김
            else
                quickSort(A, pivot + 1, E, K);
            // 찾는 K번째 값이 pivot 보다 크다면 배열,start값, pivot+1 을 end값으로 넘김
        }
    }

    public static int partition(int[] A, int S, int E) {
        // 피벗구하기 함수 , 데이터가 2개인 경우는 바로 비교하여 정렬
        // 넘어온 배열, 시작위치 , 종료위치
        if(S + 1 == E) {
            if(A[S] > A[E])
                swap(A, S ,E);
            return E;
            // Start + 1 이 종료위치와 동일하고 종료위치보다 크다면 swap 이후 end 리턴
        }
        int M = (S + E) / 2;
        // start + end 값 을 나눠 M에 중앙값으로 저장
        // M = 중앙값
        swap(A, S , M);
        // 중앙값을 시작 위치와 swap
        int pivot = A[S];
        // pivot에 A배열의 start값 저장
        int i = S + 1, j = E;
        // i에는 start + 1값 j 에는 end값
        while( i <= j) {
            while(j >= S + 1 && pivot < A[j]) {
                j--;
                // j(end)값이 start+1 그리기 pivot 이 A[j(end)]값보다 작다면 j(end)값을 1 감소
            }
            while(i <= E && pivot > A[i]) {
                i++;
                // start+1 값이 E보다 작거나 같고 pivot 이 A[i(start+1)]값보다 크다면 i(start)값 1증가
            }
            if(i <= j) {
                swap( A, i++, j--);
                // i(start)값이 j(end)값보다 작거나 같다면 swap ( 배열, start증감 , j감소)
            }
        }
        // 피벗 테이블을 나눠진 두그룹의 경계 index에 저장하기
        A[S] = A[j];
        A[j] = pivot;
        // A[start index]에 A[end index]값 저장
        // 이후 A[end index] 값에 pivot 저장
        return j;
        // end값 return
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
