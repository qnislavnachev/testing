package task1;

public class Sumator {
        public double sum(String a, String b) throws Exception {
            if(a == null || b == null){
                throw new IllegalArgumentException();
            }
            return Double.parseDouble(a) + Double.parseDouble(b);
        }
}
