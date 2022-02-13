import java.util.Arrays;

public final class MyArrayList<T> {
    private final int arraySize = 5;
    private T[] array = (T[]) new Object[arraySize];
    private int i = 0;

    // add(Object value) додає елемент в кінці
    public void add(T value) {
        int lastIndex = array.length;
        if (i == lastIndex) {

            array = Arrays.copyOf(array, arraySize * 2);
        }
        array[i] = value;
        i++;
    }

    // remove(int index) видаляє елемент за індексом
    public void remove(int index) {

        array[index] = null;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == null) {
                array[i] = array[i++];
                //array[i++] = array[i+1];
            }
        }
        System.out.println("Remove element by index = " + Arrays.toString(array));
    }

    // clear() очищує колекцію
    public void clear() {
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = null;
        }

    }

    // size() повертає розмір колекції
    public void size() {
        int thisArraySize = 0;
        for (int i = 0; i <= array.length - 1; i++) {
            if (array[i] != null) {
                thisArraySize++;
            }
        }
        System.out.println("ArrayList size = " + thisArraySize);
    }

    // get(int index) повертає елемент за індексом
    public T get(int index) {
        return array[index];
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

class MyArrayListTest {
    public static void main(String[] args) {

        MyArrayList<String> myCarsList = new MyArrayList<>();

        //add
        myCarsList.add("BMW");
        myCarsList.add("Volvo");
        myCarsList.add("Lada");
        myCarsList.add("Toyota");
        myCarsList.add("Ford");
        myCarsList.add("Reno");
        //size()
        myCarsList.size();

        //remove(int index)
        myCarsList.remove(3);

        //size()
        myCarsList.size();

        //show
        myCarsList.show();

        //get(int index)
        System.out.println("ArrayList.get = " + myCarsList.get(1));

        //clear()
        myCarsList.clear();
        //myCarsList.add("Reno");
        myCarsList.size();


    }

}



