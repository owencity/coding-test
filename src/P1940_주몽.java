import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1940_주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine()); // 재료의 개수
        int m = Integer.parseInt(bf.readLine()); // 갑옷이 되는 번호
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        int count = 0;
        int i = 0;
        int j = n-1; // 배열의 index는 0부터 시작 , 마지막 index는 배열의 길이의 -1 (length와 index는 다르다.)
        while(i < j) {
            if (a[i] + a[j] < m) { // 두합이 m보다 작으면 시작 index + 1
                i++;
            } else if (a[i] + a[j] > m) { // 두합이 크면 마지막 index - 1
                j--;
            } else { // 같으면 값을 찾았으므로 count +1
                count++;
                i++;
                j--;
            }
            System.out.println(count);
            bf.close();
        }
    }
}
