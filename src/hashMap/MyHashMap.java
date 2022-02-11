package hashMap;

class Node<K, V> {

    private K key;
    private V value;
    private Node<K, V> next;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<K, V> getNext() {
        return next;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }

}

public class MyHashMap<K, V> {
    Node<K, V> head;

    //  put(Object key, Object value) добавляет пару ключ + значение
    public void put(K key, V value) {
        Node<K, V> newNode = new Node<>();
        newNode.setValue(value);
        newNode.setKey(key);
        if (head == null) {
            head = newNode;
        } else {
            Node<K, V> last = head;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(newNode);
        }

    }

    //	size() возвращает размер коллекции

    public int size() {
        if (head == null) {
            return 0;
        }
        int LinkedListSize = 1;
        Node<K, V> last = head;
        while (last.getNext() != null) {
            last = last.getNext();
            LinkedListSize++;
        }
        return LinkedListSize;
    }

    //	remove(Object key) удаляет пару по ключу
    public void remove(K key) {
        Node<K, V> request = head;

        if (request.getKey() != key) {
            while (request.getKey() != key) {
                request = request.getNext();
            }
        }
        request.setKey(null);
        request.setValue(null);
        request.setNext(request.getNext().getNext());

    }

    //	clear() очищает коллекцию
    public void clear() {

        while (head.getNext() != null) {
            head = head.getNext();
        }
        head = null;
    }

    //  get(Object key) возвращает значение(Object value) по ключу
    public V get(K key) {
        Node<K, V> request = head;

        if (request.getKey() != key) {
            while (request.getKey() != key) {
                request = request.getNext();
            }
        }
        return request.getValue();
    }
}

class MyHashMapTest {

    public static void main(String[] args) {
        MyHashMap<String, Integer> carsPricesHashMap = new MyHashMap<>();


        System.out.println("carsPricesHashMap.size() = " + carsPricesHashMap.size());//size 0
        //  put
        carsPricesHashMap.put("BMW X5", 100_000);
        carsPricesHashMap.put("Volvo S80", 9000);
        carsPricesHashMap.put("Lada Largus", 2000);
        carsPricesHashMap.put("Toyota CAMRY", 28_000);

        //	size()
        System.out.println("carsPricesHashMap.size() = " + carsPricesHashMap.size());//size 4

        //  get
        System.out.println("carsPricesHashMap.get(BMW X5) = " + carsPricesHashMap.get("BMW X5"));
        System.out.println("carsPricesHashMap.get(\"Toyota CAMRY\") = " + carsPricesHashMap.get("Toyota CAMRY"));
        System.out.println("carsPricesHashMap.get(Lada Largus) = " + carsPricesHashMap.get("Lada Largus"));
        System.out.println("carsPricesHashMap.get(Volvo S80) = " + carsPricesHashMap.get("Volvo S80"));

        //	remove
        carsPricesHashMap.remove("Volvo S80");
        System.out.println("carsPricesHashMap.size() = " + carsPricesHashMap.size());

        //	clear()
        carsPricesHashMap.clear();
        System.out.println("carsPricesHashMap.size() = " + carsPricesHashMap.size());
    }
}
