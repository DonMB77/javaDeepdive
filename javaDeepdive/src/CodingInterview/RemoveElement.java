package CodingInterview;

import java.util.Arrays;

//27
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(nums, val));
    }

    

    public static int removeElement(int[] nums, int val) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = 101;
            }
        }
        Arrays.sort(nums);
        int counterRemaining = 0;
        for (int item : nums) {
            if (item != 101) {
                counterRemaining++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return counterRemaining;
    }
}


