package linkedList;

class Node<E> {
    private E element;
    private Node<E> next;
    private Node<E> prev;

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}

public class MyLinkedList<E> {
    private Node<E> head;
    private Node<E> last;

    //add(Object value)  додає елемент в кінці
    public void add(E value) {
        Node<E> newNode = new Node<>();
        newNode.setElement(value);

        if (head == null) {
            head = newNode;
        } else {
            Node<E> last = head;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(newNode);
        }
    }

    //remove(int index) видаляє елемент за індексом
    public void remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        if (index == 0) {
            head = head.getNext();

        } else {
            Node<E> toRemove = head;
            for (int i = 0; i < index; i++) {
                toRemove = toRemove.getNext();
            }
            if (toRemove.getNext() == null) {
                toRemove.setPrev(null);
                last = toRemove.getPrev();
            } else {

                toRemove.setNext(null);
                toRemove.setPrev(null);

                toRemove.setNext(toRemove.getPrev());
                toRemove.setPrev(toRemove.getNext());
            }
            toRemove.setElement(null);
        }

    }

    //clear() очищує колекцію
    public void clear() {
        if (head == null) {
            System.out.println("Linked list is empty already!");
        } else {
            Node<E> currentNode = head;

            currentNode.setElement(null);
            currentNode.setNext(null);
            currentNode.setPrev(null);

        }
        head = last = null;
        System.out.println("Linked list is cleared!");
    }

    // size() повертає розмір колекції
    public int size() {
        if (head == null) {
            return 0;
        }
        int LinkedListSize = 1;
        Node<E> last = head;
        while (last.getNext() != null) {
            last = last.getNext();
            LinkedListSize++;
        }
        return LinkedListSize;
    }

    // get(int index) повертає елемент за індексом
    public E get(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }

        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        Node<E> request = head;
        if (index == 0) {
            return request.getElement();
        } else {
            for (int i = 1; i < index; i++) {
                request = request.getNext();
            }
        }
        return request.getElement();
    }
}

class MyLinkedListTest {

    public static void main(String[] args) {
        MyLinkedList<String> carsList = new MyLinkedList<>();

        //empty list
        System.out.println("list.size() = " + carsList.size());
        //add
        carsList.add("Mercedes");
        carsList.add("Volvo");
        carsList.add("BMW");
        //size
        System.out.println("list.size after adding = " + carsList.size());

        //get
        System.out.println("carsList get second element = " + carsList.get(2));

        //remove
        carsList.remove(1);
        System.out.println("list.size after removing = " + carsList.size());

        //clear
        carsList.clear();
        System.out.println("list.size after clear = " + carsList.size());

    }
}
