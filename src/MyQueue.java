import java.util.Arrays;

public class MyQueue<E> {
    private int arraySize = 10;
    private E[] array = (E[]) new Object[arraySize];
    private int i = 0;


    //   add(Object value) добавляет элемент в конец
    public void add(E value) {

        int lastIndex = array.length;

        if (i == lastIndex) {
            array = Arrays.copyOf(array, arraySize * 2);
        }
        if (array[i] == null) {
            array[i] = value;
        }
        i++;

    }

    //	 remove(int index) удаляет элемент под индексом
    public void remove(int index) {

        array[index] = null;
        for (int i = index; i < array.length - 1; i++) {
            array[index] = array[index++];
        }
        System.out.println("Remove element by index = " + Arrays.toString(array));
    }

    //	 clear() очищает коллекцию
    public void clear() {
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = null;
        }
        //System.out.println("Clear Queue = " + Arrays.toString(array));

    }

    //	 size() возвращает размер коллекции
    public void size() {
        int thisArraySize = 0;
        for (E element : array) {
            if (element != null) {
                thisArraySize++;
            }
        }
        System.out.println("Queue size = " + thisArraySize);
    }

    //	 peek() возвращает первый элемент в очереди (FIFO)
    public E peek() {
        return array[0];
    }

    // poll() возвращает первый элемент в очереди и удаляет его из коллекции
    public void poll() {
        int firstElementIndex = 0;

        array[firstElementIndex] = null;
        System.out.println("Queue firstElement after remove = " + array[firstElementIndex]);
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i++];
        }
        arraySize--;
    }
    // show показує елементи
    public void show() {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != null) {
                System.out.println("Queue element = " + array[i]);
            }
        }
    }

}

class MyQueueTest {

    public static void main(String[] args) {
        MyQueue<String> carsQueue = new MyQueue<>();

//    add
        carsQueue.add("BMW");
        carsQueue.add("Volvo");
        carsQueue.add("Lada");
        carsQueue.add("Toyota");

//	 remove
        carsQueue.remove(3);

//	 size()
        carsQueue.size();
//     show
        carsQueue.show();

//	 peek()
        System.out.println("Queue firstElement(peek) = " + carsQueue.peek());

//   poll()
        carsQueue.poll();
        carsQueue.add("Toyota");
//   clear()
        carsQueue.clear();
        carsQueue.size();


    }

}
