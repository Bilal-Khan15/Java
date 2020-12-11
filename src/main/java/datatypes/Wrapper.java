package datatypes;

public class Wrapper {
    public Boolean flag = true;
    public Byte num1 = 123;
    public Short num2 = 456;
    public Integer num3 = 789;
    public Long num4 = 50000L + 10L * (num1 + num2 + num3);
    public Double num5;

    public Long getLong(){
        return num4;
    }

    public void printFinalValue(String phrase, Character equals){
        System.out.println(phrase + equals + " " + String.format("%.2f", num5));
    }
}
