/* In a warehouse, there is a row of barcodes, where the ith barcode is barcodes[i].

Rearrange the barcodes so that no two adjacent barcodes are equal. You may return any answer, and it is guaranteed an answer exists.

 

Example 1:

Input: barcodes = [1,1,1,2,2,2]
Output: [2,1,2,1,2,1]
Example 2:

Input: barcodes = [1,1,1,1,2,2,3,3]
Output: [1,3,1,3,1,2,1,2]
 

Constraints:

1 <= barcodes.length <= 10000
1 <= barcodes[i] <= 10000 */

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
      
        int maxFreqCode = 0, i = 0, n = barcodes.length;
        int[] freq = new int[10_001], ans = new int[n];
        for (int c : barcodes) { // count the frequency of each code.
            if (++freq[c] > freq[maxFreqCode]) { // update the code of max frequency.
                maxFreqCode = c;
            }
        }
        for (int j = 0; j < freq.length; ++j) {
            int code = j == 0 ? maxFreqCode : j; // fill in most frequent code first.
            while (freq[code]-- > 0) { // fill codes of positive frequencies.
                ans[i] = code;
                i = i + 2 < n ? i + 2 : 1; // fill even indices first, if depleted, use odd ones.
            }
        }
        return ans;
    }    
    }
