
class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    public void add(T item) {
        heap.add(item);
        bubbleUp(heap.size() - 1);
    }

    public T peek() {
        if (heap.size() == 0) throw new RuntimeException("Heap is empty");
        return heap.get(0);
    }

    public T removeMin() {
        if (heap.size() == 0) throw new RuntimeException("Heap is empty");
        T min = heap.get(0);
        T last = heap.get(heap.size() - 1);
        heap.set(0, last);
        heap.remove(heap.size() - 1);
        bubbleDown(0);
        return min;
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public int size() {
        return heap.size();
    }

    private void bubbleUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) < 0) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void bubbleDown(int index) {
        int lastIndex = heap.size() - 1;
        while (index < heap.size()) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left <= lastIndex && heap.get(left).compareTo(heap.get(smallest)) < 0) {
                smallest = left;
            }

            if (right <= lastIndex && heap.get(right).compareTo(heap.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
