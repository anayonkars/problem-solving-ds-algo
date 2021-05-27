//https://leetcode.com/problems/sum-of-all-subset-xor-totals/

/*
Take XOR of all subsets and sum all the results.
Input: [1,3]
xor([]) = 0
xor([1]) = 1
xor([3]) = 3
xor([1,3]) = 2
result = 0 + 1 + 3 + 2 = 6

Input: [5,1,6]
xor([]) = 0
xor([5]) = 5
xor([1]) = 1
xor([6]) = 6
xor([5,1]) = 4
xor([5,6]) = 3
xor([1,6]) = 7
xor([5,1,6]) = 2
result = 0 + 5 + 1 + 6 + 4 + 3 + 7 + 2 = 28

 */

public class SumOfAllSubsetXorTotals {
    public int subsetXORSum(int[] nums) {
        int result = 0;
        for(int num : nums) {
            result |= num;
        }
        return result * (1 << nums.length - 1);
    }

    public static void main(String[] args) {
        SumOfAllSubsetXorTotals sumOfAllSubsetXorTotals = new SumOfAllSubsetXorTotals();
        System.out.println(sumOfAllSubsetXorTotals.subsetXORSum(new int[]{1,3}));
        System.out.println(sumOfAllSubsetXorTotals.subsetXORSum(new int[]{5,1,6}));
    }
}
