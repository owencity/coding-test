public class N의배수 {

    /*
     프로그래머스 기초문제 1
     */
    public int solution(int num, int n) {
        /*
         num 이 n의 배수이면 1 리턴 , n의 배수가 아니라면 0 return
        */
        if(num % n == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
