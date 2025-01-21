package CodingInterview;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int counterInArr = 0;
        int counterMaxOccur = 0;
        for (int item : nums) {
            while (item == 1) {
                counterMaxOccur++;
            }
        }
    }

    public static void main (String[] args) {

    }
}
