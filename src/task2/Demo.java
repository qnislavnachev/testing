package task2;

public class Demo {
    public static void main(String[] args) {
        ArrayCiltivator arrayCiltivator = new ArrayCiltivator();
        int[] arr = new int[]{5,3,6,8,9,12,1,2,4};

        arrayCiltivator.printArrayElements(arr);
        int min = arrayCiltivator.getMinElement(arr);
        System.out.println("\n" + min);

        int sum = arrayCiltivator.getSum(arr);
        System.out.println(sum);

        arrayCiltivator.reverseArray(arr);
        arrayCiltivator.printArrayElements(arr);

    }
}
