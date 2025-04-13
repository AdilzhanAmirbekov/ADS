public class MyQueue<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void enqueue(T item) {
        list.add(item);
    }

    public T dequeue() {
        if (list.size() == 0) throw new RuntimeException("Empty queue");
        T item = list.get(0);
        list.remove(0);
        return item;
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}