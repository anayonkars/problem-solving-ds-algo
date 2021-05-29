//https://leetcode.com/problems/remove-element/
/*
Method is given an input array containing 0 or more duplicate elements. Also,
 a number is provided which is supposed to be removed from array.
The method should remove all occurrences of given element from given array
'in place' - i.e. without using any extra array, and actual input array should
be modified. Further method should return length of new array after removing
all occurrences of given element.

Solution approach:
The idea is - maintain two pointers. One will point to index at which element
 should be replaced by some other element (of course, when a[i] == element to
  be removed).
Second pointer will keep on searching for element to be remved.
So, ptr1 = 0, ptr2 = 0 and iterate the array
if current element == element to be removed then increase ptr2
else move replace a[ptr1] with a[ptr2] and increase ptr1 and ptr2
Basically, ptr2 will keep track of first occurrence of element which is not
element to be removed, but occurs after element to be removed.
Whereas, ptr1 will keep track of first occurrence of element which is to be
removed.
e.g. 0,1,2,2,3,0,4,2 and element to be removed = 2
so, ptr1 will stop at 2 (a[2] == 2) and ptr2 will stop at 4 (a[4] = 3) and
then, a[2] = a[4], eliminating first occurrence of 2.
Further, ptr1 will stop at 3 and a[3] will be replaced by a[5].
Finally, when array is traversed fully, ptr1 will reach at end of new array -
 i.e. with all occurrences of required element removed.
 */
public class RemoveElement {

}
