public class findMininRotatedArray {
    public int findMin(int[] array){
        if(array.length==0){
            return array[0];
        }
        int left=0;
        int right=array.length-1;
        if(array[right]>array[0]){
            return array[0];
        }
        while(right>=left) {
            int mid = left + (right - left) / 2;
            if(array[mid]>array[mid+1]){
                return array[mid+1];
            }
            if(array[mid-1]>array[mid]){
                return array[mid];
            }
            if(array[mid]>array[0]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return Integer.MAX_VALUE;
    }
}
