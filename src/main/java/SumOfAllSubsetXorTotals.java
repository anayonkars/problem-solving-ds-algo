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

Solution idea:
Consider the final result in binary. ith bit of final result will be set if
xor of at least one subarray has ith bit set. On the other hand, ith bit of
result will not be set if ith bit of all xor-ed subsets is 0.
Now, we have to figure out how may possible combinations we can have where
ith bit is set.
Lets assume that there are total k numbers whose ith bit is set. Meaning,
total n-k number are present whose ith bit is not set. Basically, we end up
with an array of size n with k ones and n-k zeroes, and we have to figure out
 number of possible combinations whose xor is 1.
If xor of two number is to be 1, then exactly one of those numbers must be 1
. Now, we have to divide our array into two parts - one containing all 1s and
 another containing all 0s.
We'll figure out ways in which first part (all 1s) results in 1 when xor-ed.
If we have only ones, then we must choose odd number of ones for result of
xor to be 1.
So - how many such combinations are possible? Answer is ways in which 1 one
can be picked + ways in which 3 ones can be picked + ways in which 5 ones
can be picked - till k.
This is same as kC1 + kC3 + kC5 + kC7 + ... This actually comes to 2 ^ (k-1).
E.g. 5C1 + 5C3 + 5C5 = 5 + 10 + 1 = 16 = 2 ^ (5-1).
So we have established that there are total 2^(k-1) ways in which we can
perform xor on an array of all ones and get result of xor as 1.
Coming to second part of array - containing all zeroes. There is simply no
way we can create 1 out of xoring zeros in any combinations. However, we know
that we've counted ways in which we can generate 1 by xoring elements in
first part of array (i.e. all ones). On same lines can figure our ways in which
we  can generate 0 by xoring elements in second part of array (i.e. all
zeores). Since we have only zeroes, number of all possible combinations
(because all combinations will give 0 after xoring) = 2 ^ (n-k) - because
there are total n-k elements here.
Now, we know that there are 2^(k-1) ways in which we can generate 1 from all
ones, and there are 2^(n-k) ways in which we can generate 0 from all zeroes.
Meaning, there are total 2^(k-1) * 2^(n-k) ways in which we can have 1 from
first part (all ones) and 0 from second part (all zeroes). And this is number
of ways in which we can get 1 from xoring all possible subsequences of the
array (containing k ones and n-k zeroes).
Total number of ways = 2^(k-1) * 2^(n-k) = 2^(k-1+n-k) = 2^(n-1).
Interesting thing here to note is - this total number of ways is independent
of number of k. However, we'll have to check if k = 0, meaning, there doesn't
exist a single number where ith bit is set. Then we'll have to ignore it. The
easiest thing we can do to figure out if at least one bit is set is - or-ing
all the bits.
So - for ith bit, there are total 2^(n-1) ways in which it can be set
by xoring all possible combinations of ith bit of all numbers.
Hence, if we take logical or of all numbers, the result will tell us if there
exist at least one number whose ith bit is set.
Thus, all we'll have to do is take logical or of all numbers, and multiply it
with 2^(n-1)
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
