package javastream;

import java.util.ArrayList;
import java.util.List;

public class JavaStreamExamples {

    public static void main(){

        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);


    }
    private void filterEvenNumbers(List<Integer> list){

        list.stream().filter(n->n%2==0)
                .toList().forEach(System.out::println);

    }

}
