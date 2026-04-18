class Solution {
    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }
    private int reverse(int n){
        int num = 0;
        while(n != 0){
            int temp = n % 10;
            num = num * 10 + temp;
            n /= 10;
        }
        return num;
    }
}