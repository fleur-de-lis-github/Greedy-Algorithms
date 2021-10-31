/* Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.

Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.

 

Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
Example 2:

Input: hand = [1,2,3,4,5], groupSize = 4
Output: false
Explanation: Alice's hand can not be rearranged into groups of 4.

 

Constraints:

1 <= hand.length <= 104
0 <= hand[i] <= 109
1 <= groupSize <= hand.length */

class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand == null) { return false; }
        int n = hand.length;
        if (n % W != 0) { return false; }
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int c: hand) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        while (map.size() > 0) {
            int first = map.firstKey();
            for (int i = first; i < first + W; i++) {
                if (!map.containsKey(i)) {
                    return false;
                }
                int num = map.get(i);
                if (num == 1) {
                    map.remove(i);
                } else {
                    map.put(i, num - 1);
                }
            }
        }
        
        return true;
    }
}
 
