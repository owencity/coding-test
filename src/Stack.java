import java.util.Scanner;

public class Stack {
    public static void main(String[] args){
        // stack 은 처음에 들어간것이 나중에나와야함 FILO
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt(); // data 갯수
        MyStack stack = new MyStack(size);

        for(int i = 0; i < size; i++) {
            stack.push(sc.nextInt());
        }

        System.out.println("스택에서 데이터 꺼내기");
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}

class MyStack{
    private int[] stack;
    private int top;

    // 생성자 (스택 크기 설정)
    public MyStack(int size) {
        stack = new int[size];
        top = -1; // 처음에는 스택이 비어있음.
    }

    // push (데이터 추가)
    public void push(int value) {
        if(top == stack.length - 1) {
           System.out.println("스택이 가득 참");
        } else {
            stack[++top] = value;
        }
    }

    // pop (데이터 제거 및 반환)
    public int pop() {
        if (top == -1) {
            System.out.println("스택이 비어 있음");
            return -1;
        } else {
            return stack[top--];
        }
    }

    public int peek() {
        if (top == -1) {
            System.out.println("스택이 비어 있음:");
            return -1;
        }
        return stack[top];
    }

    // isEmpty (스택이 비었는지 확인)
    public boolean isEmpty() {
        return top == -1;
    }
}
