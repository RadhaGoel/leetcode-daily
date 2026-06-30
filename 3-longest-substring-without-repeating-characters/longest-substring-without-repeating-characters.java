class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n  = s.length();
        int fq[] = new int[128];
        int j = 0, i = 0, ans = 0, dup = 0;

        //window for last < n
        while(j < n){
            fq[s.charAt(j)]++;
            if(fq[s.charAt(j)] == 2) dup++; // add if duplicate

            //shrink window until no duplicate
            while(i < j && dup > 0){
                fq[s.charAt(i)]--;
                if(fq[s.charAt(i)] == 1) dup--;
                i++;
            }

            //update ans
            ans = Math.max(ans, j - i + 1);
            j++;
        } 
        return ans;
    }
}