public class MergeSort {
    public int[] mergeSort(int[] nums, int left, int right) {
        if (left>=right) return nums;
        int mid = left+(right-left)/2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);
        merge(nums, left, mid, right);
        return nums;
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right-left+1];
        int i=left;
        int j=mid+1;
        int idx=0;
        while (i<=mid&&j<=right) {
            if (nums[i]<=nums[j]) {
                temp[idx++]=nums[i];
                i++;
            } else {
                temp[idx++]=nums[j];
                j++;
            }
        }
        while (i<=mid) {
            temp[idx++]=nums[i];
            i++;        
        }
        while (j<=right) {
            temp[idx++]=nums[j];
            j++;        
        }
    
        for (int k=0; k<temp.length; k++){
            nums[k+left] = temp[k];
        }
    }
}