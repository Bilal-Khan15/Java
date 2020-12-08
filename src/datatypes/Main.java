package datatypes;

public class Main {

    public static void main(String[] args){
        Character equals = '=';
        String phrase = "Final value ";

        Wrapper wrapper = new Wrapper();
        Long num6 = wrapper.getLong();
        wrapper.num5 = num6 / 7.0;

        
        if(wrapper.flag){
            wrapper.printFinalValue(phrase, equals);
        }
    }
}
