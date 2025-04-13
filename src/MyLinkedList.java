class MyLinkedList<T> implements MyList<T> {
    private class Node {
        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void add(T item) {
        addLast(item);
    }

    public void set(int index, T item) {
        Node node = getNode(index);
        node.data = item;
    }

    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        Node newNode = new Node(item);
        if (index == 0) {
            newNode.next = head;
            if (head != null) head.prev = newNode;
            head = newNode;
            if (tail == null) tail = head;
        } else if (index == size) {
            addLast(item);
            return;
        } else {
            Node current = getNode(index);
            Node prev = current.prev;
            prev.next = newNode;
            newNode.prev = prev;
            newNode.next = current;
            current.prev = newNode;
        }
        size++;
    }

    public void addFirst(T item) {
        add(0, item);
    }

    public void addLast(T item) {
        Node newNode = new Node(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public T get(int index) {
        return getNode(index).data;
    }

    public T getFirst() {
        if (head == null) throw new RuntimeException("List is empty");
        return head.data;
    }

    public T getLast() {
        if (tail == null) throw new RuntimeException("List is empty");
        return tail.data;
    }

    public void remove(int index) {
        Node node = getNode(index);
        unlink(node);
    }

    public void removeFirst() {
        if (head == null) throw new RuntimeException("List is empty");
        unlink(head);
    }

    public void removeLast() {
        if (tail == null) throw new RuntimeException("List is empty");
        unlink(tail);
    }

    private void unlink(Node node) {
        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;
        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;
        size--;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }

    public void sort() {
        // Простой Bubble Sort
        if (size <= 1) return;
        for (int i = 0; i < size - 1; i++) {
            Node current = head;
            for (int j = 0; j < size - i - 1; j++) {
                Comparable<T> a = (Comparable<T>) current.data;
                T b = current.next.data;
                if (a.compareTo(b) > 0) {
                    T tmp = current.data;
                    current.data = b;
                    current.next.data = tmp;
                }
                current = current.next;
            }
        }
    }

    public int indexOf(Object object) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(object)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        Node current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.data.equals(object)) return index;
            current = current.prev;
            index--;
        }
        return -1;
    }

    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        Node current = head;
        int i = 0;
        while (current != null) {
            result[i++] = current.data;
            current = current.next;
        }
        return result;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<>() {
            private Node current = head;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                T value = current.data;
                current = current.next;
                return value;
            }
        };
    }
}