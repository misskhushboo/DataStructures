package javastream;

import java.util.*;
import java.util.stream.Collectors;

public class JavaIntegerStreamExamples {
    //List->Stream->Filter (intermediate) ->map (intermediate) / distinct ->reduce (terminal)
    //List->Stream->intStream (intermediate) ->average (intermediate) / result (terminal)
    public static void main(){

        JavaIntegerStreamExamples obj=new JavaIntegerStreamExamples();
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10,11);
        //obj.filterEvenNumbers(list);
        //obj.squareEvenNumbers(list);
        //obj.findFirstNumberGreaterThan10(List.of(13,11,12));
        //obj.countNumbersGreaterThan7(list);
        //obj.findSumProductOfAllNumbers(list);
        //obj.findSumOfEvenNumbers(list);
        //obj.findMaximumNumberInList(List.of(13,52,12));
        //obj.sumOfSquaresOfEvenNumbers(List.of(1,2,4));
       // obj.removeAllDistinctElements(List.of(4,4,1));
        //obj.findAverage(List.of(4,8,3));
        //obj.sortAscOrder(List.of(4,8,3,3));
       // obj.validateAllNumbersArePositive(List.of(4,8,3,3));
       // obj.validateIfAnyNumberIsDivibleBy3();
       // obj.flattenAList();
        //obj.findSecondHighestNumber();
        obj.partitionEvenOddNumbers();
    }
    private void filterEvenNumbers(List<Integer> list){

        List<Integer> intList=list.stream().filter(n->n%2==0)
                .toList();
        System.out.println("Filtering even numbers= "+intList);
    }

    private void squareEvenNumbers(List<Integer> list){

        List<Integer> intList=list.stream().filter(n->n%2==0)
                .map(i->i*i)
                .toList();

        System.out.println("Square even numbers: "+intList);

    }

    private void findFirstNumberGreaterThan10(List<Integer> list){

        Optional<Integer> optInt=list.stream().filter(n->n>10).findFirst();
        if(optInt.isPresent())
                System.out.println("First number before sorting: "+optInt.get());
        else System.out.println("No number greater than 10");
        //After sorting

        list.stream().filter(n->n>10).sorted().findFirst().
                ifPresent(n->System.out.println("First number before sorting:"+n));

    // First number before sorting: 13
    // First number before sorting:11
  }

    private void countNumbersGreaterThan7(List<Integer> list){

        long count=list.stream().filter(n->n>7).count();
        System.out.println("Count Number Greater than 10:  "+count);

  }

    private void findSumProductOfAllNumbers(List<Integer> list){
        //we want to reduce the elements into a single element.

        //Optional<Integer> optInt=list.stream().reduce(Integer::sum);
        //Optional<Integer> optInt1=list.stream().reduce((a,b)->Integer.sum(a,b));
        Optional<Integer> optInt2=list.stream().reduce((a,b)->a+b);
        System.out.println("Sum of all numbers: "+optInt2.get());

    }

    private void findSumOfEvenNumbers(List<Integer> list){
        //we want to reduce the elements into a single element.

        //Optional<Integer> optInt=list.stream().reduce(Integer::sum);
        //Optional<Integer> optInt1=list.stream().reduce((a,b)->Integer.sum(a,b));
        Optional<Integer> optInt2=list.stream().filter(n-> n%2==0).reduce((a,b)->a+b);
        System.out.println("Sum of all even numbers: "+optInt2.get());

    }

    private void findMaximumNumberInList(List<Integer> list){

        Optional<Integer> optInt=list.stream().max((a,b)->Integer.compare(a,b));
        System.out.println("Maximum number in list: "+optInt.get());

        Optional<Integer> optInt1=list.stream().reduce( (a,b)-> Integer.max(a,b));
        System.out.println("Maximum number in list: "+optInt1.get());
    }

    private void sumOfSquaresOfEvenNumbers(List<Integer> list){

        list.stream().filter(n-> n%2==0).map(n-> n*n)
                .reduce((a,b)-> Integer.sum(a,b))
                .ifPresent(n->System.out.println("Sum of squares of even numbers="+n));
    }

    private void removeAllDistinctElements(List<Integer> list){
        //will not maintain insertion order.
        Set<Integer> set=list.stream().collect(Collectors.toSet());
        System.out.println("Distinct Elements="+set);     // Distinct Elements=[1, 4]

        //Maintains insertion order
        List<Integer> list1=list.stream().distinct().toList();
        System.out.println("Distinct Elements="+list1);     // Distinct Elements=[4, 1]
  }

  private void findAverage(List<Integer> list){

        //For each Integer it will convert to int value
       list.stream().mapToInt(Integer::intValue).average().
               ifPresent(n->System.out.println("Converting Integer object to int and then calculate average:"+n));
  }

    private void sortAscOrder(List<Integer> list){
        //For Integers we don't need to specify what to compare on, numbers will be compared and sorted.
        //For string we have to specify on what basis to sort.
        //Natural order
       List<Integer> ascOrder=list.stream().sorted().toList();
       System.out.println("Natural Order Asc: Sorted List"+ascOrder);       //[3,3, 4, 8]

        List<Integer> descOrder=list.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("Sorted List"+descOrder);                        //[8, 4, 3,3]

        //remove duplicates and then sort
        List<Integer> descOrder1=list.stream().distinct().sorted(Comparator.reverseOrder()).toList();
        System.out.println("Sorted List"+descOrder1);                       //[8, 4, 3]
    }

    private void validateAllNumbersArePositive(List<Integer> list){

        boolean condition=list.stream().allMatch(n->n>0);
        System.out.println("Are all numbers are positive?"+condition); //true
    }

    private void validateIfAnyNumberIsDivibleBy3(){
        List<Integer> list= List.of(4,8,1,1);
        boolean condition=list.stream().anyMatch(n->n%3==0);
        System.out.println("Is any number divisbile by 3?"+condition); //false
    }

    private void flattenAList(){

        List<List<Integer>> listlist= List.of( List.of(1), List.of(2));
        System.out.println("UnFlat List: "+listlist);       //[[1], [2]]

        List<Integer> singleList=listlist.stream().flatMap(list-> list.stream()).toList();
        System.out.println("Flat List: "+singleList);       //[1, 2]

    }

    private void findSecondHighestNumber(){
        List<Integer> listStr=List.of(3,4,1);

        listStr.stream().sorted().skip(1).findFirst()
                .ifPresent(n->System.out.println("Find 2nd highest number:"+n));       //3
    }

    private void partitionEvenOddNumbers(){
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10,11);

        //PartioningBy will always give two groups - true or false. No custom group.
        Map<Boolean, List<Integer>> map=list.stream().collect(Collectors.partitioningBy(n->n%2==0));

        System.out.println("Even Number List:"+ map.get(true));         //Even Number List:[2, 4, 6, 8, 10]
        System.out.println("Odd Number List:"+ map.get(false));         //Odd Number List:[1, 3, 5, 7, 9, 11]
    }


}
