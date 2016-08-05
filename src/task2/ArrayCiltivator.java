package task2;

import java.util.Arrays;

public class ArrayCiltivator {

    public int getMinElement(int [] arr){
        int min=arr[0];
        for(int i=0; i < arr.length; i++){
            if (min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }

    public int getSum(int [] arr) {
        int sum = 0;
        for (int i = 0; i <arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public int[] printArrayElements(int [] arr){
        return arr;

    }

    public int[] reverseArray(int [] arr){
        for(int i=0;i<arr.length/2;i++){
            int tmp = arr[i];
            arr[i]=arr[arr.length-i-1];
            arr[arr.length-i-1]=tmp;
        }
        return arr;
    }

}
