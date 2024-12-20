import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11659_RangeSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer =
                new StringTokenizer(bufferedReader.readLine());
        // readList() -> 입력한 줄을 통째로 문자열 형태로
        // 5 3 입력시 readLine() "5 3"이라는문자열 전체를가져옴

        /*
            1. BufferedReader 특징
            입력 데이터를 버퍼에 담아 한번에 읽어들여 성능을 향상 시킴(한번에 데이터를 받아 뿌림)
            Scanner 보다 입력처리속도가 훨씬 빠르다.
            적합한 상황 : 입력데이터가 10만줄 이상 데이터 일시 , 입출력 성능이 중요한 문제를 풀 때
            2. StringTokenizer 특징
            문자열을 공백 기준으로 효율적으로 처리 , split() 메서드보다 빠르고, 메모리 사용량이 적다.
            적합한 상황 : 데이터를 공백이나 특정 구분자로 빠르게 분리해야 할 때, 코딩 테스트처럼 간단한 문자열 분리가 필요한 경우

            데이터가 많지 않다면 Scanner 사용하는것이 충분 과도 최적화(오버 엔지니어링)을 피할수 있음
            100줄 이하 데이터, 입력데이터가 복잡하지않고 성능이 큰 문제가 되지 않을 때
         */
        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        // 문자열 분리된값 순서대로 하나씩 반환 첫번째 호출 5
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());
        // 두번째 호출 3
        long[] s = new long[suNo + 1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        // 새로운 객체 생성 기존 StringTokenizer 초기화
        for(int i = 1; i <= suNo; i++ ) {
            s[i] = s[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }
        for(int q = 0; q < quizNo; q++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(s[j] + s[i-1]);
        }
    }
}
