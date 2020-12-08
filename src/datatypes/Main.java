package datatypes;

public class Main {

    public static void main(String[] args){
        boolean flag = true;
        byte num1 = 123;
        short num2 = 456;
        int num3 = 789;
        long num4 = 50000 + 10 * (num1 + num2 + num3);

        if(flag){
            double num5 = num4 / 7.0d;
            String phrase = "Final value = ";

            System.out.println(phrase + String.format("%.2f", num5));
        }
    }
}
