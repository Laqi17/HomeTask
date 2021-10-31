package hw8;

public class MyHashMap<K, V> {

    private static final int DEFAULT_LENGTH = 16;
    private int size;
    private Node<K, V>[] tables;

    static class Node<K, V> {
        private final K key;
        private V value;
        private Node<K, V> next;
        private int hashCode;

        public Node(K key, V value, int hashCode, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            this.value = value;
            return value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    public MyHashMap() {
        tables = new Node[DEFAULT_LENGTH];
    }

    public V get(Object key) {
        int index = findIndex(hash(key));
        Node<K, V> node = tables[index];
        for (Node<K, V> n = node; n != null; n = n.next) {
            if ((key == null && null == n.getKey()) || (key != null && key.equals(n.getKey()))) {
                return n.value;
            }
        }
        return null;
    }

    public V put(K key, V value) {
        int hashCode = hash(key);
        int index = findIndex(hashCode);
        Node<K, V> node = tables[index];
        if (node == null) {
            tables[index] = new Node(key, value, hashCode, null);
        } else {
            for (Node<K, V> n = node; n != null; n = n.next) {
                K nodeKey = n.getKey();
                if ((key == null && null == nodeKey) || (key != null && key.equals(nodeKey))) {
                    V oldValue = n.getValue();
                    n.setValue(value);
                    return oldValue;
                }
                if (n.next == null) {
                    n.next = new Node<>(key, value, hashCode, null);
                    break;
                }
            }
        }
        size++;
        return null;
    }

    public void clear() {
        tables = new Node[DEFAULT_LENGTH];
        size = 0;
    }

    public int size() {
        return size;
    }

    public int hash(Object key) {
        return key == null ? 0 : key.hashCode() >>> 16;
    }

    private int findIndex(int hashCode) {
        int index = Math.abs(hashCode) % DEFAULT_LENGTH;
        return index;
    }

    public V remove(K key) {
        if (size > 0) {
            Node<K, V> first, n;
            K k;
            int i = getIndex(key), hash = hash(key);
            if ((first = tables[i]) != null) {
                if ((k = (K) first.key) == key || k.equals(key) && hash == first.hashCode) {
                    tables[i] = first.next;
                    size--;
                    return first.value == null ? null : (V) first.value;
                }
                if (first.next != null) {
                    for (n = first.next; n != null; n = n.next, first = first.next) {
                        if ((k = (K) n.key) == key || k.equals(key) && hash == n.hashCode) {
                            first.next = n.next;
                            size--;
                            return n.value == null ? null : (V) n.value;
                        }
                    }
                }
            }
        }
        return null;
    }

    protected int getIndex(K key) {
        if (key == null) {
            return 0;
        }
        int hash = hash(key);
        return ((tables.length - 1) & hash);
    }

}