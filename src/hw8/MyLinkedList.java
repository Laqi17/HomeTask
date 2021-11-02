package hw8;

public class MyLinkedList<E> {
    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;

    public MyLinkedList() {
    }

    private static class Node<E> {
        Node<E> prev;
        E element;

        Node<E> next;
        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }

    }

    public void addLastElement(E e) {
        Node<E> addNode = lastNode;
        Node<E> newElement = new Node<>(addNode, e, null);
        lastNode = newElement;
        if (addNode == null) {
            firstNode = newElement;
        } else addNode.next = newElement;
        size++;
    }

    public boolean add(E e) {
        addLastElement(e);
        return true;
    }

    public void remove(int index) {
        Node<E> node = getNode(index);
        if (node.prev == null) firstNode = node.next;
        else node.prev.next = node.next;
        if (node.next == null) lastNode = node.prev;
        else node.next.prev = node.next;
        size--;

    }

    public void clear() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    private Node<E> getNode(int index) {
        Node<E> node = firstNode;
        if (index >= 0 && index <= size) {
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        }
        return node;
    }

    public E get(int index) {
        Node<E> node = firstNode;
        if (index >= 0 && index < size) {
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        }
        else {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
        return node.element;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "firstNode=" + firstNode +
                ", lastNode=" + lastNode +
                ", size=" + size +
                '}';
    }

}