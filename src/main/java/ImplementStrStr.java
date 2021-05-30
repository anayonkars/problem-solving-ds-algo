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
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.isEmpty()) {
            return 0;
        }
        if(haystack == null || haystack.isEmpty()) {
            return -1;
        }
        if(needle.length() > haystack.length()) {
            return -1;
        }
        if(haystack.equals(needle)) {
            return 0;
        }
        int result = -1;
        char[] chars = haystack.toCharArray();
        char[] input = needle.toCharArray();
        int matching = 0;
        int i = 0;
        for( ; i < chars.length ; i++) {
            matching = 0;
            if(chars[i] != input[0]) {
                continue;
            }
            matching++;
            for(int j = 1 ; j < input.length ; j++) {
                if(i + j >= chars.length || input[j] != chars[i + j]) {
                    break;
                }
                matching++;
            }
            if(matching >= input.length) {
                return i;
            }
        }
        return matching >= input.length ? i : -1;
    }

    public static void main(String[] args) {
        ImplementStrStr implementStrStr = new ImplementStrStr();
        System.out.println(implementStrStr.strStr("hello", "ll"));
        System.out.println(implementStrStr.strStr("hello", "elo"));
    }
}
