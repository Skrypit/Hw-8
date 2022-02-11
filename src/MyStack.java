//Написать свой класс MyStack как аналог классу Stack, который работает по принципу LIFO (last-in-first-out).
import java.util.Arrays;

public class MyStack<S> {
    private final int arraySize = 5;
    private S[] array = (S[]) new Object[arraySize];
    private int i = 0;

    //    push(Object value) добавляет элемент в конец
    public void push(S value) {
        int lastIndex = array.length - 1;
        if (i == lastIndex) {
            array = Arrays.copyOf(array, arraySize * 2);
        }
        array[i] = value;
        i++;
        System.out.println("Push element= " + Arrays.toString(array));
    }

    //  remove(int index) удаляет элемент под индексом
    public void remove(int index) {

        array[index] = null;
        for (int i = index; i < array.length - 1; i++) {
            array[index] = array[index++];
        }
        System.out.println("Remove element by index = " + Arrays.toString(array));
    }

    // clear() очищает коллекцию
    public void clear() {
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = null;
        }
        System.out.println("Clear Stack = " + Arrays.toString(array));

    }

    // peek() возвращает первый элемент в стеке (LIFO)
    public void peek() {
        int index = 0;

        for (S element : array) {
            if (element != null) {
                index++;
            }
        }
        System.out.println("Stack lastElement = " + array[index - 1]);
    }
    //       size() возвращает размер коллекции
    public void size() {
        int thisArraySize = 0;
        for (S element : array) {
            if (element != null) {
                thisArraySize++;
            }
        }
        System.out.println("Stack size = " + thisArraySize);
    }
    //      pop() возвращает первый элемент в стеке и удаляет его из коллекции

    public void pop() {
        int index = 0;

        for (S element : array) {
            if (element != null) {
                index++;
            }
        }
        System.out.println("Stack lastElement = " + array[index - 1]);
        array[index - 1] = null;
        System.out.println("Stack lastElement after remove = " + array[index - 1]);
    }

}

class MyStackTest {
    public static void main(String[] args) {
        MyStack <String> carsStack = new MyStack<>();
        carsStack.size();
        //carsStack.push
        carsStack.push("BMW");

        carsStack.push("Volvo");
        carsStack.push("Lada");
        carsStack.push("Toyota");

//	 remove
        carsStack.remove(3);

//	 size()
        carsStack.size();

//	 peek()
        carsStack.peek();

//   pop()
        carsStack.pop();

//   clear()
        carsStack.clear();
        carsStack.size();
    }
}
