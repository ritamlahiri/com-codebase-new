package com.dsa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Two pointer use cases = { Array and Linked List related questions
// ,Sorted array,remove duplicate,merge array,detect cycle, pair or triplet answers}
public class TwoPointerAlgorithm {

    // rotate and array by k steps
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

    // Two sum -> find the sum of 2 elements with a target
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

    // Remove duplicates from sorted array
    public int[] removeDuplicateNumbers(int[] nums) {
       // test array : 2,2,4,4,4,9,9,9,9,9,11,11
        int first =0;
        int second = first+ 1;
        int result[] = new int[nums.length];
        result[0]= nums[first];
        int resultCount =1;

        while(second<nums.length){
            if(nums[second]!=nums[first])
            {
                result[resultCount++]=nums[second];
                first=second;
                second++;
            }
            else{
                second++;
            }
        }
        return result;
    }

}
