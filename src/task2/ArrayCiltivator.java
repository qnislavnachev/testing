package task2;

import java.util.Arrays;

public class ArrayCiltivator {
    private final int[] arr;

    public ArrayCiltivator(int[] arr) {
        this.arr = arr;
    }

    public int getMinElement() {
        if (arr.length == 0) {
            System.out.println("There is no elements!");
        }
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    public int getSum() {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public void printArrayElements() {
        System.out.print(Arrays.toString(arr));


    }

    public int[] reverseArray() {
        for (int i = 0; i < arr.length / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = tmp;
        }
        return arr;
    }

}
