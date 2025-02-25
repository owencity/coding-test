public class Programmers_같은숫자는싫어 {
    public static void main(String[] args) {
// main 메서드 안에 solution 메서드를 선언할수 없다.
        // 자바의 기본 메서드 선언 규칙
        // 자바에서 메서드는 클래스의 멤버로 존재해야하고, 다른 메서드 안에 포함될 수 없다.
        // 즉 main 메서드가 실행을 담당하는 역할을 한다고 해도, 그안에서는 다른 메서드를 정의하는 것은 문법적으로 허용되지 않는다.

        // 자바는 클래스 기반 객체지향 언어, 모든 메서드는 클래스의 멤버로 정의되어야한다.
        // 메서드를 메서드안에 선언할수 없다.
        // 실행 메서드(main)는 별도 기능을 담당하는 메서드를 호출해야한다.
        // 자바 컴파일러가 문법적으로 막는다
        // 람다표현식 또는 익명 클래스를 사용하면 메서드안에서도 특정기능을 정의 가능
        // 문법적으로 안되는것, 기술적으로 완전히 불가능 하지않음


        //        public int[] solution() {
//            int count = 1; // 결과 배열 크기 계산용
//
//        }

        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        int[] result = solution(arr);

        // 결과 출력
        for (int num : result) {
            System.out.println(num + " ");
        }
    }

    public static int[] solution(int[] arr) {
        int count = 1; // 결과 배열 크기 계산용
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[i-1]) {
                count++;
            }
        }

        int [] answer = new int[count];
        answer[0] = arr[0];
        int index = 1;

        for(int i = 1; i<arr.length; i++) {
            if(arr[i] != arr[i - 1]) {
                answer[index++] = arr[i];
            }
        }

        return answer;
    }
}
