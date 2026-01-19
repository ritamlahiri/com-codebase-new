package com.dsa;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HashMapDemoQuestions {

  public void firstNonRepeatingCharacterInAString(){
      // first unique character in a string
      // Java 8

      String str ="helloworldleetcode";

      char ch1 = str.chars().mapToObj(ch ->(char)ch).
              collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
              .entrySet().stream()
              .filter(entry ->entry.getValue()>1)
              .map(Map.Entry::getKey).findFirst().get();

      //   System.out.println("First Non repeating character in a string : "+ch1);

      // Non Using Java 8 - Simple old java program

      Map<Character,Integer> map =new HashMap<>();

      for(char c : str.toCharArray()){
          if(map.containsKey(c)){
              int val =map.get(c);
              map.put(c,val+1);
          }else {
              map.put(c,1);
          }
      }

      for(char c:str.toCharArray()){
          if(map.get(c)==1){
              System.out.println(" First Non-repeating character in String : "+c);
              break;
          }
      }
      System.out.println(map);
  }

  public void ranSomeNoteFromMagazineProblem(){
      String ransome ="aabbff";

      String magazine= "wwssfrraaabbb";
      Map<Character,Integer> have = new HashMap<>();
      Map<Character,Integer> need = new HashMap<>();


      for(char c: magazine.toCharArray()){
          if(have.containsKey(c)){
              int val = have.get(c);
              have.put(c,val+1);
          }else{
              have.put(c,1);
          }
      }

      for(char c: ransome.toCharArray()){
          if(need.containsKey(c)){
              int val = need.get(c);
              need.put(c,val+1);
          }else{
              need.put(c,1);
          }
      }
      boolean isRansomAchieved=true;
      for(char c : ransome.toCharArray()){
          if(have.get(c)<need.get(c)){
              isRansomAchieved=false;
              break;
          }
      }
      if(isRansomAchieved)
        System.out.println(" True : Ransom Achieved : ");
      else System.out.println(" False - Ransom cannot be achieved : ");
  }
    public void minBalloons(){
       String balloon ="weehhccc";
       String masterString ="fffrrrrttghhdffdgfqwwwwwfcccccdwdedddddesesesesesewewewehkhkhkhhkhkhkhk";

       Map<Character,Integer> need = new HashMap<>();
       Map<Character,Integer> have = new HashMap<>();

       for(char c: balloon.toCharArray()){
           if(need.containsKey(c)){
               int val = need.get(c);
               need.put(c,val+1);
           }else {
               need.put(c,1);
           }
       }

        for(char c: masterString.toCharArray()){
            if(have.containsKey(c)){
                int val = have.get(c);
                have.put(c,val+1);
            }else {
                have.put(c,1);
            }
        }
        List<Integer> list =new ArrayList<>();

        boolean isMinBalloonPossible = true ;
        for(char c: balloon.toCharArray()){
          int need_var = need.get(c);
          int have_var = have.get(c);
          if(have_var<need_var){
              isMinBalloonPossible = false;
              System.out.println(" Minimum Balloon Not possible at all : ");
              return;
          }
          int times = have_var/need_var;
          list.add(times);
      }
      //  System.out.println(list);
        if(isMinBalloonPossible){
           int minBalloon = list.stream().min(Comparator.comparing(Integer::valueOf)).get();
            System.out.println(" Minimum Number of Balloons formed : "+minBalloon);
        }
    }
  }

