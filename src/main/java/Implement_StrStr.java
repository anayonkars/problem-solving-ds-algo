//https://leetcode.com/problems/implement-strstr/
/*
Problem is to find out if given string is substring of another string.
If it is substring, then return first index at which substring occurs.
Else, return -1.

Solution approach:
Keep 2 pointers.
Run 2 nested loops - 1 for each string.
Take a matching counter and keep on increasing as long as str1[i]==str2[j]
If matching counter = second string, we've found substring at current i -
str2.length()
Else, if we are at end of str1, then return -1.
 */
public class Implement_StrStr {
}
