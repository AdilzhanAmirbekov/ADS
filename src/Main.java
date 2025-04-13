public class Main {
    public static void main(String[] args) {
        // --- Тест Stack ---
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack pop: " + stack.pop());    // 30
        System.out.println("Stack peek: " + stack.peek());  // 20
        System.out.println("Stack empty? " + stack.isEmpty()); // false

        // --- Тест Queue ---
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("apple");
        queue.enqueue("banana");
        queue.enqueue("cherry");
        System.out.println("Queue dequeue: " + queue.dequeue()); // apple
        System.out.println("Queue empty? " + queue.isEmpty());   // false

        // --- Тест MinHeap ---
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.add(40);
        heap.add(10);
        heap.add(25);
        heap.add(5);
        System.out.println("MinHeap peek: " + heap.peek());        // 5
        System.out.println("MinHeap removeMin: " + heap.removeMin()); // 5
        System.out.println("MinHeap new peek: " + heap.peek());    // 10
        System.out.println("MinHeap size: " + heap.size());        // 3
        System.out.println("MinHeap isEmpty: " + heap.isEmpty());  // false
    }
}
