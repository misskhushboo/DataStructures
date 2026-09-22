package javastream;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaStringStreamExample {
    public static void main(){
        JavaStringStreamExample streamEx=new JavaStringStreamExample();
        //streamEx.countLettersStartingWithA(List.of("Apple","Banana", "Air"));
        //streamEx.joinAllStringsSeparatedByComma(List.of("A","B", "A"));
        //streamEx.findFirstNonEmptyString();
       // streamEx.groupByLengthOfString();
        streamEx.countOccurenceEachElement();
    }

    private void countLettersStartingWithA(List<String> strList){
        long count=strList.stream().filter(str-> str.startsWith("A")).count();
        List<String> Astring=strList.stream().filter(str-> str.startsWith("A")).toList();
        System.out.println("Strings starting with A="+Astring);         //[Apple, Air]
    }

    private void joinAllStringsSeparatedByComma(List<String> strList){

        String Astring=strList.stream().collect(Collectors.joining());
        System.out.println("Composite String="+Astring);        //Composite String=ABA

        Astring=strList.stream().collect(Collectors.joining((",")));
        System.out.println("Composite String="+Astring);        //Composite String=A,B,A

        Astring=strList.stream().collect(Collectors.joining(",","[","]"));
        System.out.println("Composite String="+Astring);            //Composite String=[A,B,A]
    }

    private void findFirstNonEmptyString(){
        List<String> listStr=List.of("A","", "A");

        listStr.stream().filter(n-> !n.isEmpty()).findFirst()
                .ifPresent(n->System.out.println("Find First string which is non-empty:"+n));       //A
    }

    private void groupByLengthOfString(){
        Map<Integer, List<String>> map=List.of("Apple","Banana", "Air").stream()
                .collect(Collectors.groupingBy(str->str.length()));

        System.out.println("Map="+map);
        //Map={3=[Air], 5=[Apple], 6=[Banana]}
    }

    private void countOccurenceEachElement(){

        //Function.identity returns the same input argument with no change.
        //First Apple will be passed in as argument which will be saved.
        //Against Apple,it will keep on counting.

        Map<String, Long> map=List.of("Apple","Banana", "Air").stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Map="+map);
        //Map={Apple=1, Air=1, Banana=1}
    }

}
