package task1;

public class Demo {
    public static void main(String[] args) throws Exception {
        Sumator math = new Sumator();
        double result = 0.0;
        try {
            result = math.sum(null, "2");
        }catch (IllegalArgumentException e){
            System.out.println("Illegal format");
        }
        System.out.println(result);
    }
}
