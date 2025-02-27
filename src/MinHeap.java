import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    /*
    Heap 이란
    완전 이진 트리의 한 종류, 우선순위 큐를 구현할때 주로 사용
    완전 이진트리
    - 마지막 레벨을 제외하고 모든 노드가 꽉 차 있어야함
    - 마지막 레벨의 노드는 왼쪽부터 차례대로 채워짐.
    Java로 최소 힙
    Min Heap 구현
    부모 노드가 자식 노드보다 항상 작음
    add(int value) 새로운 값을 추가.
    poll() : 가장 작은 값을 제거하고 반환
    peek() : 가장 작은 값을 반환하지만 제거하지 않음.

    작은 값이 루트에 있도록 유지 (heapifyUp , heapifyDown)
    add : 새로운 값을 추가, heapify 실행
    poll() : 가장작은 값을 제거, 마지막 요소를 루트로 옮긴 후 heapifyDown 실행
     */
    private List<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public void add(int value) {
        heap.add(value);
        heapifyUp(heap.size() -1);
    }

    public int poll() {
        if(heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty!");
        }
        int min = heap.get(0);
        heap.set(0, heap.get(heap.size() -1));
        heap.remove(heap.size() - 1);
        heapifyDown(0);
        return min;
    }

    public int peek() {
        if(heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty!");
        }
        return heap.get(0);
    }

    private void heapifyUp(int index) {
        while (index > 0 && heap.get(parent(index)) > heap.get(index)) {
        swap(parent(index), index);
        index = parent(index);
        }
    }

    private void heapifyDown(int index) {
        int smallest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

        private void swap(int i , int j) {
            int temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }

        public void printHeap() {
            System.out.println(heap);
        }
    }

