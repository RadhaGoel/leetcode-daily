class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        double mid = 0.0;
        int arr[] = new int[m+n];
        for(int i = 0; i < m; i++){
            arr[i] = nums1[i];
        }
        int j = 0;
        for(int i = m; i < m+n; i++){
            arr[i] = nums2[j++];
        }
        for(int i = 0; i < arr.length - 1; i++){
            for(int k = 0; k<arr.length - 1; k++){
                if(arr[k] > arr[k+1]){
                    int temp = arr[k];
                    arr[k] = arr[k+1];
                    arr[k+1] = temp;
                }
            }
        }
        if((m+n)%2!=0){
            mid = arr[(m+n)/2];
            return mid;
        }
        else{
            mid = arr[(m+n)/2] + arr[((m+n)/2)-1];
            return mid/2;        
        }
    }
}