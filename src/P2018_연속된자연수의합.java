import java.util.Scanner;

public class P2018_연속된자연수의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 1; // 숫자 자기자신 포함하여 이미 count 1을 저장
        int startIndex = 1; // 문제에서 0이아닌 1부터 시작하는 자연수이므로 index 값을 1으로 지정
        int endIndex = 1;
        int sum = 1; // start_index = 1, end_index = 1 모두 1이므로 합이 1부터 시작
        while (endIndex != N) { // endIndex != N -> 주어진 N과 같지않으면 true , 같으면 false 즉, 예롤 N이 15이면 15 이전까지만 순회한다는 뜻
            if(sum == N) { // 현재 연속 합이 N과 같은 경우
                count++;
                endIndex++;
                sum = sum + endIndex;
            } else if (sum > N) { // 현재 연속 합이 N보다 큰 경우
                sum = sum - startIndex; // 새로운 조합 탐색을위해 이전값 삭제
                startIndex++; // 이후 start_index 추가하며 새로운 조합 탐색
            } else { // 현재 연속합이 N보다 작은 경우
                endIndex++;
                sum = sum + endIndex;
            }
        }
        System.out.println(count);
    }

    /*
    * 투포인터 알고리즘 (제한시간 2초 N 의 최댓값 10,000,000 으로 매우 크게 잡혀있어 시간 복잡도 고려)
    * 시간복잡도에서 상수는 무시되므로 O(n) 시간복잡도 알고리즘 사용
    * 투포인터 이동 원칙
    * sum > N : sum = sum - start_index; start_index++
    * sum < N : end_index++; sum = sum + end_index;
    * sum == N : end_index++; sum = sum + end_index; count++
    * */
}
