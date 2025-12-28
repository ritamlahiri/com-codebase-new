package com.dsa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Two pointer use cases = { Array and Linked List related questions
// ,Sorted array,remove duplicate,merge array,detect cycle, pair or triplet answers}
public class TwoPointerAlgorithm {
    public void rotate(int[] nums, int k) {
        if(k>nums.length) return ;
            int i=0;
            int j = i+k;
            int[] result =new int[nums.length];
            while(j<nums.length){
                 result[j]=nums[i];
                 i++; j++;
            }
            for(int m=0;m<k;m++){
                result[m] = nums[i];
                i++;
            }
        nums= Arrays.copyOf(result,nums.length);
          for(int y=0;y<nums.length;y++){
              System.out.print(nums[y]+" ");
          }
    }
    public void twoSum(){
        int[] arr= {88,4,1,22,7,11,2,15};
        int start=0;
        int end= arr.length-1; int target = 9;
        Arrays.sort(arr);
        while(start<end){
            if((arr[start]+arr[end])<target){
                start++;
            }
            else if((arr[start]+arr[end])>target){
                end--;
            }
            else {
                System.out.println(" Numbers are " + arr[start] + " ," + arr[end]);
                break;
            }
        }
    }


    public void twoSum(int[] numbers, int target)
    {
        int[] result= new int[2];
        int start=0;
        int end= numbers.length-1;
        Arrays.sort(numbers);
        while(start<end){
            if((numbers[start]+numbers[end])<target){
                start++;
            }
            else if((numbers[start]+numbers[end])>target){
                end--;
            }else{  if(start==0){
                result[0]= start+1;
                result[1]= end+1;
            } else{
                result[0]=start;
            }
                result[1]= end;
            }
        }
    }
}
