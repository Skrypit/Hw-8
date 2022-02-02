import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MyArrayList<E> {
    private int arraySize = 10;
    private Object[] array = new Object[arraySize];
    private int i = 0;

    // add(Object value) додає елемент в кінці
    public void add(Object value) {
        int lastIndex = array.length - 1;
        if (i == lastIndex) {
            array = Arrays.copyOf(array, arraySize * 2);
        }
        array[i] = value;
        i++;
    }

    // remove(int index) видаляє елемент за індексом
    public void remove(int index) {

        array[index] = null;
        for (int i = index; i < array.length - 1; i++) {
            array[index] = array[index++];
        }
    }

    // clear() очищує колекцію
    public void clear() {

        for (Object element : array) {
            element = null;
        }

    }

    // size() повертає розмір колекції
    public int size() {
        int thisArraySize = 0;
        for (Object element : array) {
            if (element != null) {
                thisArraySize++;
            }
        }
        return thisArraySize;
    }

    // get(int index) повертає елемент за індексом
    int index = 5;

    public Object get(int index) {
        return array[index];
    }

}
//
//class MyArrayListTest {
//    public static void main(String[] args) {
//     List<String> names = new ArrayList<>();
//
//
//    }
//}



