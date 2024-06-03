Day_19;

import java.util.Arrays;

public class GenericClassesAndMethods {

    public static <T> void swap(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        swap(intArray, 0, 4);
        System.out.println("Swapped Integer array: " + Arrays.toString(intArray));

        String[] strArray = {"a", "b", "c", "d", "e"};
        swap(strArray, 1, 3);
        System.out.println("Swapped String array: " + Arrays.toString(strArray));
    }
}

