
import java.util.LinkedList;
import java.util.List;

public class LinkNode<E> {

    <E> data;
    LinkNode next;

    public LinkNode(E item) {

        E data = item;

    }

}


public class MyLinkedList<E> {
    Node<E> head;
    Node<E> tail;

    //add(Object value) добавляет элемент в конец
    public void add(Object value) {
        Node newNode = (Node) value;
        if(head==null){
            head = newNode;
        } else {
            while(head.next != null) {
                head = head.next;
            }
        }
        head.next = newNode;

    }

    //     удаляет элемент под индексом
    public void remove(int index) {

    }

    //    очищает коллекцию
    public void clear() {

    }

    // возвращает размер коллекции
    public int size() {

        return size;
    }

//     возвращает элемент под индексом */
    public Object get(int index) {

        return ;
    }

}

class MyLinkedListTest {

    public static void main(String[] args) {
        List<String> carsList = new LinkedList<>();
        //add
        carsList.add("Mersedes");
        carsList.add("Volvo");
        carsList.add("BMW");

        System.out.println("carsList = " + carsList);

        MyLinkedList <String> moreCarsList = new MyLinkedList<>();

        moreCarsList.add("Zaz");
        moreCarsList.add(0, "Tavria");
        carsList.addAll(moreCarsList);

        System.out.println("carsList = " + carsList);
        //remove
        carsList.remove(0);
        System.out.println("carsList = " + carsList);
        //get

        System.out.println("carsList get 4th element = " + carsList.get(3));
        //size
        System.out.println("carsList size = " + carsList.size());
        //clear
        //System.out.println("Clear carsList = " + carsList.clear());

    }
}
/* public class Runner {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.insert(12); //12
        list.insertAtStart(191); //191 12 43
        list.insertAt(2, 2222); //191 12 2222 43
        list.deleteAt(2); //191 12 43
        list.show();
    }

 */