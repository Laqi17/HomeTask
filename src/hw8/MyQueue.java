package hw8;

public class MyQueue<E> {
    private int size;
    private Node<E> first;

    private Node<E> last;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return String.valueOf(item);
        }
    }

    public void add(E value) {
        Node<E> l = this.last;
        Node<E> newNode = new MyQueue.Node<>(value, null, l);
        this.last = newNode;
        if (l == null) {
            this.first = newNode;
        } else {
            l.next = newNode;
        }
        ++this.size;
    }

    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> prevForRemove = null;
        Node<E> nextForRemove = null;
        Node<E> forSearching = first;

        if (index == 0) {
            this.first = forSearching.next;
        } else if (index == size - 1) {
            this.last = forSearching.prev;
        } else {

            int counter = 0;
            while (counter <= index + 1) {
                if (counter == index - 1) {
                    prevForRemove = forSearching;
                }
                if (counter == index + 1) {
                    nextForRemove = forSearching;
                }
                forSearching = forSearching.next;
                counter++;
            }
            prevForRemove.next = nextForRemove;
            nextForRemove.prev = prevForRemove;
        }
        size--;
        if (size == 0) {
            this.first = null;
            this.last = null;
        }
    }

    public void clear() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    public int size() {
        return this.size;
    }

    public MyQueue.Node<E> peek() {
        return this.first;
    }

    public MyQueue.Node<E> poll() {
        if (size == 0) {
            return null;
        }
        Node<E> newFirst = this.first.next;
        Node<E> removable = this.first;
        this.first = newFirst;
        size--;
        if (size == 0) {
            this.last = null;
        }
        return removable;
    }

    @Override
    public String toString() {
        if (size == 0 && this.first == null && this.last == null) {
            return "[This MyQueue is clear!]";
        }
        StringBuilder MyQueueToString = new StringBuilder();
        MyQueueToString.append("[");
        MyQueue.Node<E> l = this.first;
        int count = 0;
        while (count < size) {
            if (count == size - 1) {
                MyQueueToString.append(l);
                count++;
            } else {
                MyQueueToString.append(l).append("; ");
                l = l.next;
                count++;
            }
        }
        MyQueueToString.append("]");
        return new String(MyQueueToString);
    }
}
