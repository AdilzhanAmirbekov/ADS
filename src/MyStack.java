public class MyStack<T> {
    private MyArrayList<T> list = new MyArrayList<>();

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        if (list.size() == 0) throw new RuntimeException("Empty stack");
        T value = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return value;
    }

    public T peek() {
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}