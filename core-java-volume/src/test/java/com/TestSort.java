package com;

import org.junit.Test;

/**
 * @Description:
 * @Author:Antonio
 * @Date:Created in 22:40 2019/5/4
 */
public class TestSort {

    @Test
    public void testBobblingSortMy(){
        int nums[] = {1,1,2,67,23,154,8,123,56,78,10,344,5678,23,5,34,568,123,780,2,6,9,1};

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(nums[i] > nums[j]){
                    int temp =nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        for (int num:nums) {
            System.out.println(num);
        }
    }

    @Test
    public void testBobblingSortOther(){
        int nums[] = {1,1,2,67,23,154,8,123,56,78,10,344,5678,23,5,34,568,123,780,2,6,9,20};
        int end = nums.length -1;
        while(end > 0){
            boolean exchange = false;
            for(int i = 0;i < end;i++) {
                if(nums[i]>nums[i+1])
                {
                    int temp =nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                    exchange = true;
                }
            }
            if(exchange == false)
                break;
            end--;

        }
        for (int num:nums) {
            System.out.println(num);
        }
    }

    @Test
    public void testSelectionSort(){
        int nums[] = {1,1,2,67,23,154,8,123,56,78,10,344,5678,23,5,34,568,123,780,2,6,9,20};
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        for (int num:nums) {
            System.out.println(num);
        }
    }
}

