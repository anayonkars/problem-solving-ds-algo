//https://leetcode.com/problems/number-of-recent-calls/

/*
The idea is to implement a class with below functionalities:
Constructor will initialize the object.
Method ping will accept time t. This will be called multiple times.
Problem is at each invocation of ping, method should return how many requests
has happened in last 3000 milliseconds. In other words, find number of times
ping was called during t and t - 3000 (both inclusive).
ping(1) -> total requests : {1}. There are total 1 requests in range -2999,1
ping(100) -> total requests : {1,100}. There are total 2 requests in range
-2900,100
ping(3001) -> total requests : {1,100,3001}. There are total 3 requests in
range 1,3001
ping(3002) -> total requests : {1,100,3001,3002}. There are total 3 requests in
range 2,3002

Solution Approach:
Idea is to maintain a sliding window. When ping is invoked, t will be added
to it. However, all time stamps less than t - 3000 will be removed. Now, the
size of sliding window is the answer.

*/

import java.util.LinkedList;

public class NumberOfRecentCalls {
    private LinkedList<Integer> slidingWindow;

    public NumberOfRecentCalls() {
        this.slidingWindow = new LinkedList<>();
    }

    public int ping(int t) {
        this.slidingWindow.add(t);
        while(this.slidingWindow.getFirst() < t - 3000) {
            this.slidingWindow.removeFirst();
        }
        return slidingWindow.size();
    }

    public static void main(String[] args) {
        NumberOfRecentCalls numberOfRecentCalls = new NumberOfRecentCalls();
        System.out.println(numberOfRecentCalls.ping(1));
        System.out.println(numberOfRecentCalls.ping(100));
        System.out.println(numberOfRecentCalls.ping(3001));
        System.out.println(numberOfRecentCalls.ping(3002));
    }
}
