class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int []fq = new int[26];
        int i = 0, j = 0, ans = 0, mxf = 0;

        while(j < n){
            fq[s.charAt(j) - 'A']++;
            mxf = Math.max(mxf, fq[s.charAt(j)-'A']);

            while((j - i + 1) - mxf > k ){
                fq[s.charAt(i) - 'A']--;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}