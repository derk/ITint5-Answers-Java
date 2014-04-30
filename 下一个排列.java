public class NextPermutation {
    public boolean nextPermutation(int[] arr) {
        if(arr == null || arr.length <= 1) {
            return false;
        }
        int curr = arr.length -2;
        while(curr>=0) {
            if(arr[curr]<arr[curr+1]) {
                break;
            }
            curr--;
        }
        if(curr <0) {
            return false;
        }
        //now curr is index of first number in wrong order
        int curr1 = arr.length - 1;
        while(arr[curr1] <= arr[curr]) {
            curr1--;
        }
        //swap
        int t =arr[curr1];
        arr[curr1]=arr[curr];
        arr[curr]=t;
        //reverse
        int i =curr+1;
        int j=arr.length-1;
        while(j>i){
            t=arr[i];
            arr[i]=arr[j];
            arr[j]=t;
            j--;
            i++;
        }
        return true;
    }
}
