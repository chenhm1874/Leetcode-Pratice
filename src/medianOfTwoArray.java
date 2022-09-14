public class medianOfTwoArray {
    public static double findMedianSortedArrays(int[] A,int[] B){
        int m=A.length;
        int n=B.length;
        int p1=0;
        int p2=0;
        int left=-1,right=-1;
        for(int i=0;i<(m+n)/2;i++){
            left = right;
            // p2 右移
            if (p1 >= A.length || p2 < B.length && A[p1] > B[p2]){
                right = B[p2++];
            }
            // p1 右移
            else {
                right = A[p1++];
            }
        }
        return (m + n) % 2 == 1 ? right : (left + right) / 2.0;
    }
}
