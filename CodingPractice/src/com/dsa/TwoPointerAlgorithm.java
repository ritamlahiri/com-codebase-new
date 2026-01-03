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
        int uniqueElementCounter =1;
        while(second<nums.length){
            if(nums[second]!=nums[first])
            {
                result[resultCount++]=nums[second];
                first=second;
                second++;
                uniqueElementCounter++;
            }
            else{
                second++;
            }
        }
        System.out.println("Number of unique elements :"+uniqueElementCounter);
        return result;
    }

    public void mergeSortedArrayAndReturnResultantArray(int[] arr1, int[] arr2){
        int firstArrayCounter =0 ;
        int secondArrayCounter =0;
        int[] resultantArray = new int[arr1.length+arr2.length];

        int resultCounter =0;
        while((firstArrayCounter<arr1.length)&&(secondArrayCounter<arr2.length)){
            if(arr1[firstArrayCounter]<arr2[secondArrayCounter]){
                resultantArray[resultCounter]= arr1[firstArrayCounter] ;
                firstArrayCounter++;
            }
            else{
                resultantArray[resultCounter]= arr2[secondArrayCounter] ;
                secondArrayCounter++;
            }
            resultCounter++;
        }

        if(firstArrayCounter>secondArrayCounter){
            while(secondArrayCounter<arr2.length){
                resultantArray[resultCounter]= arr2[secondArrayCounter];
                secondArrayCounter++;
                resultCounter++;
            }
        }else{
            while(firstArrayCounter<arr1.length){
                resultantArray[resultCounter]= arr1[firstArrayCounter];
                firstArrayCounter++;
                resultCounter++;
            }
        }

        for(int k=0;k< resultantArray.length;k++){
            System.out.print(resultantArray[k]+" ");
        }

    }

    public void squareOfSortedArrayinSortedOrderWithNegatives(int[] arr){

        int pos=0; int neg=0; int i=0;
        while(i<arr.length){
            if(arr[i]<0) neg++;
            else pos++;
            i++;
        }
        int[] posArray = new int[pos];
        int[] negArray = new int[neg];

        i=0; int m=0; int n=0;
        while(i<arr.length){
            if(arr[i]<0) {
                negArray[m]=arr[i];
                m++;
            }
            else {
                posArray[n]=arr[i];
                n++;
            }
            i++;
        }
        i=0;
        while(i<negArray.length){
            negArray[i] = negArray[i]*negArray[i];
            i++;
        }
        i=0;

        int start = 0;
        int end = negArray.length-1;
        int temp = 0;

        while(start<end)
        {
            temp =negArray[start];
            negArray[start] = negArray[end];
            negArray[end]=temp;
            start++;end--;
        }

        while(i<posArray.length){
            posArray[i]=posArray[i]*posArray[i];
            i++;
        }
        // merge two arrays

        int posArrayCounter =0;
        int negArrayCounter = 0;
        int[] mergedArray = new int[posArray.length+negArray.length];

        int mergeArrayCounter = 0 ;
        while((posArrayCounter<posArray.length)&&(negArrayCounter<negArray.length)){
           if(posArray[posArrayCounter]<negArray[negArrayCounter]){
               mergedArray[mergeArrayCounter] = posArray[posArrayCounter];
               posArrayCounter++;
           }else{
               mergedArray[mergeArrayCounter] =negArray[negArrayCounter];
               negArrayCounter++;
           }
            mergeArrayCounter++;
        }
        int x =0 ;

        if(posArrayCounter!=posArray.length){
            while(posArrayCounter<posArray.length){
                mergedArray[mergeArrayCounter] = posArray[posArrayCounter];
                posArrayCounter++;
            }
        }else{
            while(negArrayCounter<negArray.length){
                mergedArray[mergeArrayCounter] = negArray[negArrayCounter];
                negArrayCounter++;
            }
        }
        int b=0;
        while(b< mergedArray.length){
            System.out.print(mergedArray[b]+" ");
            b++;
        }
    }
}
