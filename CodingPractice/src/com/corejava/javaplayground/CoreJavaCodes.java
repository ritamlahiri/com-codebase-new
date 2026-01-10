package com.corejava.javaplayground;

import com.corejava.functionalinterface.MyFunctionalInterface;
import com.corejava.model.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CoreJavaCodes { public static void test_code_method_7(){
    char[] charArray= {'a','c','e','h','e','c','a'};
    char[] reversed = new StringBuilder(new String(charArray))
            .reverse()
            .toString()
            .toCharArray();
    System.out.println(Arrays.toString(reversed));

    // check if character array is palindrome or not

    int start=0; int end = charArray.length-1;
    boolean isPalindrome =true;
    while(start < end){
        if(charArray[start++]!=charArray[end--]){
            isPalindrome = false; break;
        }
    }
    if(isPalindrome){
        System.out.println("Palindrome Array");
    }else {
        System.out.println("Not a Palindrome Array");
    }
    // *********************************************************************

    // count frequency of each character
    Map<Character,Long> map =new String(charArray).chars().mapToObj(ch-> (char)ch).
            collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

    System.out.println("count map : "+map);

    // remove duplicates from char array

    char[] newArr = new String(charArray).chars().distinct().
            mapToObj(ch->String.valueOf((char)ch)).collect(Collectors.joining(","))
            .toCharArray();

    for(char c: charArray){
        System.out.print(c);
    }



}

    public static void test_code_method_6(){
        // 2nd largest element in array

        int[] arr={22,12,16,11,18,10,33};

        int largest =arr[0];
        int secondlargest =arr[1];

        for(int i=1;i<arr.length;i++){
            if(arr[i]>largest){
                secondlargest=largest;
                largest=arr[i];
            }
            if((arr[i]>secondlargest)&&(largest>arr[i])){
                secondlargest=arr[i];
            }
        }
       /* System.out.println("Largest element :"+largest);
        System.out.println(" Second largest element :"+secondlargest);*/

        // reverse an array

        int start=0;
        int end = arr.length-1;
        int[] reversedArray = new int[arr.length];
        while((start<=(arr.length-1))&&(end>=0)){
            reversedArray[start]= arr[end];
            start++; end--;
        }

       /* for(int i=0;i<reversedArray.length;i++){
            System.out.print(" "+reversedArray[i]);
        }*/
    }

    public void rotateArray(){

        int[] arr={4,5,1,2,9,3,7,1,0};
        int stepsToRotate = 3;
        int[] resultantArray= new int[arr.length];
        int originalArrayCounter =0;
        for(int i=stepsToRotate;i<resultantArray.length;i++){
            resultantArray[i]=arr[originalArrayCounter];
            originalArrayCounter++;
        }
        for(int k=0;k<stepsToRotate;k++){
            resultantArray[k]=arr[originalArrayCounter];
            originalArrayCounter++;
        }
        for(int j=0;j<resultantArray.length;j++){
            System.out.print(" "+resultantArray[j]);
        }
    }
    public static void test_code_method_5(){
        // Find Duplicate Characters in String

        String str ="waterfall";
        System.out.println("Duplicate characters in string are : ");
        str.chars().mapToObj(ch -> (char)ch).
                collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue()>1)
                .map(Map.Entry::getKey)
                .forEach(c -> System.out.println(c));

        //Find Longest Word in Sentence

        String sentence ="test data computer science";

        String longestWord = Arrays.stream(sentence.split(" ")).max(Comparator.comparing(String::length)).get();
        System.out.println("longestWord "+longestWord);
    }
    public static void test_code_method_4(){
        //Count Frequency of Each Character in String
        String str="Computer";
        Map<Character,Long>  map = str.chars().mapToObj(ch ->(char)ch).collect(Collectors.groupingBy(ch-> ch, Collectors.counting()));
        System.out.println(map);

        // filter the vowels from a string

        System.out.println("Vowels of String are : ");
        str.chars().mapToObj(ch ->(char)ch).
                filter(c -> (c=='a'||c=='e' || c=='i' || c=='o' || c=='u'))
                .forEach(c -> System.out.println(c));

        // Find First Non-Repeated Character

        Character cha= str.chars().mapToObj(c -> (char)c).
                collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue()==1)
                .map(Map.Entry:: getKey)
                .findFirst().orElse('z');
        if(cha!='z')
            System.out.println(" First repeating char "+cha);

        // reverse all words of a sentence
        String sentence ="Hello world computer data";
        List<String> list=Arrays.asList( sentence.split(" "));
        String reversed  =list.stream().map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(","));
        System.out.println("Sentence with words reversed : "+reversed);

        // String palindrome check - without lambda || without reverse method
        String string ="abccbad";
        boolean isPalindrome=true;
        int start=0;
        int end = string.length()-1;
        StringBuffer reverse= new StringBuffer();
        while(start< end){
            if(string.charAt(start)!=string.charAt(end))
            {
                System.out.println("Not Palindrome String");
                isPalindrome=false;
                break;
            }
            start++;
            end--;
        } if(isPalindrome==true){
            System.out.println(" Palindrome String");
        }


    }

    public static void test_code_method_3(){
        Integer[] arr={13,12,4,5,1,8,7,5,1,9};


        // second largest element
        int largest = arr[0];
        int secondLargest= arr[1];

        for(int i=1 ; i<arr.length-1; i++){
            if(arr[i]>largest){
                secondLargest = largest;
                largest=arr[i];
            }
            if((arr[i]>secondLargest)&&(arr[i]<largest)){
                secondLargest = arr[i];
            }
        }

        System.out.println("largest element in array : "+largest);
        System.out.println("Second Largest element in array : "+secondLargest);
    }
    public static void test_code_method_2(){
        List<String> names = List.of("test","data","dusk","compliance","driver","meeting","multilevel");
        // count frequency of each word

        Map<String,Long> map = names.stream().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Frequency map "+map);

        List<Employee> employeeList = employees();
        System.out.println(employeeList);





    }


    public static List<Employee> employees(){

        List<Employee> employeeList = new ArrayList<>();
        Employee e1= new Employee(1232,"Andrew","Australia");
        Employee e2= new Employee(6572,"Zack","New Zealand");
        Employee e3= new Employee(3298,"Philip","Portugal");
        Employee e4= new Employee(5411,"Sam","USA");
        Employee e5= new Employee(1011,"Kane","Brazil");
        Employee e6= new Employee(4095,"Bill","England");
        Employee e7= new Employee(2991,"Matthew","Germany");

        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);
        employeeList.add(e6);
        employeeList.add(e7);

        return employeeList;

    }
    public static void test_code_method_1(){
        System.out.println(" Started Coding ");
        List<Integer> integerList = new ArrayList<>();
        integerList.add(22);
        integerList.add(9);
        integerList.add(7);
        integerList.add(6);
        integerList.add(11);
        integerList.add(12);
        integerList.add(15);
        integerList.add(1);
        System.out.println( integerList.stream().filter(number -> number%2==0).collect(Collectors.toList()));

        // sum of squares of numbers

        int sum = integerList.stream().map(n -> n*n).reduce((a,b) -> a+b ).get();
        System.out.println("Sum of sqaures : "+sum);

        // grouping by first letter
        List<String> names = List.of("test","data","dusk","compliance","driver","meeting","multilevel");

        Map<Character,List<String>> result = names.stream().collect(Collectors.groupingBy(name -> name.charAt(0)));

        System.out.println("Resultant map : "+result);

        // functional interface implementation
        MyFunctionalInterface myFunctionalInterface= (a, b)->  {return a+b;};

        int func = myFunctionalInterface.test(4,8);
        System.out.println("Functional Interface result : "+ func);

        // second highest number
        int second = integerList.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0);
        System.out.println("Second highest number : "+second);

        System.out.println(" #####################################################  ");
        secondHighestNumberFinder(integerList);

    }

    public static void secondHighestNumberFinder(List<Integer> integerList2){
        int largest= integerList2.get(0) ;//9
        int secondLargest = integerList2.get(1) ; //2


        // 2,9,7,6
        for(int i=1;i<integerList2.size()-1;i++){
            if(integerList2.get(i)>largest){
                secondLargest = largest;
                largest = integerList2.get(i);
            }
            else if((integerList2.get(i) < largest) && (integerList2.get(i) > secondLargest)){
                secondLargest = integerList2.get(i);
            }
        }
        System.out.println("Largest number : "+largest);
        System.out.println("Second Largest number : "+secondLargest);
    }
}
